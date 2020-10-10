package net.bruty.session_one.Polymorphism;

public class OverrideClass extends MoveableClass {
    @Override
    public void move() {
        System.out.println("Overriding move...");
    }
}
