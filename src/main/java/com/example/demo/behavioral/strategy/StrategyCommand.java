package com.example.demo.behavioral.strategy;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Arrays;

@ShellComponent
public class StrategyCommand {

    @ShellMethod(key = "strategy", value = "Strategy pattern (behavioral)")
    public void run() {
        System.out.println("=== Strategy Pattern ===");
        System.out.println("Define a family of algorithms, encapsulate each one, and make them\n" +
                           "interchangeable — the client picks the strategy at runtime.\n");

        int[] data = {5, 3, 8, 1, 9, 2, 7, 4, 6};
        System.out.println("  Input : " + Arrays.toString(data));

        SortContext ctx = new SortContext();

        int[] copy1 = data.clone();
        ctx.setStrategy(new BubbleSortStrategy());
        ctx.sort(copy1);
        System.out.println("  Sorted: " + Arrays.toString(copy1));

        System.out.println();
        System.out.println("  Input : " + Arrays.toString(data));

        int[] copy2 = data.clone();
        ctx.setStrategy(new QuickSortStrategy());
        ctx.sort(copy2);
        System.out.println("  Sorted: " + Arrays.toString(copy2));

        System.out.println("\nSame SortContext, swapped strategy — same result, different work done.");
    }
}
