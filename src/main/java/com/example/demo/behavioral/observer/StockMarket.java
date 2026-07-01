package com.example.demo.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private final List<StockObserver> observers = new ArrayList<>();

    public void subscribe(StockObserver observer) { observers.add(observer); }

    public void setPrice(String ticker, double price) {
        observers.forEach(o -> o.onPriceChange(ticker, price));
    }
}
