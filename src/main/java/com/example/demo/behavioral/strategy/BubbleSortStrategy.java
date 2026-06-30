package com.example.demo.behavioral.strategy;

public class BubbleSortStrategy implements SortStrategy {
    @Override public String name() { return "BubbleSort"; }

    @Override
    public void sort(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - 1 - i; j++)
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = t;
                    swaps++;
                }
        System.out.println("    [BubbleSort] " + swaps + " swaps");
    }
}
