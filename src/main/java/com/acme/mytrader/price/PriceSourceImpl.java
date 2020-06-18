package com.acme.mytrader.price;

import java.util.ArrayList;

public class PriceSourceImpl implements PriceSource {
    private ArrayList<PriceListener> listeners;

    public PriceSourceImpl(String symbol) {
        this.initListeners();
    }

    private void initListeners() {
        this.listeners = new ArrayList<>();
    }

    public void setPrice(String security, double price) {
        for(PriceListener listener: this.listeners) {
            if (price >= 0.0) {
                listener.priceUpdate(security, price);
            } else {  // Todo: Handle the case when receiving a negative price, for now just default to 0
                listener.priceUpdate(security, 0.0);
            }
        }
    }

    public void addPriceListener(PriceListener listener) {
        this.listeners.add(listener);
    }

    public void removePriceListener(PriceListener listener) {
        this.listeners.remove(listener);
    }

}