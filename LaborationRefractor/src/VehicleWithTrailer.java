import java.awt.*;

/**
 * @author ludwighultqvist, hassanjaber, alexanderbrunnegård
 * @version 1.0
 * @since oct 2017
 */


public class VehicleWithTrailer extends Vehicle {

    private Trailer trailer; /** the trailer of the Scania */

    /**
     * custom constructor for the Vehicle with trailer
     * runs superclass constructor
     * @param enginePower starting enginePower
     * @param color starting color
     * @param modelName starting name
     * @param x starting centerX
     * @param y starting centerY
     */
    VehicleWithTrailer(Double enginePower, Color color, String modelName, int x, int y) {
        super(enginePower, color, modelName, x, y);
        trailer = new Trailer();
    }

    //todo new constructor

    /**
     * same as move() in superclass, but also closes the trailer if need be
     */
    @Override
    public void move() {
        if (trailer.isOpen()) {
            trailer.close();
        }

        super.move();
    }

    /**
     * opens the trailer
     */
    public void openTrailer() {
        if (this.getCurrentSpeed() > 0 || trailer.isOpen()) {
            System.out.println("bed cant be lifted");
            return;
        }

        trailer.open();
    }

    /**
     * closes the trailer of the vehicle
     */
    public void closeTrailer() {
        if (!trailer.isOpen()) {
            return;
        }

        trailer.close();
    }


    /**
     *
     * @return the trailer of the Vehicle
     */
    protected Trailer getTrailer() {
        return trailer;
    }
}
