import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image,
    //BufferedImage volvoImage;
    // To keep track of a single cars position
    //Point volvoPoint = new Point();

    private List<Vehicle> vehicles; /** the vehicles thats supposed to be painted */


    //
    /*
    void moveit(int x, int y){
        volvoPoint.x = x;
        volvoPoint.y = y;
    }
    */


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        this.vehicles = new ArrayList<>(10);

        /*
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "src\\pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            // Linux users need to modify \ to / in path string
            volvoImage = ImageIO.read(new File(getClass().getResource("pics/Volvo240.jpg").toURI()));
        } catch (IOException | URISyntaxException ex)
        {
            ex.printStackTrace();
        }
        */


    }

    // This method is called each time the panel updates/refreshes/repaints itself
    //
    @Override
    /**
     *paint a component on the screen
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        //System.out.println(vehicles.size());

        drawAllVehicles(g);
    }

    /**
     * paints all the vehicles images at their current location.
     * calls the 'drawVehicle' method
     * @param g graphics
     */
    private void drawAllVehicles(Graphics g){
        /*if (vehicles == null || !(vehicles.size() > 0)) {
            return;
        }
        */
        //System.out.println("drawAll() called");
        for (Vehicle vehicle : vehicles) {
            drawVehicle(g, vehicle);
        }
    }

    /**
     * paints an image of one vehicle at its curent location
     * @param g graphics
     * @param vehicle one vehicle
     */
    private void drawVehicle(Graphics g, Vehicle vehicle) {
        int x = (int) Math.round(vehicle.getLocation().getX());
        int y = (int) Math.round(vehicle.getLocation().getY());
        BufferedImage image = getImage(vehicle);

        g.drawImage(image, x, y, null);
        //System.out.println("drawImage() called");
    }

    /**
     * finds the vehicles corresponding image
     * @param vehicle one vehicle
     * @return the image of the vehicle
     */
    private BufferedImage getImage(Vehicle vehicle) {
        BufferedImage image = null;
        try {
            //System.out.println(vehicle.getModelName());
            image = ImageIO.read(new File(getClass().
                    getResource("pics/" + vehicle.getModelName() + ".jpg").toURI()));
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }


        return image;
    }

    /**
     * adds a vehicle to the vehicles list
     * @param vehicle the vehicle
     */
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
}
