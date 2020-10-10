package net.bruty;


import net.bruty.session_one.AccessControl.Truck;
import net.bruty.session_one.Aggregation.MotorBike;
import net.bruty.session_one.Encapsulation.Encapsulation;
import net.bruty.session_one.Encapsulation.Suitcase;
import net.bruty.session_one.Inheritance.Boat;
import net.bruty.session_one.Inheritance.Car;
import net.bruty.session_one.Interfaces.Mouse;
import net.bruty.session_one.Interfaces.Owl;
import net.bruty.session_one.Polymorphism.MoveableClass;
import net.bruty.session_one.Polymorphism.OverrideClass;
import net.bruty.session_one.Static.MobileDevice;

import static net.bruty.session_one.Inheritance.Vehicle.*;

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

        move();
        move();

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
