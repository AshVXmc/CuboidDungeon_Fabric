package com.ashvxmc.cuboiddungeon.registry;

import com.ashvxmc.cuboiddungeon.Cuboiddungeon;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block DUNGEON_BRICK_WALL = new Block(FabricBlockSettings.of(Material.STONE)
            .breakByHand(false)
            .breakByTool(FabricToolTags.PICKAXES)
            .requiresTool()
            .hardness(1)
            .resistance(30.0f)
            .sounds(BlockSoundGroup.STONE));
    public static final Block DUNGEON_BRICK_WALL_MOSSY = new Block(FabricBlockSettings.copyOf(ModBlocks.DUNGEON_BRICK_WALL));
    public static final Block DUNGEON_BRICK_WALL_CRACKED = new Block(FabricBlockSettings.copyOf(ModBlocks.DUNGEON_BRICK_WALL));
    public static final Block DUNGEON_BRICK_WALL_CHISELED = new Block(FabricBlockSettings.copyOf(ModBlocks.DUNGEON_BRICK_WALL));
    public static final Block DUNGEON_BRICK_WALL_CUT = new Block(FabricBlockSettings.copyOf(ModBlocks.DUNGEON_BRICK_WALL));
    public static final Block COBALT_ORE = new Block(FabricBlockSettings.of(Material.STONE)
            .breakByHand(false)
            .breakByTool(FabricToolTags.PICKAXES)
            .requiresTool()
            .hardness(3)
            .resistance(30.0f)
            .sounds(BlockSoundGroup.STONE));

    // Register the blocks for it to appear in minecraft
    public static void registerBlocks(){
        Registry.register(Registry.BLOCK, new Identifier(Cuboiddungeon.MOD_ID,"dungeon_brick_wall"),DUNGEON_BRICK_WALL);
        Registry.register(Registry.BLOCK, new Identifier(Cuboiddungeon.MOD_ID,"dungeon_brick_wall_mossy"),DUNGEON_BRICK_WALL_MOSSY);
        Registry.register(Registry.BLOCK, new Identifier(Cuboiddungeon.MOD_ID,"dungeon_brick_wall_cracked"),DUNGEON_BRICK_WALL_CRACKED);
        Registry.register(Registry.BLOCK, new Identifier(Cuboiddungeon.MOD_ID,"dungeon_brick_wall_chiseled"),DUNGEON_BRICK_WALL_CHISELED);
        Registry.register(Registry.BLOCK, new Identifier(Cuboiddungeon.MOD_ID,"dungeon_brick_wall_cut"),DUNGEON_BRICK_WALL_CUT);

        Registry.register(Registry.BLOCK, new Identifier(Cuboiddungeon.MOD_ID,"cobalt_ore"),COBALT_ORE);
    }
}
