//design patterns used -> singleton and observer pattern

public enum RSVPStatus {
    ACCEPTED, REJECTED, PENDING
}

public class User {
    private String name;
    private String email;
    private Calendar calendar;

    public User(String name, String email) {}

    public void respondInvitation(Meeting meeting, RSVPStatus response) {}
    public List<Meeting> viewMeetings() {}
}

public class Interval {

    private Date startTime;
    private Date endTime;

    public Interval(Date startTime, date endTime) {}

    public Date getStartTime() {}
    public Date getEndTime(){}

}

public class MeetingRoom {
    private int id;
    private int capacity;

    private List<Interval> bookedIntervals;
    private boolean isAvailable;

    public MeetingRoom(int id, int capacity) {}
    public boolean isAvailableFor(Interval interval, int capacity) {}

    public void bookInterval(Interval interval) {}
    public void releaseInterval(Interval interval) {}

}

//calendar contains a list of meetings to keep track of the scheduled meetings

public class Calendar {
    private List<Meeting> meetings;
    public Calendar() {}

    public void addMeeting(Meeting meeting) {}
    public void removeMeeting(Meeting meeting) {}

    public List<Meeting> getMeetings() {}
}

public class Meeting {
    private int id;
    private Map<User, RSVPStatus> participantStatus;

    private Interval interval;
    private MeetingRoom meetingRoom;
    private String subject;

    public Meeting(int id, List<User> participants, Interval interval, MeetingRoom meetingRoom, String subject) {}

    public void addParticipant(List<User> participants) {}
    public void updateParticipantStatus(RSVPStatus status, User user) {}

    public List<User> getAcceptedParticipants() {}
    public List<User> getRejectedParticipants() {}
    public List<User> getPendingParticipants() {}


}

//meeting scheduler singleton

public class MeetingScheduler {
    private User organiser;
    private Calendar calendar;
    private List<MeetingRoom> rooms;

    public MeetingScheduler(User organiser, List<MeetingRoom> rooms) {}

    public Meeting scheduleMeeting(List<User> users, Interval interval, String subject) {}
    public boolean cancelMeeting(Meeting meeting) {}
    public MeetingRoom checkRoomAvailability(int capacity, Interval interval) {}
    public boolean bookRoom(MeetingRoom room, Interval interval) {}
    public boolean releaseRoom(MeetingRoom room, Interval interval) {}

}

//notification

public class Notification {
    private int notificationId;
    private String content;
    private Date creationAt;

    public Notification(int notificationId, String content, Date creationAt) {}

    public void sendInvite(User user, Meeting meeting) {}
    public void sendCancelNotification(User user, Meeting meeting) {}
}