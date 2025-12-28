//design patterns -> factory pattern used to create domain objects like Book and Member
//delgation pattern -> librarian delegates the task of managing book status to bookItem
//observer pattern -> used for notifications; member is notified when a bookItem status changes

enum BookFomat {
    HARDCOVER, PAPERBACK, AUDIOBOOK, EBOOK, NEWSPAPER, MAGAZINE, JOURNAL
}

enum BookStatus {
    AVAILABILE, RESERVED, LOANED, LOST
}

enum ReservationStatus {
    WAITING, PENDING, CANCELLED, NONE
}

enum AccountStatus {
    ACTIVE, CLOSED, CANCELLED, BLACKLISTED, NONE
}

// address + person classes

public class Address {
    private String streetAddress;
    private String;
    private String state;
    private int zipCode;
    private String country;
}

public class Person {
    private String name;
    private String address;
    private String email;
    private String phone;
}

// user of two types -> librarian or member

public abstract class User {
    private String id;
    private String password;
    private AccountStatus status;
    private Person person;
    private LibraryCard LibraryCard;

    public abstract boolean resetPassword();
}

public class Librarian extends User {
    public boolean addBookItem(BookItem bookItem) {}
    public boolean blockMember(Member member) {}
    public boolean unblockMember(Member member) {}
    public boolean resetPassword() {
        //definition
    }
}

public class Member extends User {
    private Date dateOfMembership;
    private int totalBooksCheckout;

    public boolean reserveBookItem(BookItem bookItem);
    private void incrementTotalBooksCheckedOut();
    public boolean checkoutBookItem(BookItem bookItem);
    public void checkForFine(String bookItemId);
    public void returnBookItem(BookItem bookItem);
    public boolean renewBookItem(BookItem bookItem);
    public boolean resetPassword() {
        //definition
    }

}

//book reservation, book lending and fine

public class BookReservation {
    private String itemId;
    private Date creationDate;
    private ReservationStatus reservationStatus;
    private String memberId;

    public static BookReservation fetchReservationDetails(String bookItemId);
}

public class BookLending {
    private String itemId;
    private Date creationDate;
    private Date dueDate;
    private Date returnDate;
    private String memberId;
    private BookReservation bookReservation;
    private User user;

    public static boolean lendBook(String bookItemId, String memberId);
    public static BookLending fetchLendingDetails(String bookItemId);
}

public class Fine {
    private Date creationDate;
    private String bookItemId;
    private String memberId;

    public static void collectFine(String memberId, long days);
}

//book and rack -> book is an abstract class, bookItem represents each copy of the book

public abstract class Book {
    private String isbn;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    private BookFormat bookFormat;
    private List<Author> authors;
}

public class BookItem {
    private String id;
    private boolean isReferenceOnly;
    private Date borrwedAt;
    private Date dueAt;
    private Double price;
    private BookStatus status;
    private Date dateOfPurchase;
    private Date publicationDate;
    private Rack placedAt;
    private Book book; //aggregation bookItem has reference to the book.

}

//notification -> email and sms

public abstract class Notification {
    private String notificationId;
    private Date creationAt;
    private String content;
    private BookLending bookLending;
    private BookReservation bookReservation;

    public abstract boolean sendNotification();
}

public class PostalNotification extends Notification {
    private Address address;
    public boolean sendNotification () {
        //definition
    }
}

public class EmailNotification extends Notification {
    private String email;
    public boolean sendNotification() {
        //definition
    }
}

//search and catalog

public interface Search {
    public List<Book> searchByTitle(String title);
    public List<Book> searchByAuthor(String author);
    public List<Book> searchBySubject(String subject);
    public List<Book> searchPublicationDate(Date publishedAt);
}

public class Catalog implements Search {
    private HashMap<String, List<Book>> bookTitles;
    private HashMap<String, List<Book>> bookAuthors;
    private HashMap<String, List<BooK>> bookSubjects
    private HashMap<String, List<Book>> bookPublishingDates;

    public List<Book> searchByTitle(String query) {}
    public List<Book> searchByAuthor(String query) {}
    public List<Book> searchBySubject(String query) {}
    public List<Book> searchByPublishingDate(String query) {}
    
}

//library singleton 

public class Library {

    private String name;
    private Address address;

    private Library library() {}

    public Address getAddress();

    private static Library library = null;

    public static Library getInstance() {
        if (library == null) {
            library = new Library();
        }
        return library;
    }
}