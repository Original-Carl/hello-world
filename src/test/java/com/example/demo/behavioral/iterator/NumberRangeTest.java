package com.example.demo.behavioral.iterator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberRangeTest {

    @Test
    void iterator_traversesAllElementsInOrder() {
        NumberRange range = new NumberRange(1, 5);
        List<Integer> result = new ArrayList<>();
        for (int n : range) result.add(n);
        assertThat(result).containsExactly(1, 2, 3, 4);
    }

    @Test
    void hasNext_trueWhileElementsRemain() {
        Iterator<Integer> it = new NumberRange(0, 3).iterator();
        assertThat(it.hasNext()).isTrue();
        it.next();
        assertThat(it.hasNext()).isTrue();
        it.next();
        assertThat(it.hasNext()).isTrue();
        it.next();
        assertThat(it.hasNext()).isFalse();
    }

    @Test
    void hasNext_falseWhenExhausted() {
        Iterator<Integer> it = new NumberRange(0, 1).iterator();
        it.next();
        assertThat(it.hasNext()).isFalse();
    }

    @Test
    void next_throwsNoSuchElementWhenExhausted() {
        Iterator<Integer> it = new NumberRange(0, 1).iterator();
        it.next();
        assertThatThrownBy(it::next).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void twoIterators_onSameRange_areIndependent() {
        NumberRange range = new NumberRange(0, 3);
        Iterator<Integer> it1 = range.iterator();
        Iterator<Integer> it2 = range.iterator();
        it1.next();
        assertThat(it2.next()).isEqualTo(0);
    }

    @Test
    void emptyRange_hasNoElements() {
        NumberRange range = new NumberRange(5, 5);
        assertThat(range.iterator().hasNext()).isFalse();
    }

    @Test
    void singleElement_iteratesOnce() {
        List<Integer> result = new ArrayList<>();
        for (int n : new NumberRange(7, 8)) result.add(n);
        assertThat(result).containsExactly(7);
    }
}
