//design patterns -> 
//singleton pattern
//state pattern
//chain of responsbility pattern. cash distributed 100, 50, 20 dollars distributed via a chain of handlers
//composite and builder pattern -> suggested for future extensibility

enum ATMStatus {
Idle, HasCard, SelectionOption, Withdraw, TransferMoney, BalanceEnquiry
}

enum TransactionType {
    BalanceEnquiry, CashWithdrawl, FundsTransfer, ChangePIN, Cancel
}

//user and ATM card

public class User {
    private ATMCard atmCard;
    private BankAccount account;
}

public class ATMCard {
    private String cardNumber;
    private String name;
    private Date expiryDate;
    private int pin;

}

//bank and bank account

public class Bank {
    private String name;
    private String bankCode;

    public String getBankCode() {
        return bankCode;
    }
}

public abstract class BankAccount {
    protected int accountNumber;
    protected double totalbalance;
    protected double availableBalance;

    public double getAvailableBalance() {
        return availableBalance;
    }

    public boolean withdraw(double amount) {
        if (amount<=availableBalance) {
            availableBalance-=amount;
            return true;
        }
        return false;
    }

    public boolean transfer(BankAccount toAccount, double amount) {
        if (amount<=availableBalance) {
            availableBalance-=amount;
            toAccount.availableBalance+=amount;
            return true;
        }
        return false;
    }
    public abstract double getWithdrawLimit();

}

public class SavingsAccount extends BankAccount {
    @Override
    public double getWithdrawLimit() {
        return 1000.0;
    }
}

public class CurrentAccount extends BankAccount {
    @Override
    public double getWithdrawLimit() {
        return 5000.0;
    }
}

//card reader, card dispenser, keypad, screen, printer

public class CardReader {
    public boolean readCard(ATMCard card) {
        return card!=null;
    }
}

public class CashDispenser {
    public boolean dispenseCash(int amount) {
        return true;
    }
}

public class Keypad {
    public String getInput() {
        return "";
    }
}

public class Screen {
    public void showMessage(String message) {
        System.out.println(message);
    }
}

public class Printer {
    public void printReceipt(String detail) {
        System.out.println("Receipt" + detail);
    }
}

public abstract class ATMState {
    public void insertCard(ATM atm, ATMCard atmCard) {}
    public void authenticateUser(ATM atm, ATMCard card, int pin) {}
    public void selectOperation(ATM atm, TransactionType transactionType) {}
    public void cashWithdrawl(ATM atm, ATMCard card, double amount) {}
    public void displayBalance(ATM atm, ATMCard card) {}
    public void transferMoney(ATM atm, ATMCard card, BankAccount toAccount, double amount) {}
    public void changePIN(ATM atm, ATMCard card, int pin) {}
    public void cancelTransaction(ATM atm) {}
    public void returnCard(ATM atm) {}
    public void exit(ATM atm) {}

}

public class IdleState extends ATMState {}
public class HasCardState extends ATMState {}
public class SelectedOptionState extends ATMState {}
public class CashWithdrawlState extends ATMState {}
public class TransferMoneyState extends ATMState {}
public class BalanceEnquiryState extends ATMState {}
public class ChangePinState extends ATMState {}

//ATM

public class ATM {
    private static ATM atmObject = new ATM();
    private ATMState currentATMState;
    private ATMStatus currentATMStatus;
    private int balance;
    private int noOfHundredDollarBills;
    private int noOfFiftyDollarBills;
    private int noOfTenDollarBills;

    private CardReader cardReader;
    private CashDispenser cashDispenser;
    private Keypad keypad;
    private Screen screen;
    private Printer printer;

    private ATM() {}

    public static ATM getInstance() {
        return atmObject;
    }

    public void displayCurrentState() {
        System.out.println("ATMStatus"+ currentATMStatus);
    }

    public void initialiseATM(int balance, int noOfHundredDollarBills, int noOfFiftyDollarBills, int noOfTenDollarBills) {}


}