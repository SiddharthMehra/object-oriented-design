//design patterns
//singleton
//strategy -> to handle different payment methods
//factory -> to maintain different notification types
//observer -> allows guests to receive various notifications 
//builder -> to manage the complex construction of RoomBooking and Invoice objects


//enum -> RoomStyle, RoomStatus, BookingStatus

 enum RoomStyle {
    STANDARD, DELUXE, FAMILY_SUITE, BUSINESS_SUITE
}

enum RoomStatus {
    AVAILABLE, RESERVED, OCCUPIED, NOT_AVAILABLE, BEING_SERVICED, OTHER
} 

enum BookingStatus {
    REQUESTED, PENDING, CONFIRMED, CANCELLED, BLACKLISTED
}

enum AccountType {
    MEMBER, GUEST, MANAGER, RECEPTIONIST
}

enum PaymentStatus {
    UNPAID, PENDING, CANCELLED, COMPLETED, FILLED, DECLINED, SETTLED, REFUNDED
}

// address and account

public class Address {
    private String streetAddress;
    private String city;
    private String zipCode;
    private String state;
    private String country;
}

public class Account {
    private String id;
    private String password;
    private AccountStatus status;

    public boolean resetPassword() {}
}

//person -> Guest, Receptionist, Server, Housekeeper

public abstract class Person {
    private String name;
    private String address;
    private String email;
    private String phone;
    private Account account;
}

public class Guest extends Person {
    private int totalRoomsCheckedIn;
    public List<RoomBooking> getBookings();
    public boolean createBooking() {}
}

public class Receptionist extends Person {
    public List<Person> searchMember(String name) {}
    public boolean createBooking() {}
}

public class Housekeeper extends Person {
    public boolean assignToRoom() {}
}

//service -> Amenity, roomService, kitchenService

public abstract class Service {
    private Date issuedAt;

    public boolean addInvoiceItem(Invoice invoice) {}
}

public class Amenity extends Service {
    private String name;
    private String description;
}

public class RoomService extends Service {
    private boolean isChargeable;
    private Date requestTime;
}

public class KitchenService extends Service {
    private String description;
}



public class Invoice {
    private double amount;
    public boolean createBill() {}
}


public class RoomBooking {
    private String reservationNumber;
    private Date startDate;
    private int durationDays;
    private BookingStatus status;
    private Date checkIn;
    private Date checkOut;

    private int guestId;
    private Room room;
    private Invoice invoice;
    private List<Notification> notifications;

    public static RoomBooking fetchDetails(String reservationNumber) {}
}

//bill transaction -> cash, credit card, check

public abstract class BillTransaction {
    private Date creationDate;
    private double amount;
    private PaymentStatus status;

    public abstract void initiateTransaction();
}

class CheckTransaction extends BillTransaction {
    private String bankName;
    private String checkNumber;

    public void initiateTransaction() {}

}

class CreditCard extends BillTransaction {
    private String nameOnCard;
    private int zipCode;

    public void initiateTransaction() {}
}

class Cash extends BillTransaction {
    private double cashTendered;

    public void initiateTransaction() {}
}

//notification -> sms or email

public abstract class Notification {
    private int notificationId;
    private Date createdOn;
    private String content;

    public abstract void sendNotification(Person person);
}

class SmsNotification extends Notification {
    public void sendNotification(Person person) {

    }
}

class EmailNotification extends Notification {
    public void sendNotification(Person person) {}
}

//room, room key and maintenance

public class Room {
    private String roomNumber;
    private RoomStyle roomStyle;
    private RoomStatus status;
    private double bookingPrice;
    private boolean isSmoking;
    private List<RoomKey> keys;
    private List<RoomHousekeeping> houseKeepingLog;

    public boolean isRoomAvailable;
    public boolean checkIn();
    public boolean checkOut();
}

public class RoomKey {

    private String keyId;
    private String barCode;
    private Date issuedAt;
    private boolean isActive;
    private boolean isMaster;

    public boolean assignRoom(Room room);
}

public class RoomHousekeeping {
    private String description;
    private Date startTime;
    private int duration;
    private Housekeeper housekeeper;

    public boolean addHouseKeeping(Room room) {}
}

//search interface implemented by catalog class

public interface Search {
    public static List<Room> search(RoomStyle style, int duration, Date date);
}

public class Catalog implements Search {
    private List<Room> rooms;

    public static List<Room> search (RoomStyle style, int duration, Date date);
}

//hotel and hotel branch

public class HotelBranch {
    private String name;
    private Address location;

    public List<Room> getRooms();
}

public class Hotel {
    private String name;
    private List<HotelBranch> locations;

    public boolean addLocation(HotelBranch location);
}