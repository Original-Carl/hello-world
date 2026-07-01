package com.example.demo.creational.prototype;

public class Enemy implements Cloneable {
    private String type;
    private int health;
    private int speed;

    public Enemy(String type, int health, int speed) {
        this.type = type;
        this.health = health;
        this.speed = speed;
    }

    public String type()   { return type; }
    public int health()    { return health; }
    public int speed()     { return speed; }
    public void setHealth(int h) { this.health = h; }

    @Override
    public Enemy clone() {
        try {
            return (Enemy) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
