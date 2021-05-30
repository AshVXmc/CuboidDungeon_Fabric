package com.ashvxmc.cuboiddungeon.mixins;

import com.ashvxmc.cuboiddungeon.Cuboiddungeon;
import com.ashvxmc.cuboiddungeon.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoulSandBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(SoulSandBlock.class)
public class SoulSandBlockMixin extends Block {
    public SoulSandBlockMixin(Settings settings) {
        super(settings);
    }

    @Unique
    public ActionResult onUse(World world, PlayerEntity player, Hand hand, BlockPos blockPos) {
        if (player.getStackInHand(hand).isItemEqual(new ItemStack(Items.BUCKET))) {
            player.setStackInHand(hand, new ItemStack(ModItems.SCROLL_OF_DISPEL));
            world.setBlockState(blockPos, Blocks.SOUL_SOIL.getDefaultState());

            WitherSkeletonEntity witherSkeletonEntity = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world);
            world.spawnEntity(witherSkeletonEntity);

            player.playSound(SoundEvents.ITEM_BUCKET_FILL, 2.0F, 1.0F);
            return ActionResult.success(world.isClient());
        }
        return ActionResult.PASS;
    }
}
