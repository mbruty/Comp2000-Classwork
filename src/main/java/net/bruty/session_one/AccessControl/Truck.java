package net.bruty.session_one.AccessControl;

public class Truck {

    private int _numWheels;
    private float _speed;

    public void drive() {
        System.out.println("Driving with " + _numWheels + " wheels");
        calcSpeed();
    }

    private void calcSpeed() {
        System.out.println("Current speed: \t" + _speed);
    }

    public int getNumWheels() {
        return _numWheels;
    }

    public void setNumWheels(int numWheels) {
        _numWheels = numWheels;
    }
}
