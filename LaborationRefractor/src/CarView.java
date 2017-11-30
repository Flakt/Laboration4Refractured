import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JFrame{
    private static final int X = 800;
    private static final int Y = 800;

    // The controller member
    //CarController carC;

    // A list of cars, modify if needed
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    private DrawPanel drawPanel = new DrawPanel(X, Y-240);

    private JPanel controlPanel = new JPanel();

    private JPanel gasPanel = new JPanel();
    private JSpinner gasSpinner = new JSpinner();
    private int gasAmount = 0;

    private JLabel gasLabel = new JLabel("Amount of gas");

    private JButton gasButton = new JButton("Gas");
    private JButton brakeButton = new JButton("Brake");
    private JButton turboOnButton = new JButton("Saab Turbo on");
    private JButton turboOffButton = new JButton("Saab Turbo off");
    private JButton liftBedButton = new JButton("Scania Lift Bed");
    private JButton lowerBedButton = new JButton("Lower Lift Bed");

    private JButton startButton = new JButton("Start all cars");
    private JButton stopButton = new JButton("Stop all cars");






    // Constructor
    public CarView(String frameName){
        //this.carC = cc;
        initComponents(frameName);

        addInitialVehicles();
    }

    /** Sets everything in place and fits everything
     * @param title title of the view
     */
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));


        this.add(drawPanel);

        setupGasPanel();
        /*
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);
        */

        setupControlPanel();
        /*
        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        controlPanel.setBackground(Color.CYAN);
        this.add(controlPanel);
        */

        setupStartButton();
        /*
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);
        */


        setupStopButton();
        /*
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);
        */

        // This actionListener is for the gas button only
        //
        /*
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.gas(gasAmount);

                System.out.println(gasAmount);
            }
        });
        */


        addButtonListeners();







        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        //setup list
        vehicles = new ArrayList<>(10);
    }


    //setup methods

    /**
     * sets up gasPanel
     */
    private void setupGasPanel() {
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);
    }

    /**
     * sets up controlPanel
     */
    private void setupControlPanel() {
        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        controlPanel.setBackground(Color.CYAN);
        this.add(controlPanel);
    }

    /**
     * sets up startButton
     */
    private void setupStartButton() {
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);
    }

    /**
     * sets up stopButton
     */
    private void setupStopButton() {
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);
    }

    /**
     * sets up the initial vehicles
     */
    private void addInitialVehicles() {

        addVehicle(new Volvo240(Color.BLUE, 0, 0));
        addVehicle(new Saab95(Color.RED, 0, 100));
        addVehicle(new Scania(Color.YELLOW, 0, 200));
    }

    /**
     * sets up all buttons actions
     */
    private void addButtonListeners() {
        addAction(gasButton, gasAction());
        addAction(brakeButton, brakeAction());

        addAction(turboOnButton, turboOnAction());
        addAction(turboOffButton, turboOffAction());

        addAction(startButton, startAllAction());
        addAction(stopButton, stopAllAction());

        addAction(liftBedButton, liftBedAction());
        addAction(lowerBedButton, lowerBedAction());
    }


    /**
     * ads actionListener to one button
     * @param button the button
     * @param listener the actionListener
     */
    private void addAction(JButton button, ActionListener listener) {
        button.addActionListener(listener);
    }

    //actions for each button to implement

    /**
     *
     * @return the gas actionListener
     */
    private ActionListener gasAction() { //gas all cars
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(gasAmount);
            }
        };

        return listener;
    }

    /**
     *
     * @return the brake actionListener
     */
    private ActionListener brakeAction() { //brake all cars
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(gasAmount);
            }
        };

        return listener;
    }

    /**
     *
     * @return the turboOn actionListener
     */
    private ActionListener turboOnAction() { // saab.setTurboOff
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOn();
            }
        };

        return listener;
    }

    /**
     *
     * @return the turboOff actionListener
     */
    private ActionListener turboOffAction() { // saab.setTurboOn
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOff();
            }
        };

        return listener;
    }

    /**
     *
     * @return the liftBed actionListener
     */
    private ActionListener liftBedAction() { // lift the trailer
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liftBed();
            }
        };

        return listener;
    }

    /**
     *
     * @return the lowerBed actionListener
     */
    private ActionListener lowerBedAction() { // lower the trailer
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowerBed();
            }
        };

        return listener;
    }

    /**
     *
     * @return the startAll actionListener
     */
    private ActionListener startAllAction() { //call startEngine() on all
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startEngines();
            }
        };

        return listener;
    }

    /**
     *
     * @return the stopAll actionListener
     */
    private ActionListener stopAllAction() { //call stopEngine() on all
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { stopEngines();
            }
        };

        return listener;
    }





    //the methods the ActionListener above uses

    /**
     * calls the gas method for all vehicles in the vehicles list
     * @param amount amount of gas
     */
    private void gas(double amount) {
        amount = amount / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(amount);

        }
        System.out.println("gas by: " + amount);
    }

    /**
     * calls the brake method for all vehicles in the vehicles list
     * @param amount amount of brake
     */
    private void brake(double amount) {
        amount = amount / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(amount);
        }
        System.out.println("brake by: " + amount);
    }

    /**
     * calls the setTurboOn method for all Saab95 in the vehicles list
     */
    private void turboOn() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
        System.out.println("turbos on");
    }

    /**
     * calls the setTurboOff method for all Saab95 in the vehicles list
     */
    private void turboOff() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
        System.out.println("turbos off");
    }

    /**
     * calls the openTrailer method for all Scania in the vehicles list
     */
    private void liftBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).openTrailer();
            }
        }
        System.out.println("beds(trailers) lifted");
    }

    /**
     * calls the closeTrailer method for all Scania in the vehicles list
     */
    private void lowerBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).closeTrailer();
            }
        }
        System.out.println("beds(trailers) lowered");
    }

    /**
     * calls the startEngine method for all vehicles in the vehicles list
     */
    private void startEngines() {
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
        System.out.println("engines on");
    }

    /**
     * calls the stopEngine method for all vehicles in the vehicles list
     */
    private void stopEngines() {
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
        System.out.println("engines off");
    }


    /**
     * moves all vehicles in the vehicles list
     */
    public void moveAll() {
        for (Vehicle vehicle : vehicles) {
            move(vehicle);
        }

        drawPanel.repaint();
    }

    /**
     * moves one vehicle
     * @param vehicle
     */
    private void move(Vehicle vehicle) {
        if (xBounds(vehicle) && yBounds(vehicle) || hasTurned(vehicle)) {
            vehicle.move();
        }
        else {
            bounce(vehicle);

        }

    }

    /**
     * bounces a car against the war
     * @param vehicle the vehicle
     */
    private void bounce(Vehicle vehicle) {
        vehicle.turnRight();
        vehicle.turnRight();

        vehicle.stopEngine();
        vehicle.startEngine();
    }

    /**
     * checks if the vehicle if in the x-bounds of the view
     * @param vehicle the vehicle
     * @return true if in bounds, else false
     */
    private boolean xBounds(Vehicle vehicle) {

        return (0 <= vehicle.getLocation().x && vehicle.getLocation().x + 100 <= X);
    }

    /**
     * checks if the vehicle if in the y-bounds of the view
     * @param vehicle the vehicle
     * @return true if in bounds, else false
     */
    private boolean yBounds(Vehicle vehicle) {
        return (0 <= vehicle.getLocation().y && vehicle.getLocation().y + 60 <= Y);

    }

    /**
     * checks if the vehicle has already turned
     * @param vehicle the vehicle
     * @return true if the vehicle has turned, else false
     */
    private boolean hasTurned(Vehicle vehicle) {
        boolean result = false;

        switch (vehicle.getOrientation()) {
            case UP:
                if (vehicle.getLocation().y +60 >= Y) {
                    result = true;
                }
                break;

            case DOWN:
                if (vehicle.getLocation().y <= 0) {
                    result = true;
                }
                break;

            case LEFT:
                if (vehicle.getLocation().x + 100 >= X) {
                    result = true;
                }
                break;

            case RIGHT:
                if (vehicle.getLocation().x <= 0) {
                    result = true;
                }
                break;
        }

        return result;
    }

    /**
     * adds a vehicle to the vehicles list in both this and the drawPanel
     * @param vehicle the vehicle that's added
     */
    private void addVehicle(Vehicle vehicle){
        if (vehicles.size() >= 10) {
            return;
        }

        vehicles.add(vehicle);
        drawPanel.addVehicle(vehicle);
    }




}
