package com.ashvxmc.cuboiddungeon;

import com.ashvxmc.cuboiddungeon.entities.DungeonSnakeEntity;
import com.ashvxmc.cuboiddungeon.entities.MarsupialRatEntity;
import com.ashvxmc.cuboiddungeon.entities.RheumSlimeEntity;
import com.ashvxmc.cuboiddungeon.items.*;
import com.ashvxmc.cuboiddungeon.registry.ModBlocks;
import com.ashvxmc.cuboiddungeon.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import software.bernie.geckolib3.GeckoLib;

public class Cuboiddungeon implements ModInitializer {

    // Universal mod ID
    public static final String MOD_ID = "cuboiddungeon";

    // Custom Item class registries (EXCLUDING WEAPONS)
    public static final BreezefruitTea BREEZEFRUIT_TEA = new BreezefruitTea(new FabricItemSettings().group(Cuboiddungeon.DUNGEON_CONSUMABLE).maxCount(1));

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

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        GeckoLib.initialize();

        // Register Items with custom classes (INCLUDING WEAPONS)
        Registry.register(Registry.ITEM, new Identifier("cuboiddungeon","breezefruit_tea"), new BreezefruitTea(new FabricItemSettings().group(Cuboiddungeon.DUNGEON_CONSUMABLE).food((new FoodComponent.Builder().hunger(1).saturationModifier(0f).build()))));
        Registry.register(Registry.ITEM, new Identifier("cuboiddungeon", "dagger"), new Dagger(new ToolMaterials()));
        Registry.register(Registry.ITEM, new Identifier("cuboiddungeon","poisoned_dagger"), new PoisonedDagger(new ImbuedDaggerMaterials()));

        // Register mob behaviors
        FabricDefaultAttributeRegistry.register(MARSUPIAL_RAT, MarsupialRatEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(RHEUM_SLIME, RheumSlimeEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DUNGEON_SNAKE, DungeonSnakeEntity.createMobAttributes());
    }
}
