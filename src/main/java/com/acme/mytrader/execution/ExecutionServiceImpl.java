package com.acme.mytrader.execution;

import com.acme.mytrader.model.Trade;

import java.util.ArrayList;

public class ExecutionServiceImpl implements ExecutionService {
    private ArrayList<Trade> trades;

    public ExecutionServiceImpl() {
        initTrades();
    }

    private void initTrades() {
        this.trades = new ArrayList<>();
    }

    public void buy(String security, double price, int volume) {
        Trade buyTrade = new Trade(security, Trade.BUY, price, volume);

        trades.add(buyTrade);
    }

    public void sell(String security, double price, int volume) {
        Trade sellTrade = new Trade(security, Trade.SELL, price, volume);

        trades.add(sellTrade);
    }

    public ArrayList<Trade> getTrades() {
        return this.trades;
    }
}