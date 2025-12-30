//design patterns used ->
//decorator for dynamic fee calculation
//interface pattern -> deployed via the search interface to allow for flexible querying

public enum MotorcycleType {
    STANDARD, CRUISER, TOURING, SPORTS, OFF_ROAD, DUAL_PURPOSE
}

public enum AccountStatus {
    ACTIVE, CLOSED, CANCELLED, BLACKLISTED, BLOCKED
}

public enum ReservationStatus {
    ACTIVE, PENDING, CONFIRMED, CANCELLED
}

public enum PaymentStatus {
    UNPAID, PENDING, COMPLETED, CANCELLED
}

public enum VanType {
    PASSENGER, CARGO
}

public enum CarType {
    ECONOMY, COMPACT, INTERMEDIATE, STANDARD, FULL_SIZE, PREMIUM, LUXURY
}

public enum TruckType {
    LIGHT_DUTY, MEDIUM_DUTY, HEAVY_DUTY
}

public enum VehicleLogType {
    ACCIDENT, FUELING, CLEAN_SERVICE, OIL_CHANGE, REPAIR, OTHER
}

//address, person and driver

public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    public Address(String streetAddress, String city, String state, String zipCode, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }
}

public abstract class Person {
    private String name;
    private Address address;
    private String email;
    private String phoneNumber;

}

public class Driver extends Person {
    private int driverId;
    //getters and setters
}

//account of two types -> receptionist and customer

public abstract class Account extends Person {
    private String accountId;
    private String password;
    private AccountStatus accountStatus;

    public Account() {}

    public abstract boolean resetPassword();
}

public class Customer extends Account {
    private String licenseNumber;
    private Date licenseExpiry;
    
    //getters and setters 
    @Override
    public boolean resetPassword() {
        this.setPassword(java.util.UUID.randomUUID().toString());
        return true;
    } 
}

public class Receptionist extends Account {

    private Date dateJoined;
    private List<Customer> customerList = new ArrayList<>();

    @Override
    public boolean resetPassword() {
        this.setPasword(java.util.UUID.randomUUID().toString());
        return true;
    }

}

//vehicle of four types -> car, truck, van motorcycle

public abstract class Vehicle {
    private String vehicleId;
    private String licensePlateNumber;
    private int passengerCapacity;
    private VehicleStatus vehicleStatus;
    private String model;
    private int manufacturingYear;
    private List<VehicleLog> log = new ArrayList<>();
}

public class Car extends Vehicle {
    private CarType carType;
    //getters and setters
}

public class Van extends Vehicle {
    private VanType vanType;
    //getters and setters
}

public class Motorcycle extends Vehicle {
    private MotorcycleType motorcycleType;
    //getters and setters
}

public class Truck extends Vehicle {
    private TruckType truckType;
    //getters and setters
}

//equipment -> navigation, child seat, rack

public abstract class Equipment {
    private int equipmentId;
    private int price;
}

public class Navigation extends Equipment {}

public class ChildSeat extends Equipment {}

public class SkiRack extends Equipment {}

//service -> of 3 types, driverService, roadside assistance, wifi

public abstract class Service {
    private int serviceId;
    private int price;
}

public class DriverService extends Service {
    private int driverId;

    //getters and setters
}

public class RoadsideAssistance extends Service {}
public class Wifi extends Service {}

//payment -> abstract class with credit card and cash as children

public abstract class Payment {
    private double amount;
    private Date timestamp;
    private PaymentStatus paymentStatus;

    public abstract boolean makePayment();
}

public class Cash extends Payment {
    @Override
    public boolean makePayment() {
        setStatus(PaymentStatus.COMPLETED);
        return true;
    }
}

public class CreditCard extends Payment {
    private String name;
    private String cardNumber;
    private String billingAddress;
    private int code;
    @Override
    public boolean makePayment() {
        setStatus(PaymentStatus.COMPLETED);
        return true;
    }
}

//vehicle log and vehicle reservation

public class VehicleLog {
    private int logId;
    private VehicleLogType vehicleLogType;
    private String description;
    private Date createdOn;
}

public class VehicleReservation {
    private int reservationId;
    private String customerId;
    private String vehicleId;
    private Date creationDate;
    private ReservationStatus status;
    private Date dueDate;
    private Date returnDate;
    private String pickupLocation;
    private String returnLocation;
    private List<Equipment> equipments = new Array<List> ();
    private List<Service> services = new ArrayList<>();
}

public abstract class Notification {
    private int notificationId;
    private Date createdOn;
    private String content;
    public void setContent(String c) {content = c;}
    public String getContent() {return content;}
    public abstract void sendNotification(Account account);
}

public class SmsNotification extends Notification {
    @Override
    public void sendNotification(Account account) {}
}

public class EmailNotification extends Notification {
    @Override
    public void sendNotification(Account account) {}
}

//parking stall and fine

public class ParkingStall {
    private int stallId;
    private String locationIdentitifer;

}

public class Fine {
    private double amount;
    private String reason;
    public void setAmount(double a) { amount = a;}
    public double getAmount() {return amount;}
    public void setReason(String r) {reason = r;}
    public String getReason() {return reason;}
    public double calculateFine() {return amount;}

}

//search interface and catalog

public interface search {
    List<Vehicle> searchByType(String type);
    List<Vehicle> searchByModel(String model);
}

public class VehicleCatalog implements search {
    private HashMap<String, List<Vehicle>> vehicleTypes = new Hashmap<>();
    private Hashmap<String, List<Vehicle>> vehicleModels = new Hashmap<>();
}

//car rental system and car branch

public class CarRentalBranch {
    private String name;
    private Address address;
    private List<ParkingStall> stalls;
}

//singleton
public class CarRentalSystem {
    private String name;
    private List<CarRentalBranch> branches = new ArrayList<>();
    private static CarRentalSystem system = null;
    private CarRentalSystem() {}
    public static CarRentalSystem getInstance() {
        if (system == null) {
            system = new CarRentalSystem();
            return system;
        }
    }
}


