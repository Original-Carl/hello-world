package com.example.demo.behavioral.observer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(OutputCaptureExtension.class)
class StockMarketTest {

    @Test
    void subscribe_observerReceivesNotification() {
        StockMarket market = new StockMarket();
        List<String> received = new ArrayList<>();
        market.subscribe((ticker, price) -> received.add(ticker + "@" + price));
        market.setPrice("AAPL", 100.0);
        assertThat(received).containsExactly("AAPL@100.0");
    }

    @Test
    void multipleObservers_allNotified() {
        StockMarket market = new StockMarket();
        List<String> log = new ArrayList<>();
        market.subscribe((t, p) -> log.add("obs1:" + t));
        market.subscribe((t, p) -> log.add("obs2:" + t));
        market.setPrice("GOOGL", 95.0);
        assertThat(log).containsExactly("obs1:GOOGL", "obs2:GOOGL");
    }

    @Test
    void setPrice_multipleTimes_notifiesEachTime() {
        StockMarket market = new StockMarket();
        List<Double> prices = new ArrayList<>();
        market.subscribe((t, p) -> prices.add(p));
        market.setPrice("AAPL", 148.0);
        market.setPrice("AAPL", 162.5);
        assertThat(prices).containsExactly(148.0, 162.5);
    }

    @Test
    void noObservers_setPrice_doesNotThrow() {
        StockMarket market = new StockMarket();
        assertDoesNotThrow(() -> market.setPrice("AAPL", 100.0));
    }

    @Test
    void trader_buysBelowThreshold(CapturedOutput output) {
        StockMarket market = new StockMarket();
        market.subscribe(new StockTrader("TestTrader"));
        market.setPrice("AAPL", 148.00);
        assertThat(output.toString()).contains("BUY");
    }

    @Test
    void trader_sellsAboveThreshold(CapturedOutput output) {
        StockMarket market = new StockMarket();
        market.subscribe(new StockTrader("TestTrader"));
        market.setPrice("AAPL", 162.50);
        assertThat(output.toString()).contains("SELL");
    }
}
