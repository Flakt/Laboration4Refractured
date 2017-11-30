/**
 * @author ludwighultqvist, hassanjaber, alexanderbrunnegård
 * @version 1.0
 * @since oct 2017
 */
//todo rename
public class Trailer{
    private boolean isOpen; /** if the trailer is open or not */
    private int angle; /** the current angle of the trailer */
    private final int maxAngle = 70; /** the maximum angle of the trailer */
    private final int minAngle = 0; /** the minimum angle of the trailer */

    /**
     * default initial properties of the trailer
     * isOpen is set to false
     * angle is set to minimum angle
     */
    Trailer()    {
        isOpen = false;
        angle = minAngle;

    }

    /**
     * custom initial properties of the trailer
     * @param isOpen custom value of isOpen variable
     * @param angle custom value of angle variable
     */
    Trailer(boolean isOpen, int angle){
        this.isOpen = isOpen;
        this.angle = angle;
    }


    /**
     * opens the trailer fully
     */
    public void open() {
        incrementAngle(maxAngle);
    }

    /**
     * closes the trailer fully
     */
    public void close() {
        decrementAngle(maxAngle);
    }


    /**
     * increments the angle of the trailer
     * @param amount increments by this amount
     */
    private void incrementAngle(int amount) {
        if (amount < 0) {
            return;
        }

        if (angle + amount > maxAngle) {
            angle = maxAngle;
        }
        else {
            angle += amount;
        }
        updateIsOpen();
    }

    /**
     * decrements the angle of the trailer
     * @param amount decrements by this amount
     */
    private void decrementAngle(int amount) {
        if (amount < 0) {
            return;
        }

        if (angle - amount <= minAngle) {
            angle = 0;
        }
        else if (amount == maxAngle){
            angle = 0;
        }
        else {
            angle -= amount;
        }
        updateIsOpen();
    }

    /**
     * updates the value of isOpen to true if the angle is at maximum value. else sets to false
     */
    private void updateIsOpen() {
        isOpen = !(angle < maxAngle);
    }

    /**
     *
     * @return current value of isOpen
     */
    public boolean isOpen() {
        return isOpen;
    }

    /**
     *
     * @return current value of angle
     */
    public int getAngle() {
        return angle;
    }

    /**
     *
     * @return the value of maxAngle
     */
    public int getMaxAngle() {
        return maxAngle;
    }

    /**
     *
     * @return the value of minAngle
     */
    public int getMinAngle() {
        return minAngle;
    }


}
