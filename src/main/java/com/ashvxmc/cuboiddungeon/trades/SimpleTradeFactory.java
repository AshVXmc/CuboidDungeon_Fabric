package com.ashvxmc.cuboiddungeon.trades;

import net.minecraft.entity.Entity;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class SimpleTradeFactory implements TradeOffers.Factory {
    private final TradeOffer trade;

    public SimpleTradeFactory(TradeOffer trade) {
        this.trade = trade;
    }

    @Nullable
    @Override
    public TradeOffer create(Entity entity, Random random) {
        return new TradeOffer(this.trade.toTag());
    }
}
