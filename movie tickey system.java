// design pattersns:
// strategy pattern for dynamic pricing
//factory pattern to create instances of seats, payments or notifications
//observer pattern to decouple events from user communications
//singleton pattern for global services like notification service
//builder pattern for creating complex objects like bookings or tickets

import java.util.Date;
import java.util.List;
import java.util.ArrayList;



public enum PaymentStatus {
    PENDING, CONFIRMED, DECLINED, REFUNDED
}

public enum BookingStatus {
    PENDING, CONFIRMED, CANCELLED, DENIED, REFUNDED
}

public enum SeatStatus {
    AVAILABLE, BOOKED, RESERVED
}

public abstract class Person {
    public String name;
    public String address;
    public String phone; 
    public String email;
}

public class Customer extends Person {

    public List<Booking> bookings = new ArrayList<>();

    public boolean createBooking(Booking booking) {
        return true;
    }

    public boolean updateBooking(Booking booking) {
        return true;
    }

    public boolean deleteBooking(Booking booking) {
        return true;
    }
}

public class Admin extends Person {
    public boolean addShow(Showtime show) {
        return true;
    }

    public boolean updateShow(Showtime show) {
        return true;
    }

    public boolean deleteShow(Showtime show) {
        return true;
    }

    public boolean addMovie(Movie movie) {
        return true;
    }

    public boolean deleteMovie(Movie movie) {
        return true;
    }
}

public class TicketAgent extends Person {
    public boolean createBooking(Booking booking) {
        return true;
    }
}

//seat -> of three types, platinum, gold and silver

public abstract class Seat {
    public String seatNo;
    public SeatStatus status;

    public boolean isAvailable() {
        return status == SeatStatus.AVAILABLE;
    }

    public abstract void setSeat();
    public abstract void setRate();
} 

public class Platinum extends Seat {

    public double rate;

    public void setSeat() {}
    public void setRate() {}
}

public class Gold extends Seat {

    public double rate;

    public void setSeat() {}
    public void setRate() {}
}

public class Silver extends Seat {

    public double rate;

    public void setSeat() {}
    public void setRate() {}
}

//movie, showtime and movie ticket

public class Movie {
    public String title;
    public String genre;
    public Date releaseDate;
    public String language;
    public int duration;
    public List<ShowTime> shows = new ArrayList<>();

    public Movie(String title, String genre, Date releaseDate, String language, int duration, List<Showtime> shows) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.language = language;
        this.duration = duration;
        this.shows = shows;
    }
}

public class ShowTime {
    public int showId;
    public Date startTime;
    public Date date;
    public int duration;
    public List<Seat> seats = new ArrayList<>();

    public ShowTime(int showId, Date startTime, Date date, int duration, List<Seat> seats) {
        this.showId = showId;
        this.startTime = startTime;
        this.date = date;
        this.duration = duration;
        this.seats = seats; 
    }

    public void showAvailableSeats() {}
}

public class MovieTicket {
    public int ticketId;
    public Seat seat;
    public Movie movie;
    public ShowTime show;

    public MovieTicket(int ticketId, Seat seat, Movie movie, ShowTime show) {
        this.ticketId = ticketId;
        this.seat = seat;
        this.movie = movie;
        this.show = show;
    }
}

//city, cinema and hall

public class City {
    public String name;
    public String state;
    public int zipCode;
    public List<Cinema> cinemas = new ArrayList<>();

    public City(String name, String state, int zipCode, List<Cinema> cinemas) {
        this.name = name;
        this.state = state;
        this.zipCode = zipCode;
        this.cinemas = cinemas;
    }
}

public class Cinema {
    public int cinemaId;
    public List<Hall> halls = new ArrayList<>();
    public City city;

    public Cinema(int cinemaId, List<Hall> halls, City city) {
        this.cinemaId = cinemaId;
        this.halls = halls;
        this.city = city;
    }
}

public class Hall {
    public int hallId;
    public List<ShowTime> shows = new ArrayList<>();

    public Hall(int hallId, List<ShowTime> shows) {
        this.hallId = hallId;
        this.shows = shows;
    }

    public List<ShowTime> findCurrentShows() {
        return shows;
    }
}

//payment class -> credit card and cash

public abstract class Payment {
    public double amount;
    public Date timestamp;
    public PaymentStatus paymentStatus;

    public abstract boolean makePayment();
}

public class Cash extends Payment {
    public boolean makePayment() {
        return true;
    }
}

public class CreditCard extends Payment {
    public String nameOnCard;
    public String cardNumber;
    public String billingAddress;
    public int code;
    public boolean makePayment() {
        return true;
    }
}

//notification

public abstract class Notification {
    public int notificationId;
    public Date createdOn;
    public String content;

    public abstract void sendNotification();
}

public class EmailNotification extends Notification {
    public void sendNotification(Person person) {}
}

public class PhoneNotification extends Notification {
    public void sendNotification(Person person) {}
}

//main class booking

public class Booking {
    public int bookingId;
    public int amount;
    public int totalSeats;
    public Date createdOn;
    public BookingStatus bookingStatus;
    public Payment payment;
    public List<MovieTicket> tickets;
    public List<Seat> seats;

    public Booking(int bookingId, int amount, int totalSeats, Date createdOn, BookingStatus status, Payment payment, List<MovieTicket> tickets, List<Seat> seats) {
        this.bookingId = bookingId;
        this.amount = amount;
        this.totalSeats = totalSeats;
        this.createdOn = createdOn;
        this.status = status;
        this.payment = payment;
        this.tickets = tickets;
        this.seats = seats;
    }
}

//search and catalog

public interface search {
    List<Movie> searchMovieByTitle(String title);
    List<Movie> searchMovieByLanguage(String language);
    List<Movie> searchMovieByGenre(String genre);
    List<Movie> searchMovieByReleasedDate(Date date);
}

public class Catalog implements Search {

    public Hashmap<String, List<Movie>> movieTitles = new Hashmap<>();
    public Hashmap<String, List<Movie>> movieLanguages = new Hashmap<>();
    public Hashmap<String, List<Movie>> movieGenres = new Hashmap<>();
    public Hashmap<String, List<Movie>> movieReleasedDate = new Hashmap<>();

    public List<Movie> searchMovieByTitle(String title) {}
    public List<Movie> searchMovieByLanguage(String language) {}
    public List<Movie> searchMovieByGenre(String genre) {}
    public List<Movie> searchMovieByReleasedDate(String date) {}



}