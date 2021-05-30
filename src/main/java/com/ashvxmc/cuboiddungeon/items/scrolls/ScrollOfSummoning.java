package com.ashvxmc.cuboiddungeon.items.scrolls;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Random;

public class ScrollOfSummoning extends Item {
    public ScrollOfSummoning(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {
            Random random = new Random();
            // generates random number from 0 to 2
            int randomNumber = random.nextInt(3);
            switch (randomNumber){
                case 1:
                    IronGolemEntity ironGolemEntity = new IronGolemEntity(EntityType.IRON_GOLEM,world);
                    world.spawnEntity(ironGolemEntity);
                    break;
            }
        }  else if (user.hasStatusEffect(StatusEffects.BLINDNESS)){
            user.sendMessage(Text.of("You can't read while blinded!"),false);
        }
        return TypedActionResult.success(itemStack,world.isClient);
    }
}
