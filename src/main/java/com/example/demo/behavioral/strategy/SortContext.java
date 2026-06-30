package com.example.demo.behavioral.strategy;

public class SortContext {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) { this.strategy = strategy; }
    public void sort(int[] arr) { strategy.sort(arr); }
}
