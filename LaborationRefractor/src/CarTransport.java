import java.awt.*;

/**
 * @author ludwighultqvist, hassanjaber, alexanderbrunnegård
 * @version 1.0
 * @since oct 2017
 */


public class CarTransport extends TransportVehicle {

    /**
     * runs the transportVehicles constructor with attributes below
     * @param color custom color
     * @param x custom initial x
     * @param y custom initial y
     */

    CarTransport(Color color, int x, int y) {
        super(100, color, "CarTransport", x, y, 5);
    }
}
