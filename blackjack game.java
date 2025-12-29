public enum Suit {
    HEART, SPADE, CLUB, DIAMOND
}

public enum AccountStatus {
    ACTIVE, CANCELLED, CLOSED, BLACKLISTED, NONE
}

public class Person {
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String country;

}

public class Card {
    private Suit suit;
    private int faceValue;

    public Card(Suit suit, int faceValue) {}
    public int getValue() {}
    public Suit getSuit() {}
    public int getFaceValue() {}

    @Override
    public String toString () {}
}

//deck and shoe -> deck is a list of cards, shoe is a list of decks

public class Deck {
    private List<Card> cards;
    public Deck() {}
    public List<Card> getCards() {}

}

public class Shoe {
    private List<Deck> decks;

    public Shoe(int numberOfDecks) {}

    public void shuffle() {}

    public Card dealCard() {}
    public List<Deck> getDecks() {}
}

//hand -> represents a blackjack hand and is represented by a list of cards

public class Hand {
    private List<Card> cards;
    public Hand(Card card1, Card card2) {}

    public void addCard(Card card) {}
    public List<Card> getCards () {}
    public int getScore() {}

    @Override
    public String toString() {}

}

//player is an abstract class . blacjack player and dealer extend it

public abstract class Player {
    protected String id;
    protected String password;
    protected double balance;
    protected AccountStatus accountStatus;
    protected Person person;
    protected Hand hand;

    public Player(String id, String password, double balance, Person person ) {}

    public void setHand(Hand hand) {}
    public Hand getHand() {}
    public double getBalance() {}
    public abstract boolean resetPassword();
}

public class BlackjackPlayer extends Player {
    private double bet;

    public BlackjackPlayer(String id, String password, double balance, Person person) {
    super(id, password, balance, person);
    }

    public void placeBet(double amount) {}

    public double getBet() {}
    public void payout(double multiplier) {}

    @Override
    public boolean resetPassword() {}
}

public class Dealer extends Player {
    public Dealer(String id, String password, double balance, Person person) {
        super(id, password, balance, person);
    }

    @Override
    public boolean resetPassword() {}
}


//blackjack controller and game view

public class BlackjackController {
    public boolean validateAction(String action) {}
}

public class BlackjackGameView {
    public void showHands(Hand player, Hand dealer, boolean hideDealerHole) {}
    public void showResult(String result, double payout) {}
}

//black jack game

public class BlackjackGame {
    private BlackjackPlayer player;
    private Dealer dealer;
    private Shoe shoe;
    private BlackjackController blackjackController;
    private BlackjackGameView blackjackGameView;

    public BlackjackGame(BlackjackPlayer player, Dealer dealer, int numDecks) {}

    public void start() {}

    public void playAction(String action) {}
    public void hit() {}
    public void stand() {}

    private void compareAndSettle() {}
    private void settle(double multiplier, String message) {}
}



