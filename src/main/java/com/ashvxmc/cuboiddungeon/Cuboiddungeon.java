package com.ashvxmc.cuboiddungeon;

import com.ashvxmc.cuboiddungeon.entities.DungeonSnakeEntity;
import com.ashvxmc.cuboiddungeon.entities.MarsupialRatEntity;
import com.ashvxmc.cuboiddungeon.entities.RheumSlimeEntity;
import com.ashvxmc.cuboiddungeon.items.*;
import com.ashvxmc.cuboiddungeon.items.materials.ImbuedDaggerMaterials;
import com.ashvxmc.cuboiddungeon.items.materials.StaffToolMaterials;
import com.ashvxmc.cuboiddungeon.items.scrolls.ScrollOfDispel;
import com.ashvxmc.cuboiddungeon.items.scrolls.ScrollOfRage;
import com.ashvxmc.cuboiddungeon.items.scrolls.ScrollOfWaves;
import com.ashvxmc.cuboiddungeon.registry.ModBlocks;
import com.ashvxmc.cuboiddungeon.registry.ModItems;
import com.ashvxmc.cuboiddungeon.status_effects.RageStatusEffect;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import software.bernie.geckolib3.GeckoLib;

public class Cuboiddungeon implements ModInitializer {
    // Universal mod ID
    public static final String MOD_ID = "cuboiddungeon";
    // Item group registries
    public static final ItemGroup DUNGEON_ITEMS = FabricItemGroupBuilder.create(
            new Identifier("cuboiddungeon","dungeon_items"))
            .icon(() -> new ItemStack(ModItems.DUNGEON_BRICK_WALL))
            .build();
    public static final ItemGroup DUNGEON_CONSUMABLE = FabricItemGroupBuilder.create(
            new Identifier("cuboiddungeon","dungeon_consumables"))
            .icon(() -> new ItemStack(ModItems.BREEZEFRUIT))
            .build();
    public static final ItemGroup DUNGEON_MONSTERS = FabricItemGroupBuilder.create(
            new Identifier("cuboiddungeon","dungeon_monsters"))
            .icon(() -> new ItemStack(ModItems.MARSUPIAL_RAT_SPAWN_EGG))
            .build();

    // Entity registries
    public static final EntityType<MarsupialRatEntity> MARSUPIAL_RAT = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("cuboiddungeon", "marsupial_rat"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MarsupialRatEntity::new).dimensions(EntityDimensions.fixed(1f,1.5f)).build()
    );
    public static final EntityType<RheumSlimeEntity> RHEUM_SLIME = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("cuboiddungeon", "rheum_slime"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RheumSlimeEntity::new).dimensions(EntityDimensions.fixed(1f,1f)).build()
    );
    public static final EntityType<DungeonSnakeEntity> DUNGEON_SNAKE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("cuboiddungeon", "dungeon_snake"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DungeonSnakeEntity::new).dimensions(EntityDimensions.fixed(0.5f,0.75f)).build()
    );

    // Custom status effects
    public static final StatusEffect RAGE = new RageStatusEffect();

    // Features (Ores, structures, etc)
    private static ConfiguredFeature<?, ?> ORE_COBALT_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.COBALT_ORE.getDefaultState(),6))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    50)))
            .spreadHorizontally()
            .repeat(15);

    @Override
    public void onInitialize() {
        // Register external registry classes and libraries
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        GeckoLib.initialize();
        // Register Items with custom classes (INCLUDING WEAPONS)
        Registry.register(Registry.ITEM, new Identifier("cuboiddungeon","breezefruit_tea"), new BreezefruitTea(new FabricItemSettings().group(Cuboiddungeon.DUNGEON_CONSUMABLE).food((new FoodComponent.Builder().hunger(1).saturationModifier(0f).build()))));
        Registry.register(Registry.ITEM, new Identifier("cuboiddungeon", "dagger"), new Dagger(new ToolMaterials()));
        Registry.register(Registry.ITEM, new Identifier("cuboiddungeon","poisoned_dagger"), new PoisonedDagger(new ImbuedDaggerMaterials()));
        Registry.register(Registry.ITEM, new Identifier("cuboiddungeon","hardwood_staff"), new HardwoodStaff(new StaffToolMaterials()));
        Registry.register(Registry.ITEM, new Identifier("cuboiddungeon","scroll_of_rage"), new ScrollOfRage(new FabricItemSettings().group(Cuboiddungeon.DUNGEON_ITEMS)));
        Registry.register(Registry.ITEM, new Identifier("cuboiddungeon","scroll_of_dispel"), new ScrollOfDispel(new FabricItemSettings().group(Cuboiddungeon.DUNGEON_ITEMS)));
        Registry.register(Registry.ITEM, new Identifier("cuboiddungeon","scroll_of_waves"), new ScrollOfWaves(new FabricItemSettings().group(Cuboiddungeon.DUNGEON_ITEMS)));
        // Register mob behaviors
        FabricDefaultAttributeRegistry.register(MARSUPIAL_RAT, MarsupialRatEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(RHEUM_SLIME, RheumSlimeEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DUNGEON_SNAKE, DungeonSnakeEntity.createMobAttributes());
        // Register custom status effects
        Registry.register(Registry.STATUS_EFFECT, new Identifier("cuboiddungeon","rage"), RAGE);
        // Register custom feature generations
        RegistryKey<ConfiguredFeature<?, ?>> oreCobaltOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("cuboiddungeon", "ore_cobalt_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreCobaltOverworld.getValue(), ORE_COBALT_OVERWORLD );
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreCobaltOverworld);
    }
}
