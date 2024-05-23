import textio.TextIO;

interface Vehicle {
    String getMake();
    String getModel();
    int getYearOfManufacture();
}

interface CarVehicle {
    void setNumberOfDoors(int doors);
    int getNumberOfDoors();
    void setFuelType(String fuelType); // Expected values: "petrol", "diesel", "electric"
    String getFuelType();
}

interface MotorVehicle {
    void setNumberOfWheels(int wheels);
    int getNumberOfWheels();
    void setType(String type); // Expected values: "sport", "cruiser", "off-road"
    String getType();
}

interface TruckVehicle {
    void setCargoCapacity(double capacity); // in tons
    double getCargoCapacity();
    void setTransmissionType(String transmissionType); // Expected values: "manual", "automatic"
    String getTransmissionType();
}

class Car implements Vehicle, CarVehicle {
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

class Motorcycle implements Vehicle, MotorVehicle {
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

class Truck implements Vehicle, TruckVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private double cargoCapacity;
    private String transmissionType;

    public Truck(String make, String model, int yearOfManufacture) {
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
    public void setCargoCapacity(double capacity) { this.cargoCapacity = capacity; }

    @Override
    public double getCargoCapacity() { return cargoCapacity; }

    @Override
    public void setTransmissionType(String transmissionType) { this.transmissionType = transmissionType; }

    @Override
    public String getTransmissionType() { return transmissionType; }
}

public class Assignment6 {
    public static void main(String[] args) {
        System.out.println("Welcome to the Vehicle Information System");

        // Example of creating a Car object
        System.out.println("Enter details for a new Car:");
        System.out.print("Make: ");
        String carMake = TextIO.getln();
        System.out.print("Model: ");
        String carModel = TextIO.getln();
        System.out.print("Year of Manufacture: ");
        int carYear = TextIO.getlnInt();

        Car car = new Car(carMake, carModel, carYear);

        System.out.print("Number of Doors: ");
        int carDoors = TextIO.getlnInt();
        car.setNumberOfDoors(carDoors);

        System.out.print("Fuel Type (petrol/diesel/electric): ");
        String carFuelType = TextIO.getlnWord();
        car.setFuelType(carFuelType);

        System.out.println("\nCar Details:");
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYearOfManufacture());
        System.out.println("Doors: " + car.getNumberOfDoors());
        System.out.println("Fuel Type: " + car.getFuelType());

        // Add similar sections for Motorcycle and Truck
        // Motorcycle
        System.out.println("\nEnter details for a new Motorcycle:");
        System.out.print("Make: ");
        String motoMake = TextIO.getln();
        System.out.print("Model: ");
        String motoModel = TextIO.getln();
        System.out.print("Year of Manufacture: ");
        int motoYear = TextIO.getlnInt();

        Motorcycle moto = new Motorcycle(motoMake, motoModel, motoYear);

        System.out.print("Number of Wheels: ");
        int motoWheels = TextIO.getlnInt();
        moto.setNumberOfWheels(motoWheels);

        System.out.print("Type (sport/cruiser/off-road): ");
        String motoType = TextIO.getln();
        moto.setType(motoType);

        System.out.println("\nMotorcycle Details:");
        System.out.println("Make: " + moto.getMake());
        System.out.println("Model: " + moto.getModel());
        System.out.println("Year: " + moto.getYearOfManufacture());
        System.out.println("Wheels: " + moto.getNumberOfWheels());
        System.out.println("Type: " + moto.getType());

        // Truck
        System.out.println("\nEnter details for a new Truck:");
        System.out.print("Make: ");
        String truckMake = TextIO.getln();
        System.out.print("Model: ");
        String truckModel = TextIO.getln();
        System.out.print("Year of Manufacture: ");
        int truckYear = TextIO.getlnInt();

        Truck truck = new Truck(truckMake, truckModel, truckYear);

        System.out.print("Cargo Capacity (in tons): ");
        double truckCapacity = TextIO.getlnDouble();
        truck.setCargoCapacity(truckCapacity);

        System.out.print("Transmission Type (manual/automatic): ");
        String truckTransmission = TextIO.getln();
        truck.setTransmissionType(truckTransmission);

        System.out.println("\nTruck Details:");
        System.out.println("Make: " + truck.getMake());
        System.out.println("Model: " + truck.getModel());
        System.out.println("Year: " + truck.getYearOfManufacture());
        System.out.println("Cargo Capacity: " + truck.getCargoCapacity() + " tons");
        System.out.println("Transmission Type: " + truck.getTransmissionType());
    }
}