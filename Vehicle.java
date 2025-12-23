class Vehicle {
    private String name;
    private String model;
    Vehicle(String name, String model) {
        this.name = name;
        this.model = model;
    }

    public void getName() {
        System.out.println("the car is a " + name + " " + model);
    }
}

//single inheritance

class FuelCar extends Vehicle {
    private String combustType;
    FuelCar(String name, String model, String combustType) {
        super(name, model);
        this.combustType = combustType;
    }

    public void getFuelCar() {
        getName();
        System.out.println("combustType is " + combustType);
    }
}

//hierarchical inheritance, alongside fuel car electric car also extends vehicle 

class ElectricCar extends Vehicle {
    private String batteryPower;
    ElectricCar(String name, String model, String batteryPower) {
        super(name, model);
        this.batteryPower = batteryPower;
    }

    public void getElectricCar() {
        getName();
        System.out.println(" battery power is " + batteryPower);
    }
}

//multi-level inheritance -> gasoline car derived from fuelcar, fuel car extends from vehicle

class GasolineCar extends FuelCar {
    private String combustType;
    private String gasCapacity;
    GasolineCar(String name, String model, String combustType, String gasCapacity) {
        super(name, model, combustType);
        this.gasCapacity = gasCapacity;
    }

    public void getGasolineCar() {
        getName();
        System.out.println(" gas capacity is " gasCapacity);
    }
}

//java does not support multiple inheritance via classes

public class Main {
    public static void main (String args[]) {
        System.out.println("single inheritance");
        FuelCar Fuel = new FuelCar("Honda", "Accord", "Petrol");
        Fuel.getFuelCar();
        System.out.println("\n");

        System.out.println("hierarchical inheritance");
        ElectricCar Electric = new ElectricCar("Tesla", "Model x", "200 WH");
        Electric.getElectricCar();
        System.out.println("\n");

        System.out.println("Multi-Level inheritance:");
        GasolineCar Gasoline = new GasolineCar("Toyota", "Corolla", "Gasoline", "30 liters");
        Gasoline.getGasolineCar();
    }
}