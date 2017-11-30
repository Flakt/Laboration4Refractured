import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.awt.*;
import java.util.Scanner;

/**
 * @author ludwighultqvist, hassanjaber, alexanderbrunnegård
 * @version 1.0
 * @since oct 2017
 */


public class Scania extends VehicleWithTrailer {


    /**
     * default initial properties of the Scania
     */
    Scania() {
        super(75.0, Color.CYAN,"Scania", 10, 10);

    }

    /**
     * custom initial properties of the Scania
     * @param color custom color
     * @param x custom starting x
     * @param y custom starting y
     */
    Scania(Color color, int x, int y) {
        super(75.0, color, "Scania", x, y);
    }


}
