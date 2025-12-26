import java.sql.Date;

// ENUMS -> PAYMENT, ACCOUNT, TICKET

enum PaymentStatus {COMPLETED, FAILED, PENDING, UNPAID, REFUNDED}
enum AccountStatus {ACTIVE, CANCELLED, CLOSED, BLACKLISTED, NONE}
enum TicketStatus {ISSUED, IN_USE, PAID, VALIDATED, CANCELLED}

//custom data type for personal and address information

class Person {
    private String name;
    private String address;
    private String phone;
    private String email;
}

class Address {
    private String zipCode;
    private String street;
    private String city;
    private String state;
    private String country;
}


//Parking Spot abstract class -> base class for ACCESSIBLE, COMPACT, LARGE, MOTORCYCLE

abstract class ParkingSpot {
        private int id;
        private boolean isFree;
        private Vehicle vehicle; // association -> each spot can be assigned to one vehicle.

        public abstract boolean assignVehicle(Vehicle vehicle);

        public boolean removeVehicle() {
            //some logic
            return true;
        }
}

class Accessible extends ParkingSpot {
    public boolean assignVehicle(Vehicle vehicle) {
        return true;
    }
}

class Compact extends ParkingSpot {
    public boolean assignVehicle(Vehicle vehicle) {
        return true;
    }
}

class Large extends ParkingSpot {
    public boolean assignVehicle(Vehicle vehicle) {
        return true;
    }
}

class Motorcyle extends ParkingSpot {
    public boolean assignVehicle(Vehicle vehicle) {
        return true;
    }
}

//Vehicle class abstract -> CAR, TRUCK, VAN, MOTORCYCLE

abstract class Vehicle {
    private String vehicleNo;
    private ParkingTicket parkingTicket;
    
    public abstract void assignTicket(ParkingTicket ticket) {}
}

class Car extends Vehicle {
    public void assignTicket(ParkingTicket ticket) {}
}

class Van extends Vehicle {
    public void assignTicket(ParkingTicket ticket) {}
}

class Truck extends Vehicle {
    public void assignTicket(ParkingTicket ticket) {}
}

class Motorcycle extends Vehicle {
    public void assignTicket(ParkingTicket ticket) {}
}

// account

abstract class Account {
    private String userName;
    private String password;
    private Person person;
    private AccountStatus accountStatus;

    public abstract boolean resetPassword();

}

class Admin extends Account {
    public boolean addParkingSpot(ParkingSpot parkingSpot) { return true; }
    public boolean addDisplayBoard(DisplayBoard displayBoard) {return true;}
    public boolean addEntrance(Entrance entrance) {return true;}
    public boolean addExit(Exit exit) {return true;}

    public boolean resetPassword() { return true;}

}

//display board and parking rate

class DisplayBoard {
    private int id;
    private Map<String, List<ParkingSpot>> parkingSpots;
    public DisplayBoard(int id) {}
    public void addParkingSpot(String spotType, List<ParkingSpot> spots) {}
    public void showFreeSlots() {}

}

class ParkingRate {
    private double hours;
    private double rate;
    public double calculate(double duration. Vehicle vehicle, ParkingSpot spot) {
        //pricing logic
        return 0.0;
    }
}

//entrance and exit

class Entrance {
    private int id;
    public ParkingTicket getTicket(Vehicle vehicle) {return null;}

}

class Exit {
    private int id;
    public ParkingTicket validateParkingTicket(ParkingTicket ticket) {return null;}
    
}

//ParkingTicket

class ParkingTicket {
    private int ticketNo;
    private Date entryTime;
    private Date exitTime;
    private double amount;
    private TicketStatus staus;

    private Vehicle vehicle;
    private Payment payment // composition -> ticket owns payment
    private Entrance entrance;
    private Exit exits;
}

//Payment

abstract class Payment {
    private double amount;
    private PaymentStatus paymentStatus;
    private Date timestamp;

    public abstract boolean initiateTransaction();
}

class Cash extends Payment {
    public boolean initiateTransaction() {
        return true;
    }
}

class CreditCard extends Payment {
    public boolean initiateTransaction() {
        return true;
    }
}

//parking lot singleton

class ParkingLot {
    private int id;
    private String name;
    private Address address;
    private ParkingRate parkingRate;

    private Map<String, Entrance> entrances;
    private Map<String, Exit> exits;
    private Map<Integer, ParkingSpot> spots;
    private Map<String, ParkingTicket> tickets;
    private List<DisplayBoard> displayBoards;

    //singleton implementation

    private static ParkingLot parkingLot = null;
    private ParkingLot() {

    }

    public static ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
            return parkingLot;
        }
    public boolean addEntrance(Entrance entrance) {
        return true;
    }

    public boolean addExit(Exit exit) {
        return true;
    }

    public boolean addParkingSpot(ParkingSpot parkingSpot) {
        return true;
    }

    public boolean addDisplayBoard(DisplayBoard displayBoard) {
        return true;
    }

    public ParkingTicket getParkingTicket(Vehicle vehicle) {
        return null;
    }

    public boolean isFull(ParkingSpot spotType) {
        return false;
    }


