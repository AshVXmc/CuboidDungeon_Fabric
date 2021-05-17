package com.ashvxmc.cuboiddungeon.trades;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class MysteriousMerchantTrades {
    public static void createTrade(VillagerProfession villagerProfession, int price, int uses, int exp, int rank, float multiplier, ItemStack itemStack){
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FLETCHER, 1, factories -> {
            factories.add(new SimpleTradeFactory(new TradeOffer(new ItemStack(Items.GOLD_INGOT, 3), new ItemStack(Items.NETHERITE_SCRAP, 4), new ItemStack(Items.NETHERITE_INGOT), 2, 6, 0.15F)));
        });
    }
}
