package com.example.demo.behavioral.strategy;

public class QuickSortStrategy implements SortStrategy {
    private int comparisons;

    @Override public String name() { return "QuickSort"; }

    @Override
    public void sort(int[] arr) {
        comparisons = 0;
        quickSort(arr, 0, arr.length - 1);
        System.out.println("    [QuickSort]  " + comparisons + " comparisons");
    }

    private void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(arr, lo, hi);
        quickSort(arr, lo, p - 1);
        quickSort(arr, p + 1, hi);
    }

    private int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi], i = lo - 1;
        for (int j = lo; j < hi; j++) {
            comparisons++;
            if (arr[j] <= pivot) { i++; int t = arr[i]; arr[i] = arr[j]; arr[j] = t; }
        }
        int t = arr[i + 1]; arr[i + 1] = arr[hi]; arr[hi] = t;
        return i + 1;
    }
}
