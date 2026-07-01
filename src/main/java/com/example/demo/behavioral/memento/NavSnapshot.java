package com.example.demo.behavioral.memento;

class NavSnapshot {
    NavSnapshot(int q, int r, int speed, String direction) {
        this.q = q;
        this.r = r;
        this.speed = speed;
        this.direction = direction;
    }
    final int q;
    final int r;
    final int speed;
    final String direction;
}
