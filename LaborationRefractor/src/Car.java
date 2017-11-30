import java.awt.*;
/**
 * @author ludwighultqvist, hassanjaber, alexanderbrunnegård
 * @version 1.0
 * @since oct 2017
 */


public class Car extends Vehicle {

    private int nrDoors; /** Number of doors on the car*/

    public Car() {
        super();
        nrDoors = 4;
    }

    public Car(int nrDoors, double enginePower, Color color, String modelName, int x, int y) {
        this(nrDoors, new Engine(enginePower), color, modelName, x, y);
    }

    public Car(int nrDoors, Engine engine, Color color, String modelName, int x, int y) {
        super(engine, color, modelName, x, y);
        this.nrDoors = nrDoors;
    }

    //todo new constructor

}
