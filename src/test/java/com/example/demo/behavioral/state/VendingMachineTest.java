package com.example.demo.behavioral.state;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VendingMachineTest {

    @Test
    void idle_insert_transitionsToHasCoin() {
        VendingMachine vm = new VendingMachine(5);
        vm.insert();
        assertThat(vm.getState()).isInstanceOf(HasCoinState.class);
    }

    @Test
    void idle_dispense_returnsInsertCoinError() {
        VendingMachine vm = new VendingMachine(5);
        String result = vm.dispense();
        assertThat(result).isNotNull().isNotEmpty();
        assertThat(vm.getState()).isInstanceOf(IdleState.class);
    }

    @Test
    void idle_eject_returnsNoCoinError() {
        VendingMachine vm = new VendingMachine(5);
        String result = vm.eject();
        assertThat(result).isNotNull().isNotEmpty();
    }

    @Test
    void hasCoin_dispense_dispensesItem_transitionsToIdle() {
        VendingMachine vm = new VendingMachine(5);
        vm.insert();
        String result = vm.dispense();
        assertThat(result).isNotNull().isNotEmpty();
        assertThat(vm.getState()).isInstanceOf(IdleState.class);
        assertThat(vm.getStock()).isEqualTo(4);
    }

    @Test
    void hasCoin_eject_returnsCoin_transitionsToIdle() {
        VendingMachine vm = new VendingMachine(5);
        vm.insert();
        String result = vm.eject();
        assertThat(result).isNotNull().isNotEmpty();
        assertThat(vm.getState()).isInstanceOf(IdleState.class);
    }

    @Test
    void outOfStock_insert_returnsOutOfStockError() {
        VendingMachine vm = new VendingMachine(0);
        vm.setState(new OutOfStockState());
        String result = vm.insert();
        assertThat(result).isNotNull().isNotEmpty();
        assertThat(vm.getState()).isInstanceOf(OutOfStockState.class);
    }

    @Test
    void dispensingLastItem_transitionsToOutOfStock() {
        VendingMachine vm = new VendingMachine(1);
        vm.insert();
        vm.dispense();
        assertThat(vm.getState()).isInstanceOf(OutOfStockState.class);
    }
}
