public class Inheritance {
    public static void main(String[] args) {
        Vehicle myCar = new Car();

        if (myCar instanceof Car) {
            System.out.println("This is a car");
        }

        Vehicle myVehicle = (Vehicle)myCar;

        System.out.println("Vehicle Data:");
        System.out.println("Registration number: " + myVehicle.registrationNumber);
        if (myVehicle instanceof Car) {
            System.out.println("Type of vehicle: Car");
            Car myCar;
            myCar = (Car)myVehicle; // Type-cast to get access to numberOfDoors!
            System.out.println("Number of doors: " + myCar.numberOfDoors);
        }
        else if (myVehicle instanceof Truck) {
            System.out.println("Type of vehicle: Truck");
            Truck myTruck;
            myTruck = (Truck)myVehicle; // Type-cast to get access to numberOfAxles!
            System.out.println("Number of axles: " + myTruck.numberOfAxles);
        }
        else if (myVehicle instanceof Motorcycle) {
            System.out.println("Type of vehicle: Motorcycle");
            Motorcycle myCycle;
            myCycle = (Motorcycle)myVehicle; // Type-cast to get access to hasSidecar!
            System.out.println("Has a sidecar: " + myCycle.hasSidecar);
        }
    }
}

class Vehicle {
    int registrationNumber;
    Person owner;   // Assuming person class is defined

    void transferOwnership(Person newOwner) {

    }
}

class Car extends Vehicle {
    int numberOfDoors;
}

class Truck extends Vehicle {
    int numberOfAxles;
}

class Motorcycle extends Vehicle {
    boolean hasSideCar;
}

class Person {}