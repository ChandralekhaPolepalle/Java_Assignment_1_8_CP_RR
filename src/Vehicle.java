enum VehicleType {
    Family,
    RACE,
    NOT_FOR_RACE
}

enum Gear {
    Automatic,
    Manual
}

enum CarType{
    Sport,
    Sedan,
    SUV,
    Hatchback,
    Minivan
}

public class Vehicle {

    private String make;
    private String plate;
    private String color;
    private VehicleType category; //enum

    public Vehicle(String make, String plate, String color, VehicleType category) {
        this.make = make;
        this.plate = plate;
        this.color = color;
        this.category = category;
    }

    @Override
    public String toString() {
        return "- make: " + make +
                "\n- plate: " + plate +
                "\n- color: " + color +
                "\n- category: " + category;
    }

}

// Car class
class Car extends Vehicle {

    private Gear gear; //enum
    private CarType type; //enum

    public Car(String make, String plate, String color, VehicleType category, Gear gear, CarType type) {
        super(make, plate, color, category);
        this.gear = gear;
        this.type = type;
    }

    // Car
    @Override
    public String toString() {
        return super.toString() +
                "\n- gear type: " + gear +
                "\n- type: " + type;
    }

}

// Motorcycle class
class Motorcycle extends Vehicle {

    private boolean sidecar;

    public Motorcycle(String make, String plate, String color, VehicleType category, boolean sidecar) {
        super(make, plate, color, category);
        this.sidecar = sidecar;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n- " + (sidecar ? "with" : "without") + " sidecar";
    }

}