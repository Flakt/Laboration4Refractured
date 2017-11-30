/**
 * Created by schan on 2017-11-30.
 */
public class TurboEngine extends Engine {

    private boolean turboOn;

    public TurboEngine(double enginePower) {
        super(enginePower);
    }
    public boolean isTurboOn() {
        return turboOn;
    }

    public void setTurboOn() {
        System.out.println("turbo on");
        this.turboOn = true;
    }

    public void setTurboOff() {
        System.out.println("turbo off");
        this.turboOn = false;
    }

    @Override
    public double speedFactor() { //todo should be in turboEngine
        double turbo = 1;
        if (turboOn) {
            turbo = 1.3;
        }
        return getMaxPower() * 0.01 * turbo;
    }

    /**
     * same as in superclass, but also turns of the turbo
     */
    @Override
    public void stopEngine() { //todo should be in turboEngine
        super.stopEngine();
        turboOn = false;
    }

}
