package com.acme.mytrader.strategy;

import com.acme.mytrader.execution.ExecutionServiceImpl;
import com.acme.mytrader.model.Trade;
import com.acme.mytrader.price.PriceListenerBuy;
import com.acme.mytrader.price.PriceSourceImpl;

import java.util.ArrayList;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy {
    private String security;
    private String type;  // The type of strategy this is, either buy or sell
    private double threshold;  // The price at which to buy or sell
    private int volume;
    private ExecutionServiceImpl trader;

    public TradingStrategy(String security, String type, double threshold, int volume) {
        this.setSecurity(security);
        this.setType(type);
        this.setThreshold(threshold);
        this.setVolume(volume);

        this.trader = new ExecutionServiceImpl();
    }

    private void simulatePrices(PriceSourceImpl source, int numPrices) {
        double previousPrice = 100.0;
        double priceDelta = 10.0;

        for (int i = 0; i < numPrices; i++) {
            // Todo: Add a more interesting price change function
            if (i != 0) {
                previousPrice = previousPrice - priceDelta;
            }
            source.setPrice(this.security, previousPrice);
        }
    }

    public void executeTradingStrategy() {
        if (this.type.equals(Trade.BUY)) {
            PriceListenerBuy listenerBuy = new PriceListenerBuy(this.trader, this);
            PriceSourceImpl source = new PriceSourceImpl(this.security);

            source.addPriceListener(listenerBuy);

            this.simulatePrices(source, 10);
        } else {
            // Todo: Implement a sell listener to handle sell strategies
        }
    }

    public ArrayList<Trade> getTrades() {
        return this.trader.getTrades();
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.equals(Trade.BUY)) {
            this.type = type;
        } else if (type.equals(Trade.SELL)) {
            this.type = type;
        } else {
            this.type = Trade.BUY;  // Todo: This should throw an exception instead of defaulting to a type
        }
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        if (threshold > 0.0) {
            this.threshold = threshold;
        } else {
            this.threshold = 0.1;  // Todo: Handle this case better, perhaps throw an exception
        }

    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume > 0) {
            this.volume = volume;
        } else {
            this.volume = 1;  // Todo: Handle this case better, perhaps throw an exception
        }

    }
}