import java.awt.*;

/**
 * Created by schan on 2017-11-30.
 */
public class LocationHandler {
    /**
     * the possible directions Movable should use (90 degrees angles)
     */
    public enum Orientation {
        UP, DOWN, LEFT, RIGHT
    }
    private Orientation orientation; /** Current orientation of the car */
    private Point currentLocation = new Point(0, 0);

    public LocationHandler() {
        orientation = Orientation.RIGHT;
    }

    public LocationHandler(int x, int y) {
        this();
        setCurrentLocation(new Point(x,y));
    }

    /**
     *
     * @return current currentLocation
     */
    public Point getCurrentLocation() {
        return currentLocation;
    }

    /**
     *
     * @return current orientation
     */
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * sets the car currentLocation to given point
     * @param point new currentLocation
     */
    public void setCurrentLocation(Point point) {
        this.currentLocation.x = point.x;
        this.currentLocation.y = point.y;
    }

    public void move(double amount) {
        switch (orientation) {
            case UP:
                currentLocation.y -= amount;
                break;

            case DOWN:
                currentLocation.y += amount;
                break;

            case LEFT:
                currentLocation.x -= amount;
                break;

            case RIGHT:
                currentLocation.x += amount;
                break;
        }
    }

    public void turnLeft() {
        switch (orientation) {
            case UP:
                orientation = Orientation.LEFT;
                break;

            case DOWN:
                orientation = Orientation.RIGHT;
                break;

            case LEFT:
                orientation = Orientation.DOWN;
                break;

            case RIGHT:
                orientation = Orientation.UP;
                break;
        }
    }

    /**
     * changes direction to the right of the current direction (90 degrees turn)
     */
    public void turnRight() {
        switch (orientation) {
            case UP:
                orientation = Orientation.RIGHT;
                break;

            case DOWN:
                orientation = Orientation.LEFT;
                break;

            case LEFT:
                orientation = Orientation.UP;
                break;

            case RIGHT:
                orientation = Orientation.DOWN;
                break;
        }
    }
}
