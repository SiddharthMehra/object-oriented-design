//design patterns
//1. strategy pattern -> different locker assignment strategies, otp generation algorithms etc
// repository design pattern -> organise data access and promote a clean separation between business logic and data storage


//lockerservice singleton class consists of locker location which further consist of locker instances
//locker package extends package class

public enum LockerSize {
    EXTRA_SMALL, SMALL, MEDIUM, LARGE, EXTRA_LARGE
}

public enum LockerState {
    CLOSED, BOOKED, AVAILABLE
}

//item and order: item represents the single item while order can contain a list of items

public class Item {
    private String itemId;
    private int quantity;

    public Item(String itemId, String quantity) {}
    public String getItemId() {}
    public int getQuantity() {}
}

public class Order {
    private String orderId;
    private List<Item> items;
    private String deliveryLocation;
    private String customerId;

    public Order(String orderId, String deliveryLocation, String customerId) {}

    public String getOrderId() {}
    public String getDeliveryLocation() {}
    public String getCustomerId() {}
    public List<Item> getListItems() 
    public void addItem(Item item) {}
}

//order is packed, represented by the package; packages contained in locker represented by LockerPackage class

public class Package {
    private String packageId;
    private double packageSize;
    private Order order;

    public Package(String packageId, double packageSize, Order order) {}

    public String getPackageId() {}
    public double getPackageSize() {}
    public Order getOrder() {}
    public void pack() {}
}

public class LockerPackage extends Package {

    private int codeValidDays;
    private String lockerId;
    private String code;
    private Date packageDeliveryTime;
    private String deliveryPersonId;

    public LockerPackage(String packageId, double packageSize, Order order, int codeValidDays, String lockerId, String code, Date packageDeliveryTime, String deliveryPersonId) {}

    public int getCodeValidDays() {}
    public String getLockerId() {}
    public String getCode() {}
    public Date getPackageDeliveryTime() {}
    public String getDeliveryPersonId() {}

    public boolean isValidCode() {}
    public boolean verifyCode(String code) {}
}

//customer and delivery person

public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String phone;

    public Customer(String customerId, String name, String email, String phone) {}

    public void placeOrder(Order order) {}
    public void requestReturn(Order order) {}

    public void receiveNotification(Notification notification) {}
}

public class DeliveryPerson {
    private String deliveryPersonId;
    public DeliveryPerson(String deliveryPersonId) {}

    public void deliverPackage(LockerPackage pkg, Locker locker) {}
    public void pickupReturn(LockerPackage pkg, Locker locker) {}
    public void receiveNotification(Notification notification) {}
}

//locker most important class, locker location can contain multiple location instances

public class Locker {
    private String lockerId;
    private LockerSize lockerSize;
    private String locationId;
    private LockerState lockerState;
    private LockerPackage lockerPackage;

    public boolean addPackage();
    public boolean removePackage();
}

public class LockerLocation {
    private String name;
    private List<Locker> lockers;
    private double latitude;
    private double longitude;
    private Date openTime;
    private Date closeTime;

    public void addLocker(Locker locker) {
        //implement logic
    }
}

//lockerService singleton and notification

public class LockerService {
    private List<LockerLocation> locations;

    private static LockerService lockerService = null;

    public static LockerService getInstance() {
        if (lockerService == null) {
            lockerService = new LockerService();
        }
        return lockerService;
    }

    public void addLocation(LockerLocation loc) {}

    public Locker findLockerById(String lockerId) {}

    public boolean requestReturn(Order order) {}

    public Locker requestLocker() {}

    public boolean verifyOTP(LockerPackage lpg, String code) {}
}


public class Notification {
    private String customerId;
    private String orderId;
    private String lockerId;
    private String code;

    public void send();

}