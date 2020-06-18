package com.acme.mytrader.model;

public class Trade {
    private String security;
    private String type;
    private double price;
    private int volume;

    public static final String BUY = "buy";
    public static final String SELL = "sell";

    public Trade(String security, String type, double price, int volume) {
        setSecurity(security);
        setType(type);
        setPrice(price);
        setVolume(volume);
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
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (obj instanceof Trade) {
            Trade trade = (Trade) obj;

            return trade.getSecurity().equals(this.getSecurity()) &&
                    trade.getPrice() == this.getPrice() &&
                    trade.getType().equals(this.getType()) &&
                    trade.getVolume() == this.getVolume();
        }

        return false;
    }
}