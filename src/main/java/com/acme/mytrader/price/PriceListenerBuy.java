package com.acme.mytrader.price;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.strategy.TradingStrategy;

public class PriceListenerBuy implements PriceListener {
    private ExecutionService trader;
    private TradingStrategy strategy;

    public PriceListenerBuy(ExecutionService trader, TradingStrategy strategy){
        this.trader = trader;
        this.strategy = strategy;
    }

    public void priceUpdate(String security, double price) {
        if (security.equals(strategy.getSecurity()) && (price <= strategy.getThreshold())) {
            trader.buy(security, price, strategy.getVolume());
        }
    }
}