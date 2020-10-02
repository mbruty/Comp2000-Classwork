package net.bruty.Interfaces;

public class Owl implements IAnimal, IFlyingAnimal {

    @Override
    public void makeSound() {
        System.out.println("Hoot!");
    }

    @Override
    public void fly() {
        System.out.println("I do be flying tho");
    }
}
