package net.bruty;

import net.bruty.AccessControl.Truck;
import net.bruty.Aggregation.MotorBike;
import net.bruty.Encapsulation.Encapsulation;
import net.bruty.Encapsulation.Suitcase;
import net.bruty.Inheritance.Boat;
import net.bruty.Inheritance.Car;
import net.bruty.Inheritance.Vehicle;
import net.bruty.Interfaces.Mouse;
import net.bruty.Interfaces.Owl;
import net.bruty.Polymorphism.MoveableClass;
import net.bruty.Polymorphism.OverrideClass;
import net.bruty.Static.MobileDevice;

public class Main {

    public static void main(String[] args) {
        // Correct
        Encapsulation.Login("Bob", "pass");
        // Incorrect
        Encapsulation.Login("NotBob", "WrongPass");

        Encapsulation.post("Having fun in the sun!", "Picture of me on the beach", "#sun, #beach, #seaside");

        Truck myTruck = new Truck();
        myTruck.drive();
        myTruck.setNumWheels(8);
        myTruck.drive();

        Suitcase mySuitcase = new Suitcase(5);
        // Add more items than max and remove too many
        for (int i = 0; i < 6; i++) mySuitcase.addItem();
        for (int i = 0; i < 6; i++) mySuitcase.removeItem();

        Car myCar = new Car();
        Boat myBoat = new Boat();

        Vehicle.move();
        Vehicle.move();

        MoveableClass myMovableClass = new MoveableClass();
        myMovableClass.move();
        MoveableClass.move(5, 4);
        OverrideClass myOverrideClass = new OverrideClass();
        myOverrideClass.move();
        MoveableClass.move(5, 4);

        MotorBike myMotorBike = new MotorBike();

        Owl myOwl = new Owl();
        myOwl.makeSound();
        myOwl.fly();

        Mouse myMouse = new Mouse();
        myMouse.makeSound();

        MobileDevice.maxVolume();
        MobileDevice.halfVolume();
    }
}
