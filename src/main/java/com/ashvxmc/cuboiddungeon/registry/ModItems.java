package com.ashvxmc.cuboiddungeon.registry;

import com.ashvxmc.cuboiddungeon.Cuboiddungeon;
import com.ashvxmc.cuboiddungeon.items.BreezefruitTea;
import com.ashvxmc.cuboiddungeon.items.materials.ImbuedDaggerMaterials;
import com.ashvxmc.cuboiddungeon.items.materials.StaffToolMaterials;
import com.ashvxmc.cuboiddungeon.items.materials.ToolMaterials;
import com.ashvxmc.cuboiddungeon.items.scrolls.*;
import com.ashvxmc.cuboiddungeon.items.weapons.Dagger;
import com.ashvxmc.cuboiddungeon.items.weapons.HardwoodStaff;
import com.ashvxmc.cuboiddungeon.items.weapons.PoisonedDagger;
import com.ashvxmc.cuboiddungeon.items.wearables.RingOfPower;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems  {
    // Food items
    public static final Item FOOD_RATION = new Item(new Item.Settings().group(Cuboiddungeon.DUNGEON_CONSUMABLE).food(new FoodComponent.Builder().hunger(10).saturationModifier(5f).meat().build()));
    public static final Item PASTY = new Item(new Item.Settings().group(Cuboiddungeon.DUNGEON_CONSUMABLE).food(new FoodComponent.Builder().hunger(10).saturationModifier(5f).meat().build()));
    public static final Item RAW_RAT_MEAT = new Item(new Item.Settings().group(Cuboiddungeon.DUNGEON_CONSUMABLE).food(new FoodComponent.Builder().hunger(10).saturationModifier(1.5f).meat().statusEffect(new StatusEffectInstance(StatusEffects.POISON,20*3),0.5f).build()));
    public static final Item COOKED_RAT_MEAT = new Item(new Item.Settings().group(Cuboiddungeon.DUNGEON_CONSUMABLE).food(new FoodComponent.Builder().hunger(6).saturationModifier(2.5f).meat().build()));
    public static final Item BREEZEFRUIT = new Item(new Item.Settings().group(Cuboiddungeon.DUNGEON_CONSUMABLE).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.8f).snack().build()));
    public static final Item BREEZEFRUIT_ROLL = new Item(new Item.Settings().group(Cuboiddungeon.DUNGEON_CONSUMABLE).food(new FoodComponent.Builder().hunger(5).saturationModifier(1.25f).build()));
    public static final Item BREEZEFRUIT_PIE = new Item(new Item.Settings().group(Cuboiddungeon.DUNGEON_CONSUMABLE).food(new FoodComponent.Builder().hunger(9).saturationModifier(7f).build()));
    // Note: Placed the tea here so it fits with the rest
    public static final BreezefruitTea BREEZEFRUIT_TEA = new BreezefruitTea(new FabricItemSettings().group(Cuboiddungeon.DUNGEON_CONSUMABLE).food((new FoodComponent.Builder().hunger(1).saturationModifier(0f).build())));
    //Block items
    public static final BlockItem DUNGEON_BRICK_WALL = new BlockItem(ModBlocks.DUNGEON_BRICK_WALL, new Item.Settings().group(Cuboiddungeon.DUNGEON_ITEMS));
    public static final BlockItem DUNGEON_BRICK_WALL_MOSSY = new BlockItem(ModBlocks.DUNGEON_BRICK_WALL_MOSSY, new Item.Settings().group(Cuboiddungeon.DUNGEON_ITEMS));
    public static final BlockItem DUNGEON_BRICK_WALL_CRACKED = new BlockItem(ModBlocks.DUNGEON_BRICK_WALL_CRACKED, new Item.Settings().group(Cuboiddungeon.DUNGEON_ITEMS));
    public static final BlockItem DUNGEON_BRICK_WALL_CHISELED = new BlockItem(ModBlocks.DUNGEON_BRICK_WALL_CHISELED, new Item.Settings().group(Cuboiddungeon.DUNGEON_ITEMS));
    public static final BlockItem DUNGEON_BRICK_WALL_CUT = new BlockItem(ModBlocks.DUNGEON_BRICK_WALL_CUT, new Item.Settings().group(Cuboiddungeon.DUNGEON_ITEMS));
    public static final BlockItem COBALT_ORE = new BlockItem(ModBlocks.COBALT_ORE, new Item.Settings().group(Cuboiddungeon.DUNGEON_ITEMS));
    // Spawn egg items
    public static final SpawnEggItem MARSUPIAL_RAT_SPAWN_EGG = new SpawnEggItem(Cuboiddungeon.MARSUPIAL_RAT, 0x675A53,0x855D5D, new Item.Settings().group(Cuboiddungeon.DUNGEON_MONSTERS));
    public static final SpawnEggItem RHEUM_SLIME_SPAWN_EGG = new SpawnEggItem(Cuboiddungeon.RHEUM_SLIME,0x06d3b3,0x20c3b9, new Item.Settings().group(Cuboiddungeon.DUNGEON_MONSTERS));
    public static final SpawnEggItem DUNGEON_SNAKE_SPAWN_EGG = new SpawnEggItem(Cuboiddungeon.DUNGEON_SNAKE,0x7cd507,0x7cd507,new Item.Settings().group(Cuboiddungeon.DUNGEON_MONSTERS));
    // Misc items
    public static final Item COBALT = new Item(new Item.Settings().group(Cuboiddungeon.DUNGEON_ITEMS));

    // Items with custom classes registry
    public static final ScrollOfLunarBlessing SCROLL_OF_LUNAR_BLESSING = new ScrollOfLunarBlessing(new FabricItemSettings().group(Cuboiddungeon.DUNGEON_ITEMS));
    public static final ScrollOfDispel SCROLL_OF_DISPEL = new ScrollOfDispel(new FabricItemSettings().group(Cuboiddungeon.DUNGEON_ITEMS));
    public static final ScrollOfRage SCROLL_OF_RAGE = new ScrollOfRage(new FabricItemSettings().group(Cuboiddungeon.DUNGEON_ITEMS));
    public static final ScrollOfWaves SCROLL_OF_WAVES = new ScrollOfWaves(new FabricItemSettings().group(Cuboiddungeon.DUNGEON_ITEMS));
    public static final ScrollOfSummoning SCROLL_OF_SUMMONING = new ScrollOfSummoning(new FabricItemSettings().group(Cuboiddungeon.DUNGEON_ITEMS));

    public static final Dagger DAGGER = new Dagger(new ToolMaterials(new FabricItemSettings().group(Cuboiddungeon.DUNGEON_ITEMS)));
    public static final PoisonedDagger POISONED_DAGGER = new PoisonedDagger(new ImbuedDaggerMaterials(new FabricItemSettings().group(Cuboiddungeon.DUNGEON_ITEMS)));
    public static final HardwoodStaff HARDWOOD_STAFF = new HardwoodStaff(new StaffToolMaterials(new FabricItemSettings().group(Cuboiddungeon.DUNGEON_ITEMS)));

    public static final RingOfPower RING_OF_POWER = new RingOfPower();



    // Item Registries
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"food_ration"), FOOD_RATION);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"pasty"), PASTY);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"raw_rat_meat"), RAW_RAT_MEAT);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"cooked_rat_meat"), COOKED_RAT_MEAT);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"breezefruit"), BREEZEFRUIT);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"breezefruit_roll"), BREEZEFRUIT_ROLL);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"breezefruit_pie"), BREEZEFRUIT_PIE);
        Registry.register(Registry.ITEM, new Identifier("cuboiddungeon","breezefruit_tea"),BREEZEFRUIT_TEA );

        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"dungeon_brick_wall"), DUNGEON_BRICK_WALL);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"dungeon_brick_wall_mossy"), DUNGEON_BRICK_WALL_MOSSY);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"dungeon_brick_wall_cracked"), DUNGEON_BRICK_WALL_CRACKED);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"dungeon_brick_wall_chiseled"), DUNGEON_BRICK_WALL_CHISELED);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"dungeon_brick_wall_cut"), DUNGEON_BRICK_WALL_CUT);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"cobalt_ore"), COBALT_ORE);

        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"marsupial_rat_spawn_egg"), MARSUPIAL_RAT_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"rheum_slime_spawn_egg"), RHEUM_SLIME_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"dungeon_snake_spawn_egg"), DUNGEON_SNAKE_SPAWN_EGG);

        Registry.register(Registry.ITEM, new Identifier(Cuboiddungeon.MOD_ID,"cobalt"), COBALT);

        Registry.register(Registry.ITEM, new Identifier("cuboiddungeon","scroll_of_lunar_blessing"), SCROLL_OF_LUNAR_BLESSING);
        Registry.register(Registry.ITEM, new Identifier("cuboiddungeon","scroll_of_dispel"), SCROLL_OF_DISPEL);
        Registry.register(Registry.ITEM, new Identifier("cuboiddungeon","scroll_of_rage"), SCROLL_OF_RAGE);
        Registry.register(Registry.ITEM, new Identifier("cuboiddungeon","scroll_of_waves"), SCROLL_OF_WAVES);
        Registry.register(Registry.ITEM, new Identifier("cuboiddungeon","scroll_of_summoning"), SCROLL_OF_SUMMONING);


        Registry.register(Registry.ITEM, new Identifier("cuboiddungeon", "dagger"), DAGGER);
        Registry.register(Registry.ITEM, new Identifier("cuboiddungeon","poisoned_dagger"), POISONED_DAGGER);
        Registry.register(Registry.ITEM, new Identifier("cuboiddungeon","hardwood_staff"), HARDWOOD_STAFF);


        Registry.register(Registry.ITEM, new Identifier("cuboiddungeon","ring_of_power"), RING_OF_POWER);

    }
}
