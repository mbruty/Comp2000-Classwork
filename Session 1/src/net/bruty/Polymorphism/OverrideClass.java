package net.bruty.Polymorphism;

public class OverrideClass extends MoveableClass {
    @Override
    public void move() {
        System.out.println("Overriding move...");
    }
}
