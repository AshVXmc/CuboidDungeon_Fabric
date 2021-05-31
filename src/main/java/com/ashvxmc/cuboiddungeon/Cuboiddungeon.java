package com.ashvxmc.cuboiddungeon;

import com.ashvxmc.cuboiddungeon.entities.DungeonSnakeEntity;
import com.ashvxmc.cuboiddungeon.entities.MarsupialRatEntity;
import com.ashvxmc.cuboiddungeon.entities.RheumSlimeEntity;
import com.ashvxmc.cuboiddungeon.entities.StoneTalusEntity;
import com.ashvxmc.cuboiddungeon.registry.ModBlocks;
import com.ashvxmc.cuboiddungeon.registry.ModItems;
import com.ashvxmc.cuboiddungeon.status_effects.RageStatusEffect;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import software.bernie.geckolib3.GeckoLib;

import java.util.Random;

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
    public static final ItemGroup DUNGEON_WEARABLES = FabricItemGroupBuilder.create(
            new Identifier("cuboiddungeon","dungeon_wearables"))
            // placeholder shit
            .icon(() -> new ItemStack(ModItems.COBALT))
            .build();

    // Entity registries
    public static final EntityType<MarsupialRatEntity> MARSUPIAL_RAT = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("cuboiddungeon", "marsupial_rat"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MarsupialRatEntity::new).dimensions(EntityDimensions.changing(1f,1.5f)).build()
    );
    public static final EntityType<RheumSlimeEntity> RHEUM_SLIME = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("cuboiddungeon", "rheum_slime"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RheumSlimeEntity::new).dimensions(EntityDimensions.changing(1f,1f)).build()
    );
    public static final EntityType<DungeonSnakeEntity> DUNGEON_SNAKE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("cuboiddungeon", "dungeon_snake"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DungeonSnakeEntity::new).dimensions(EntityDimensions.changing(0.5f,0.75f)).build()

    );
    public static final EntityType<StoneTalusEntity> STONE_TALUS = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("cuboiddungeon", "stone_talus"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, StoneTalusEntity::new).dimensions(EntityDimensions.changing(0.5f,0.75f)).fireImmune().build()
    );

    // Custom status effects
    public static final StatusEffect RAGE = new RageStatusEffect();

    // Features (Ores, structures, etc)
    private static final ConfiguredFeature<?, ?> ORE_COBALT_OVERWORLD = Feature.ORE
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



        /*
         *  EVENTS REGISTRIES
         */

        // Soul sand event
        UseBlockCallback.EVENT.register((PlayerEntity player, World world, Hand hand, BlockHitResult blockHitResult) -> {
            ItemStack itemStack = player.getStackInHand(hand);

            if (player.getStackInHand(hand).getItem() == Items.GLASS_BOTTLE && world.getBlockState(blockHitResult.getBlockPos()).getBlock() == Blocks.SOUL_SAND) {

                int currentlyEmptySlot = player.inventory.getEmptySlot();
                Random random = new Random();
                int randInt = random.nextInt(3);

                if (!player.inventory.insertStack(new ItemStack(ModItems.BOTTLE_OF_SOULS))){
                    player.dropItem(new ItemStack(ModItems.BOTTLE_OF_SOULS), false);
                    if (randInt == 1){
                        WitherSkeletonEntity witherSkeletonEntity = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world);
                        world.spawnEntity(witherSkeletonEntity);
                        witherSkeletonEntity.updatePosition(player.getX(),player.getY(),player.getZ());
                    }
                } else {
                    player.inventory.insertStack(currentlyEmptySlot ,new ItemStack(ModItems.BOTTLE_OF_SOULS));
                    if (randInt == 1){
                        WitherSkeletonEntity witherSkeletonEntity = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world);
                        world.spawnEntity(witherSkeletonEntity);
                        witherSkeletonEntity.updatePosition(player.getX(),player.getY(),player.getZ());
                    }
                }
                itemStack.decrement(1);


                world.setBlockState(blockHitResult.getBlockPos(), Blocks.SOUL_SOIL.getDefaultState() ,3);
                player.playSound(SoundEvents.ITEM_BOTTLE_FILL, 2.0F, 1.0F);

                return ActionResult.success(world.isClient);
            }
            return ActionResult.PASS;
        });
    }
}
