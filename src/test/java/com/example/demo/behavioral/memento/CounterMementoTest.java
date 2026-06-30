package com.example.demo.behavioral.memento;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CounterMementoTest {

    @Test
    void save_andRestore_revertsValue() {
        Counter counter = new Counter();
        CounterMemento snapshot = counter.save();
        counter.increment();
        counter.restore(snapshot);
        assertThat(counter.value()).isEqualTo(0);
    }

    @Test
    void incrementThenRestore_revertsToPreIncrementValue() {
        Counter counter = new Counter();
        counter.increment();
        counter.increment();
        CounterMemento snapshot = counter.save();
        counter.increment();
        counter.restore(snapshot);
        assertThat(counter.value()).isEqualTo(2);
    }

    @Test
    void multipleSnapshots_undoInReverseOrder() {
        Counter counter = new Counter();
        MementoHistory history = new MementoHistory();
        history.push(counter.save());
        counter.increment();
        history.push(counter.save());
        counter.increment();
        counter.restore(history.pop());
        assertThat(counter.value()).isEqualTo(1);
        counter.restore(history.pop());
        assertThat(counter.value()).isEqualTo(0);
    }

    @Test
    void history_pop_onEmpty_returnsNull() {
        MementoHistory history = new MementoHistory();
        assertThat(history.pop()).isNull();
    }

    @Test
    void memento_hasNoPublicValueGetter() {
        boolean hasPublicGetter = Arrays.stream(CounterMemento.class.getMethods())
                .anyMatch(m -> Modifier.isPublic(m.getModifiers())
                        && m.getName().startsWith("get")
                        && m.getParameterCount() == 0);
        assertThat(hasPublicGetter).isFalse();
    }
}
