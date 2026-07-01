package com.example.demo.behavioral.observer;

public interface StockObserver {
    void onPriceChange(String ticker, double price);
}
