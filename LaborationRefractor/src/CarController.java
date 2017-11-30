import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    private CarView frame; /** the view all cars are located at */

    // A list of cars, modify if needed
    //ArrayList<Vehicle> vehicles = new ArrayList<>();

    //methods:

    /**
     * the main method of the program
     * @param args
     */
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        //cc.vehicles.add(new Volvo240());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0");

        /*
        cc.frame.addVehicle(new Volvo240(Color.BLUE, 0, 0));
        cc.frame.addVehicle(new Saab95(Color.RED, 0, 100));
        cc.frame.addVehicle(new Scania(Color.YELLOW, 0, 200));
        */
        // Start the timer
        cc.timer.start();
    }

    /** Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frame.moveAll();
            /*
            for (Vehicle vehicle : frame.getVehicles()) {
                vehicle.move();
                int x = (int) Math.round(vehicle.getCurrentLocation().getX());
                int y = (int) Math.round(vehicle.getCurrentLocation().getY());

                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
            */


            //frame.drawPanel.repaint();
        }
    }


}
