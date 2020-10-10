package net.bruty.session_one.Aggregation;

public class MotorBike {
    private Engine _engine;
    private Colour _colour;

    public MotorBike() {
        _engine = new Engine();
        System.out.println("New engine created: \t" + _engine);
    }

    public Colour getColour() {
        return _colour;
    }

    public void setColour(Colour colour) {
        _colour = colour;
    }

    public Engine getEngine() {
        return _engine;
    }

    public void setEngine(Engine engine) {
        _engine = engine;
    }
}
