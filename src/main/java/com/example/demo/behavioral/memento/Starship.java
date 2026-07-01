package com.example.demo.behavioral.memento;

public class Starship {
    private int q;
    private int r;
    private int speed;
    private String direction;

    public Starship(int q, int r, int speed, String direction) {
        this.q = q;
        this.r = r;
        this.speed = speed;
        this.direction = direction;
    }

    public int q()           { return q; }
    public int r()           { return r; }
    public int speed()       { return speed; }
    public String direction() { return direction; }

    public void setSpeed(int speed)         { this.speed = speed; }
    public void setDirection(String direction) { this.direction = direction; }

    public void move() {
        int[] d = delta(direction);
        q += d[0] * speed;
        r += d[1] * speed;
    }

    public NavSnapshot save() {
        return new NavSnapshot(q, r, speed, direction);
    }

    public void restore(NavSnapshot s) {
        q = s.q;
        r = s.r;
        speed = s.speed;
        direction = s.direction;
    }

    private static int[] delta(String dir) {
        return switch (dir) {
            case "E"  -> new int[]{ 1,  0};
            case "NE" -> new int[]{ 1, -1};
            case "NW" -> new int[]{ 0, -1};
            case "W"  -> new int[]{-1,  0};
            case "SW" -> new int[]{-1,  1};
            case "SE" -> new int[]{ 0,  1};
            default   -> throw new IllegalArgumentException("Unknown heading: " + dir);
        };
    }
}
