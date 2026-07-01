package com.example.demo.behavioral.observer;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ObserverCommand {

    @ShellMethod(key = "observer", value = "Observer pattern (behavioral)")
    public void run() {
        System.out.println("=== Observer Pattern ===");
        System.out.println("Define a one-to-many dependency so all dependents are notified\n" +
                           "automatically when the subject changes state.\n");

        StockMarket market = new StockMarket();
        market.subscribe(new StockTrader("Alice"));
        market.subscribe(new StockTrader("Bob"));

        System.out.println("  Price update → AAPL $148.00");
        market.setPrice("AAPL", 148.00);
        System.out.println("  Price update → AAPL $162.50");
        market.setPrice("AAPL", 162.50);
        System.out.println("  Price update → GOOGL $95.00");
        market.setPrice("GOOGL", 95.00);
    }
}
