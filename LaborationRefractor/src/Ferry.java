import java.awt.*;

/**
 * @author ludwighultqvist, hassanjaber, alexanderbrunnegård
 * @version 1.0
 * @since oct 2017
 */


public class Ferry extends TransportVehicle {

    /**
     * runs the transportVehicles constructor with attributes below
     * @param color custom color
     * @param x custom initial x
     * @param y custom initial y
     */
    Ferry(Color color, int x, int y) {
        super(100, color, "StenaLine", x, y, 20);
    }
    //todo edit constructor

    /**
     * removes first car instead of last
     */
    @Override
    protected Vehicle remove() {
        Vehicle car = this.carsLoaded.remove(0);
        car.startEngine();

        return car;
    }
}
