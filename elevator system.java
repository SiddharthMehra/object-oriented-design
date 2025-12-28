public enum Direction {
    UP, DOWN, IDLE
}

public enum ElevatorState {
    IDLE, UP, DOWN, MAINTENANCE
}

public enum DoorState {
    OPEN, CLOSED
}

//Button and subclasses -> hall and elevator button. it has a pure virtual function isPressed.

public abstract class Button {
    protected boolean pressed;
    public void pressDown() {}
    public void reset() {}
    public abstract boolean isPressed();
}

public class DoorButton extends Button {
    @Override
    public boolean isPressed() {return pressed;}
}

public class HallButton extends Button {
    private final Direction direction;
    public HallButton(Direction dir) {}
    public Direction getDirection() { return null;}

    @Override
    public boolean isPressed() {return false;}
}

public class ElevatorButton extends Button {
    private final int destinationFloor;
    public ElevatorButton(int floor) {}
    public int getDestinationFloor() {return 0;}
    @Override
    public boolean isPressed() {
        return false;
    }
}

public class EmergencyButton extends Button {
    public boolean getPressed() {
        return false;
    }
    public boolean setPressed(boolean val) {

    }
    @Override
    public boolean isPressed() { return false;}
}

//elevator panel and hall panel 

public class ElevatorPanel {
    private List<ElevatorButton> floorButtons;
    private DoorButton openButton;
    private DoorButton closeButton;
    private EmergencyButton emergencyButton;

    public ElevatorPanel(int numFloors) {}
    public List<ElevatorButton> getFloorButtons() {return null;}
    public DoorButton getOpenButton() {return null;}
    public DoorButton getCloseButton() {return null;}
    public EmergencyButton gEmergencyButton() {return null;}
    public void enterEmergency() {}
    public void exitEmergency() {}

}

public class HallPanel {
    private HallPanel up;
    private HallButton down;

    public HallPanel(int floorNumber, int topFloor) {}
    public HallButton getUpButton() {return null;}
    public HallButton getDownButton() {return null;}
}

//display

public class Display {
    private int floor;
    private int load;
    private Direction direction;
    private ElevatorState elevatorState;
    private boolean maintenance;
    private boolean overloaded;

    public void update(int f, int d, int load, ElevatorState s, boolean overloaded, boolean maintenance) {}
    public void showElevatorCarDisplay(int carId) {}
}

//elevator car

public class ElevatorCar {
    private final int id;
    private int currentFloor;
    private ElevatorState state;
    private final Door = new Door();
    private final Display display = new Display();
    private final ElevatorPanel panel;
    private final Queue<Integer> queue;
    private int load;
    private boolean overloaded;
    private boolean maintenance;

    public ElevatorCar(int id, int numFloors) {}
    public int getId() {return 0;}
    public int getCurrentFloor() {return 0;}
    public ElevatorState getState() {return null;}
    public ElevatorPanel getPanel() {return null;}
    public boolean isMaintenance() {return false;}
    public boolean isOverloaded() [return false;]
    public void registerRequest(int floor) {}
    public void move() {}
    public void stop() {}
    public void enterMaintenance() {}
    public void exitMaintenance() {}
    public void emergencyStop() {}
    public void addLoad(int kg) {}
    public void removeLoad(int kg) {}
    public Display getDisplay() {return null;}
    public Door getDoor() {return null;}
}

//door and floor

public class Door {
    private DoorState state;
    public void open() {}
    public void close() {}
    public boolean isOpen() {return false;}
    public DoorState getState() {return null;}
}

public class Floor {
    private int floorNumber;
    private final List<HallPanel> panels;
    private final Display display;

    public Floor(int floorNumber, int numPanels) {}
    public int getFloorNumber() {return 0;}
    public List<HallPanel> getPanels() {return null;}
    public HallPanel getPanel(int index) {return null;}
    public Display  getDisplay() {return null;}
}

//elevator system singleton

public class ElevatorSystem {
    private static ElevatorSystem system;
    private final Building building;

    private ElevatorSystem(int floors, int cars) {}
    public static ElevatorSystem getInstance(int floors, int cars) {return null;}
    public List<ElevatorCar> getCars() {return null;}
    public Building getBuilding() {return null;}
    public void callElevator(int floorNumber, Direction dir) {}
    public ElevatorCar getNearestIdleCar(int floor) {return null;}
    public void dispatcher() {}
    public void monitoring() {}
}

public class Building {
    private final List<Floor> floors;
    private final List<ElevatorCar> elevatorCars;

    public Building(int numFloors, int numCars, int numPanels, int numDisplaysPerFloor) {}
    public List<Floor> getFloors() {return null;}
    public List<ElevatorCar> getElevatorCars() {return null;}
}