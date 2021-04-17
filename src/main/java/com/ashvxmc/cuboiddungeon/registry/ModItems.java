package com.ashvxmc.cuboiddungeon.registry;

import com.ashvxmc.cuboiddungeon.Cuboiddungeon;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    // Food items
    public static final Item FOOD_RATION = new Item(new Item.Settings().group(Cuboiddungeon.DUNGEON_CONSUMABLE).food(new FoodComponent.Builder().hunger(10).saturationModifier(5f).meat().build()));
    public static final Item PASTY = new Item(new Item.Settings().group(Cuboiddungeon.DUNGEON_CONSUMABLE).food(new FoodComponent.Builder().hunger(10).saturationModifier(5f).meat().build()));
    public static final Item RAW_RAT_MEAT = new Item(new Item.Settings().group(Cuboiddungeon.DUNGEON_CONSUMABLE).food(new FoodComponent.Builder().hunger(10).saturationModifier(1.5f).meat().statusEffect(new StatusEffectInstance(StatusEffects.POISON,20*3),1).build()));
    public static final Item COOKED_RAT_MEAT = new Item(new Item.Settings().group(Cuboiddungeon.DUNGEON_CONSUMABLE).food(new FoodComponent.Builder().hunger(6).saturationModifier(2.5f).meat().build()));
    public static final Item BREEZEFRUIT = new Item(new Item.Settings().group(Cuboiddungeon.DUNGEON_CONSUMABLE).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.8f).snack().build()));
    public static final Item BREEZEFRUIT_ROLL = new Item(new Item.Settings().group(Cuboiddungeon.DUNGEON_CONSUMABLE).food(new FoodComponent.Builder().hunger(5).saturationModifier(1.25f).build()));
    public static final Item BREEZEFRUIT_PIE = new Item(new Item.Settings().group(Cuboiddungeon.DUNGEON_CONSUMABLE).food(new FoodComponent.Builder().hunger(9).saturationModifier(7f).build()));
    //Block items
    public static final BlockItem DUNGEON_BRICK_WALL = new BlockItem(ModBlocks.DUNGEON_BRICK_WALL, new Item.Settings().group(Cuboiddungeon.DUNGEON_ITEMS));
    public static final BlockItem DUNGEON_BRICK_WALL_MOSSY = new BlockItem(ModBlocks.DUNGEON_BRICK_WALL_MOSSY, new Item.Settings().group(Cuboiddungeon.DUNGEON_ITEMS));
    public static final BlockItem DUNGEON_BRICK_WALL_CRACKED = new BlockItem(ModBlocks.DUNGEON_BRICK_WALL_CRACKED, new Item.Settings().group(Cuboiddungeon.DUNGEON_ITEMS));
    public static final BlockItem DUNGEON_BRICK_WALL_CHISELED = new BlockItem(ModBlocks.DUNGEON_BRICK_WALL_CHISELED, new Item.Settings().group(Cuboiddungeon.DUNGEON_ITEMS));
    public static final BlockItem DUNGEON_BRICK_WALL_CUT = new BlockItem(ModBlocks.DUNGEON_BRICK_WALL_CUT, new Item.Settings().group(Cuboiddungeon.DUNGEON_ITEMS));
    // Spawn egg items
    public static final SpawnEggItem MARSUPIAL_RAT_SPAWN_EGG = new SpawnEggItem(Cuboiddungeon.MARSUPIAL_RAT, 0x675A53,0x855D5D, new Item.Settings().group(Cuboiddungeon.DUNGEON_MONSTERS));
    public static final SpawnEggItem RHEUM_SLIME_SPAWN_EGG = new SpawnEggItem(Cuboiddungeon.RHEUM_SLIME,0x06d3b3,0x20c3b9, new Item.Settings().group(Cuboiddungeon.DUNGEON_MONSTERS));
    public static final SpawnEggItem DUNGEON_SNAKE_SPAWN_EGG = new SpawnEggItem(Cuboiddungeon.DUNGEON_SNAKE,0x7cd507,0x7cd507,new Item.Settings().group(Cuboiddungeon.DUNGEON_MONSTERS));

    // Item Registries
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"food_ration"), FOOD_RATION);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"pasty"), PASTY);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"raw_rat_meat"), RAW_RAT_MEAT);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"cooked_rat_meat"), COOKED_RAT_MEAT);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"breezefruit"), BREEZEFRUIT);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"breezefruit_roll"), BREEZEFRUIT_ROLL);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"breezefruit_pie"), BREEZEFRUIT_PIE);


        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"dungeon_brick_wall"), DUNGEON_BRICK_WALL);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"dungeon_brick_wall_mossy"), DUNGEON_BRICK_WALL_MOSSY);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"dungeon_brick_wall_cracked"), DUNGEON_BRICK_WALL_CRACKED);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"dungeon_brick_wall_chiseled"), DUNGEON_BRICK_WALL_CHISELED);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"dungeon_brick_wall_cut"), DUNGEON_BRICK_WALL_CUT);

        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"marsupial_rat_spawn_egg"), MARSUPIAL_RAT_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"rheum_slime_spawn_egg"), RHEUM_SLIME_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"dungeon_snake_spawn_egg"), DUNGEON_SNAKE_SPAWN_EGG);
    }
}