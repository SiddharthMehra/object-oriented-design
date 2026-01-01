//state pattern

public enum ProductType {
    CHOCOLATE, SNACK, BEVERAGE, OTHER
}

public interface State {
    void insertMoney(VendingMachine vm, double amount);
    void selectProduct(VendingMachine vm, int rackNumber);
}

//state of three types -> NoMoneyInserted, MoneyInserted, DispenseState

public class NoMoneyInsertedState implements State {
    @Override
    public void insertMoney(VendingMachine vm, double amount) {
        //implement logic
    }

    @Override
    public void selectProduct(VendingMachine vm, int rackNumber) {
        //to be implemented
    }
}

public class MoneyInsertedState implements State {
    @Override
    public void insertMoney(VendingMachine vm, double amount) {
        //implement logic
    }

    @Override
    public void selectProduct(VendingMachine vm, int rackNumber) {
        //to be implemented
    }
}


public class DispenseState implements State {
    @Override
    public void insertMoney(VendingMachine vm, double amount) {
        //implement logic
    }

    @Override
    public void selectProduct(VendingMachine vm, int rackNumber) {
        //to be implemented
    }
}

//product -> what the item is, rack holds product instances, inventory serves as lookup service for each rack

public class Product {
    private final String name;
    private final int id;
    private final double price;
    private final ProductType productType;

    public Product(int id, String name, double Price, ProductType productType) {}

    public int getId() {return 0;}
    public String getName() {return null;}
    public double getPrice() {return 0.0;}
    public ProductType getProductType() {return null;}

}

public class Rack {
    private final int rackNumber;
    private Product product;
    private int quantity;

    public Rack(int rackNumber) {}

    public int getRackNumber() {return 0;}
    public boolean isEmpty() {return false;}
    public void loadProduct(Product product, int quantity) {}
    public Product peekProduct() {return null;}
    public void dispenseOne() {}
}

public class Inventory {
    public void addRack(Rack rack) {}
    public Rack getRack(int rackNumber) {return null;}
    public Collection<Rack> allRacks() {return null;}
}

//singleton vending machine class

public class VendingMachine {
    private final State noMoneyState = new NoMoneyInsertedState();
    private final State moneyInsertedState = new MoneyInsertedState();
    private final State dispenseState = new DispenseState();

    private State currentState = noMoneyState;
    private double currentAmount = 0.0;
    private int selectedRank = -1;
    private final Inventory inventory = new Inventory();

    private static VendingMachine instance;
    private VendingMachine() {}

    public static VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    State getNoMoneyState() {return noMoneyState;}
    State getMoneyInsertedState() {return moneyInsertedState;}
    State getDispenState() {return dispenseState;}

    void setState(State state) {this.currentState = state;}

    double getCurrentAmount() {return currentAmount;}
    void addToCurrentAmount(double amt)
    Inventory getInventory() {return inventory;}
    void setSelectedRack(int rack) {
        // to be implemented
    }

    public void insertMoney(double amount) {
        currentState.insertMoney(this, amount);
    }

    public void selectProduct(int rackNumber) {
        currentState.selectProduct(this, rackNumber);
    }

    public void dispenseProduct() {}
    public void refund() {}
    public void addRack(Rack rack) {}
    public void loadProduct(int rackNumber, Product product, int quantity) {}
    public void showInventory() {}


}