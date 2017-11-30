/**
 * Created by schan on 2017-11-30.
 */
public class Engine {

    private double maxPower;
    private double currentPower = 0;
    private double trimFactor;
    private boolean isEngineOn; // A less vague name

    public Engine() {
        setMaxPower(100);
        setTrimFactor(1);
        setEngineOn(false);
    }

    public Engine(double enginePower) {
        this();
        setMaxPower(enginePower);

    }

    public Engine(double currentPower, double trimFactor) {
        this(currentPower);
        setTrimFactor(trimFactor);
    }

    public double getMaxPower() {
        return maxPower;
    }

    protected void setMaxPower(double maxPower) {
        this.maxPower = maxPower;
    }

    public double getCurrentPower() {
        return currentPower;
    }

    protected void setCurrentPower(double currentPower) {
        this.currentPower = currentPower;
    }

    public double getTrimFactor() {
        return trimFactor;
    }

    protected void setTrimFactor(double trimFactor) {
        this.trimFactor = trimFactor;
    }

    public boolean getEngineOn() {
        return isEngineOn;
    }

    protected void setEngineOn(boolean engineOn) {
        isEngineOn = engineOn;
    }

    /**
     *
     * @return the factor of which the currentspeed should change
     */
    protected double speedFactor() {
        return maxPower * 0.01 * getTrimFactor();
    }

    /**
     *
     * @param amount how much the currentspeed should increase with
     */
    private void incrementSpeed(double amount){
        if (amount < 0) {
            amount = 0;
        }
        currentPower = Math.min(currentPower + speedFactor() * amount, maxPower);
    }//TODO move to engine

    /**
     *
     * @param amount how much the currentspeed should decrement with
     */

    private void decrementSpeed(double amount) {
        if (amount < 0) {
            amount = 0;
        }
        setCurrentPower(Math.max(getCurrentPower() - speedFactor() * amount, 0));
    }//TODO move to engine


    /**
     * the car stops
     * sets engineOn to false
     */
    public void stopEngine(){
        setCurrentPower(0);
        isEngineOn = false;
    }

    /**
     * the car starts
     * sets engineOn to true
     */
    public void startEngine(){
        setCurrentPower(0.1);
        isEngineOn = true;
    }

    /**
     *
     * @param amount how much the speed should increase with, only [0-1]
     */
    public void gas(double amount){

        if (!isEngineOn) {
            return;
        }

        if (0 <= amount && amount <= 1) {
            incrementSpeed(amount);
        }
        else if (amount > 1 ) {
            incrementSpeed(1);
        }

    }

    /**
     *
     * @param amount how much the speed should decrement with, only [0-1]
     */
    public void brake(double amount){
        if (0 <= amount && amount <= 1) {
            decrementSpeed(amount);
        }
        else if (amount > 1 ) {
            decrementSpeed(1);
        }
    }
}
