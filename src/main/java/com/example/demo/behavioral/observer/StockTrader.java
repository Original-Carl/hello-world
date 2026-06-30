package com.example.demo.behavioral.observer;

public class StockTrader implements StockObserver {
    private final String name;
    public StockTrader(String name) { this.name = name; }

    @Override
    public void onPriceChange(String ticker, double price) {
        String action = price > 150 ? "SELL" : "BUY ";
        System.out.printf("    [%-5s] %s @ $%6.2f → %s%n", name, ticker, price, action);
    }
}
