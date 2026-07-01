package com.example.demo.behavioral.strategy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortStrategyTest {

    private final int[] UNSORTED  = {5, 3, 8, 1, 9, 2, 7, 4, 6};
    private final int[] SORTED    = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final int[] ALREADY   = {1, 2, 3, 4, 5};
    private final int[] SINGLE    = {42};

    @Test
    void bubbleSort_sortsArray() {
        int[] arr = UNSORTED.clone();
        new BubbleSortStrategy().sort(arr);
        assertArrayEquals(SORTED, arr);
    }

    @Test
    void quickSort_sortsArray() {
        int[] arr = UNSORTED.clone();
        new QuickSortStrategy().sort(arr);
        assertArrayEquals(SORTED, arr);
    }

    @Test
    void bothStrategies_produceSameResult() {
        int[] b = UNSORTED.clone();
        int[] q = UNSORTED.clone();
        new BubbleSortStrategy().sort(b);
        new QuickSortStrategy().sort(q);
        assertArrayEquals(b, q);
    }

    @Test
    void alreadySorted_remainsSorted() {
        int[] arr = ALREADY.clone();
        new BubbleSortStrategy().sort(arr);
        assertArrayEquals(ALREADY, arr);
    }

    @Test
    void singleElement_unchanged() {
        int[] arr = SINGLE.clone();
        new QuickSortStrategy().sort(arr);
        assertArrayEquals(SINGLE, arr);
    }

    @Test
    void context_delegatesToCurrentStrategy() {
        SortContext ctx = new SortContext();
        int[] arr = UNSORTED.clone();
        ctx.setStrategy(new BubbleSortStrategy());
        ctx.sort(arr);
        assertArrayEquals(SORTED, arr);
    }

    @Test
    void context_switchStrategy_appliesNewAlgorithm() {
        SortContext ctx = new SortContext();
        int[] arr1 = UNSORTED.clone();
        int[] arr2 = UNSORTED.clone();

        ctx.setStrategy(new BubbleSortStrategy());
        ctx.sort(arr1);

        ctx.setStrategy(new QuickSortStrategy());
        ctx.sort(arr2);

        assertArrayEquals(arr1, arr2);
    }

    @Test
    void strategyNames_areDistinct() {
        assertThat(new BubbleSortStrategy().name()).isNotEqualTo(new QuickSortStrategy().name());
    }
}
