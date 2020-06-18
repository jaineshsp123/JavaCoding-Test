package com.acme.mytrader.strategy;

import com.acme.mytrader.execution.ExecutionServiceImpl;
import com.acme.mytrader.model.Trade;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TradingStrategyTest {
  @Test
  public void testTradingStrategy() {
    String security = "IBM";
    int volume = 10;

    TradingStrategy strategy = new TradingStrategy(security, Trade.BUY, 50.0, volume);

    strategy.executeTradingStrategy();

    int expectedSize = 5;
    ArrayList<Trade> actualTrades = strategy.getTrades();

    assertEquals(expectedSize, actualTrades.size());

    ArrayList<Trade> expectedTrades = new ArrayList<>();

    int i = 0;
    double priceDelta = 10.0;
    double previousPrice = 50.0;

    while (i < expectedSize) {

      if (i != 0) {
        previousPrice = previousPrice - priceDelta;
      }

      Trade tempTrade = new Trade(security, Trade.BUY, previousPrice, volume);
      expectedTrades.add(tempTrade);

      i++;
    }

    assertEquals(expectedTrades, actualTrades);

  }

  @Test
  public void testExecutionServiceBuy() {
    ExecutionServiceImpl trader = new ExecutionServiceImpl();
    Trade expectedTrade = new Trade("IBM", Trade.BUY, 55.0, 100);

    trader.buy("IBM", 55.0, 100);

    ArrayList<Trade> trades = trader.getTrades();

    assertEquals(1, trades.size());
    assertEquals(expectedTrade, trades.get(0));
  }

  @Test
  public void testExecutionServiceSell() {
    ExecutionServiceImpl trader = new ExecutionServiceImpl();
    Trade expectedTrade = new Trade("IBM", Trade.SELL, 55.0, 100);

    trader.sell("IBM", 55.0, 100);

    ArrayList<Trade> trades = trader.getTrades();

    assertEquals(1, trades.size());
    assertEquals(expectedTrade, trades.get(0));
  }
}
