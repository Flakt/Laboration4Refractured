import java.awt.*;

/**
 * @author ludwighultqvist, hassanjaber, alexanderbrunnegård
 * @version 1.0
 * @since oct 2017
 */

public class Vehicle implements Movable {

    private LocationHandler locationHandler;
    private Engine engine;
    private Color color; /** Color of the car */
    private String modelName; /** The car model name */
    private boolean isLoaded;/** if the vehicle is loaded onto a transport */


    /**
     * sets the variables to the "normals" of a regular Vehicle
     */
    public Vehicle() {
        engine = new Engine();
        color = Color.BLACK;
        modelName = "basicCar";
        locationHandler = new LocationHandler(10,10);
        isLoaded = false;
    }

    /**
     *
     * @param engine starting engine
     * @param color starting color
     * @param modelName starting name
     * @param x starting centerX
     * @param y starting centerY
     *
     * sets orientation to right
     *
     */
    public Vehicle(Engine engine, Color color, String modelName, int x, int y) {
        this.engine = engine;
        this.color = color;
        this.modelName = modelName;
        locationHandler = new LocationHandler(x,y);
        isLoaded = false;
    }

    public Vehicle(double enginePower, Color color, String modelName, int x, int y) {
        this(new Engine(enginePower), color, modelName, x, y);
    }

    public Engine getEngine() {
        return engine;
    }

    /**
     * the car stops
     * sets engineOn to false
     */
    public void stopEngine(){
        engine.stopEngine();
    }

    /**
     * the car starts
     * sets engineOn to true
     */
    public void startEngine(){
        if (isLoaded) {
            return;
        }
        engine.startEngine();
    }

    /**
     *
     * @param amount how much the speed should increase with, only [0-1]
     */
    public void gas(double amount){
        engine.gas(amount);
    }

    /**
     *
     * @param amount how much the speed should decrement with, only [0-1]
     */
    public void brake(double amount){
        engine.brake(amount);
    }

    /**
     * moves the car in the current orientation it is headed.
     * moves it by currentspeed / 10.
     */
    public void move() {
        locationHandler.move(engine.getCurrentPower() / 10.0);
    }

    /**
     * changes direction to the left of the current direction (90 degrees turn)
     */
    public void turnLeft() {
        locationHandler.turnLeft();
    }

    /**
     * changes direction to the right of the current direction (90 degrees turn)
     */
    public void turnRight() {
        locationHandler.turnRight();
    }

    /**
     * sets  isLoaded to true if the transportVehicles requirements are fulfilled
     * @param transportVehicle the vehicle to check
     */
    public void loadOntoTransport(TransportVehicle transportVehicle) {
        if (transportVehicle != null && transportVehicle.canLoadCar(this)) {
            isLoaded = true;
        }
    }

    /**
     * sets  isLoaded to true if the transportVehicles requirements are fulfilled
     * @param transportVehicle the vehicle to check
     */
    public void loadOffTransport(TransportVehicle transportVehicle) {
        if ((transportVehicle.canUnloadCar())) {
            isLoaded = false;
        }
    }

    //getters

    /**
     *
     * @return current currentSpeed
     */
    public double getCurrentSpeed(){
        return engine.getCurrentPower();
    }

    /**
     *
     * @return current color
     */
    public Color getColor(){
        return color;
    }

    /**
     *
     * @return current location
     */
    public Point getLocation() {
        return locationHandler.getCurrentLocation();
    }

    /**
     *
     * @return current orientation
     */
    public LocationHandler.Orientation getOrientation() {
        return locationHandler.getOrientation();
    } //todo delegate to LocationHandler

    /**
     * @param clr the color of the car
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * sets the car location to given point
     * @param point new location
     */
    public void setLocation(Point point) {
        if (isLoaded) {
            return;
        }
        locationHandler.setCurrentLocation(point);
    }


    /**
     *
     * @return the value of isLoaded
     */
    public boolean isLoaded() {
        return isLoaded;
    }

    /**
     *
     * @return the modelName
     */
    public String getModelName() {
        return modelName;
    }
}
