import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author ludwighultqvist, hassanjaber, alexanderbrunnegård
 * @version 1.0
 * @since oct 2017
 */


public class TransportVehicle extends  VehicleWithTrailer {

    protected List<Vehicle> carsLoaded; /**the storage of cars on a transport vehicle*/
    private final int maxCapacity; /** the maximum capacity of the storage */

    /**
     * custom constructor of a transport vehicle
     * @param enginePower starting enginePower
     * @param color starting color
     * @param modelName starting name
     * @param x starting centerX
     * @param y starting centerY
     * @param maxCapacity the final capacity of this particular storage
     */
    public TransportVehicle(double enginePower, Color color, String modelName, int x, int y, int maxCapacity) {
        super(enginePower, color, modelName, x, y);

        this.maxCapacity = maxCapacity;
        this.carsLoaded = new ArrayList<>();
    }


    /**
     *
     * @param distance how far the new point is
     * @return a new point
     */
    private Point newLocation(int distance) {
        Point currentPoint = this.getLocation();
        Point point;
        switch (this.getOrientation()) {
            case UP:
                point = new Point(currentPoint.x, currentPoint.y + distance);
                break;
            case DOWN:
                point = new Point(currentPoint.x, currentPoint.y - distance);
                break;
            case RIGHT:
                point = new Point(currentPoint.x - distance, currentPoint.y);
                break;
            case LEFT:
                point = new Point(currentPoint.x + distance, currentPoint.y);
                break;
            default:
                point = new Point(0, 0);
        }

        return point;
    }

    /**
     *
     * @param car a car in the universe
     * @return if the car has the same orientation as this vehicle
     */
    private boolean hasCorrectOrientation(Vehicle car) {
        return (this.getOrientation() == car.getOrientation());
    }


    /**
     *
     * @param car a car in the universe
     * @return if the cars location is close enough to this vehicle
     */
    private boolean carInRange(Vehicle car) {
        Point p1 = this.getLocation();
        Point p2 = car.getLocation();

        boolean rightX = Math.abs(p1.x - p2.x) <= 5;
        boolean rightY = Math.abs(p1.y - p2.y) <= 5;

        if (rightX && rightY) {
            return true;
        }

        return false;
    }

    //

    /**
     *
     * @return if this vehicle can be loaded or unloaded
     */
    private boolean canBeLoaded() {
        if (this.getCurrentSpeed() == 0 && this.getTrailer().isOpen()) {
            return true;
        }

        return false;
    }

    private boolean isLoaded(Vehicle car) {
        for (Vehicle car2 : carsLoaded) {
            if (car == car2) {
                return true;
            }
        }

        return false;
    }



    /**
     *
     * @return if the storage stack has the same size as the maxCapacity
     */
    private boolean isFull() {

        if (carsLoaded.size() == maxCapacity) {
            return true;
        }

        return false;
    }

    /**
     *
     * @return if the storage stack is empty
     */
    private boolean isEmpty() {
        if (carsLoaded.size() == 0) {
            return true;
        }

        return false;
    }

    /**
     *
     * @param car if the car can be loaded
     * @return true if loading car is possible, else false
     */
    public boolean canLoadCar(Vehicle car) {
        boolean canLoad = canBeLoaded() && !isFull() && carInRange(car)
                && hasCorrectOrientation(car) && !isLoaded(car) && !car.isLoaded();

        return canLoad;
    }

    /**
     *
     * @return true if the it is possible to unload a car, else false
     */
    public boolean canUnloadCar() {
        return canBeLoaded() && !isEmpty();
    }


    /**
     * adds a car to the carsLoaded stack
     * @param vehicle the car that's added
     */
    private void add(Vehicle vehicle) {

        if (vehicle instanceof Car) {
            carsLoaded.add(vehicle);
            vehicle.stopEngine();
        }

    }

    /**
     * removes the LAST added car from the carsLoaded stack
     */
    protected Vehicle remove() {
        Vehicle car = carsLoaded.remove(carsLoaded.size() - 1);
        car.setLocation(newLocation(10));
        car.startEngine();

        return car;
    }

    /**
     *
     * @param car a car that wants to be loaded onto the transport vehicle
     */
    public void load(Vehicle car) {

        /*
        boolean canLoad = canBeLoaded() && !isFull() && carInRange(car)
                && hasCorrectOrientation(car) && !isLoaded(car);
        */

        if (canLoadCar(car)) {
            add(car);
            car.loadOntoTransport(this);
        }
    }

    /**
     * unloads a car from this vehicle
     */
    public void unload() {

        if (canUnloadCar()) {
            Vehicle car = remove();
            car.loadOffTransport(this);

        }
    }

    /**
     * moves one car according to this particular vehicles location
     * @param car the car thats moved
     */
    private void updateCarLocation(Vehicle car) {
        car.setLocation(this.getLocation());
    }

    /**
     * same as move() in superclass but also moves the cars in the storage.
     */
    @Override
    public void move() {
        super.move();

        for (Vehicle car : carsLoaded) {
            updateCarLocation(car);
        }
    }

    /**
     * same as turnLeft() in superclass but also turns the cars in the storage.
     */
    @Override
    public void turnLeft() {
        super.turnLeft();

        for (Vehicle car : carsLoaded) {
            car.turnLeft();
        }
    }

    /**
     * same as turnRight() in superclass but also turns the cars in the storage.
     */
    @Override
    public void turnRight() {
        super.turnRight();

        for (Vehicle car : carsLoaded) {
            car.turnRight();
        }

    }


    /**
     *
     * @return the current load of the transport
     */
    public List<Vehicle> getCarsLoaded() {
        return carsLoaded;
    }
}
