import java.awt.*;

/**
 * @author ludwighultqvist, hassanjaber, alexanderbrunnegård
 * @version 1.0
 * @since oct 2017
 */
public class Saab95 extends Car {

    /**
     * basic saab95 starting values except custom color
     * @param color
     */
    public Saab95(Color color, int x, int y){
        super(2, 125, color,"Saab95", x, y);


    }

    /** //
     * sets turbo on
     */
    public void setTurboOn(){
        ((TurboEngine)getEngine()).setTurboOn();

    }

    /**
     * sets turbo off
     */
    public void setTurboOff(){
        ((TurboEngine)getEngine()).setTurboOff();

    }


}