public interface Vehicle {
    String getMake();
    String getModel();
    int getYearOfManufacture();
}

public interface CarVehicle {
    void setNumberOfDoors(int doors);
    int getNumberOfDoors();
    void setFuelType(String fuelType); // Expected values: "petrol", "diesel", "electric"
    String getFuelType();
}

public interface MotorVehicle {
    void setNumberOfWheels(int wheels);
    int getNumberOfWheels();
    void setType(String type); // Expected values: "sport", "cruiser", "off-road"
    String getType();
}

public interface TruckVehicle {
    void setCargoCapacity(double capacity); // in tons
    double getCargoCapacity();
    void setTransmissionType(String transmissionType); // Expected values: "manual", "automatic"
    String getTransmissionType();
}

public class Car implements Vehicle, CarVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private int numberOfDoors;
    private String fuelType;

    public Car(String make, String model, int yearOfManufacture) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }

    @Override
    public String getMake() { return make; }

    @Override
    public String getModel() { return model; }

    @Override
    public int getYearOfManufacture() { return yearOfManufacture; }

    @Override
    public void setNumberOfDoors(int doors) { this.numberOfDoors = doors; }

    @Override
    public int getNumberOfDoors() { return numberOfDoors; }

    @Override
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }

    @Override
    public String getFuelType() { return fuelType; }
}

public class Motorcycle implements Vehicle, MotorVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private int numberOfWheels;
    private String type;

    public Motorcycle(String make, String model, int yearOfManufacture) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }

    @Override
    public String getMake() { return make; }

    @Override
    public String getModel() { return model; }

    @Override
    public int getYearOfManufacture() { return yearOfManufacture; }

    @Override
    public void setNumberOfWheels(int wheels) { this.numberOfWheels = wheels; }

    @Override
    public int getNumberOfWheels() { return numberOfWheels; }

    @Override
    public void setType(String type) { this.type = type; }

    @Override
    public String getType() { return type; }
}

public class Assignment6 {

}