package net.bruty.Polymorphism;

public class MoveableClass {
    public static void move(int vX, int vY) {
        System.out.println("Moving x: " + vX + " \t y: " + vY);
    }

    public void move() {
        System.out.println("Moving...");
    }
}
