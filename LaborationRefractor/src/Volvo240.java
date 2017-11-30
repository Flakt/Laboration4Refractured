import java.awt.*;

/**
 * @author ludwighultqvist, hassanjaber, alexanderbrunnegård
 * @version 1.0
 * @since oct 2017
 */
public class Volvo240 extends Car {

    /**
     * basic Volvo240 starting values with custom color
     * @param color color of the volvo
     */
    public Volvo240(Color color, int x, int y){
        super(4, 100, color,"Volvo240", x, y);
        getEngine().setTrimFactor(1.25);
    }

}