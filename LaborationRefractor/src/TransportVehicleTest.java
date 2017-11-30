/**

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TransportVehicleTest {

    TransportVehicle truck = new CarTransport(Color.CYAN, 100, 100);

    Car car1 = new Car(4, 100, Color.YELLOW, "Car1", 100, 100);
    Car car2 = new Car(4, 100, Color.YELLOW, "Car2", 105, 105);
    Car car3 = new Car(4, 100, Color.YELLOW, "Car3", 95, 95);

    Car car4 = new Car(4, 100, Color.YELLOW, "Car4", 120, 120);
    Car car5 = new Car(4, 100, Color.YELLOW, "Car5", 80, 80);

    Car car6 = new Car(4, 100, Color.YELLOW, "Car6", 100, 100);
    //set orientation wrong

    Scania scania = new Scania(Color.blue, 100, 100);



    Car car10 = new Car(4, 100, Color.YELLOW, "Car10", 100, 100);
    Car car11 = new Car(4, 100, Color.YELLOW, "Car11", 100, 100);
    Car car12 = new Car(4, 100, Color.YELLOW, "Car12", 100, 100);
    Car car13 = new Car(4, 100, Color.YELLOW, "Car13", 100, 100);







    @Test
    void remove() {
        load();

        int count = 0;
        while (count < 20) {
            truck.move();
            count++;
        }

        truck.remove();
        assertTrue(Math.abs(car11.getCurrentLocation().x - truck.getCurrentLocation().x) == 10);

        truck.turnLeft();
        truck.remove();
        assertTrue(Math.abs(car10.getCurrentLocation().y - truck.getCurrentLocation().y) == 10);

        assertTrue(truck.getCarsLoaded().get(0) == car1);

    }

    @Test
    void load() {
        truck.openTrailer();
        assertTrue(truck.getCarsLoaded().size() == 0);

        truck.load(car1); //correct load
        assertTrue(truck.getCarsLoaded().size() == 1);

        truck.load(car2);//correct load
        assertTrue(truck.getCarsLoaded().size() == 2);

        truck.load(car3);//correct load
        assertTrue(truck.getCarsLoaded().size() == 3);


        truck.load(car4); //out of range
        truck.load(car5);//out of range
        assertTrue(truck.getCarsLoaded().size() == 3);

        car6.turnRight();
        truck.load(car6); //wrong orientation
        assertTrue(truck.getCarsLoaded().size() == 3);

        truck.load(scania); //wrong kind
        assertTrue(truck.getCarsLoaded().size() == 3);

        truck.load(truck); // cant load itself
        assertTrue(truck.getCarsLoaded().size() == 3);

        truck.load(car1); // already loaded
        assertTrue(truck.getCarsLoaded().size() == 3);


        truck.load(car10);
        truck.load(car11);
        truck.load(car12);
        assertTrue(truck.getCarsLoaded().size() == 5);

    }

    @Test
    void unload() {
        load();

        for (int i = 0; i < 10; i++) {
            truck.unload();
        }

        assertTrue(truck.getCarsLoaded().size() == 0);
    }

    @Test
    void move() {
        load();
        for (int i = 0; i < 20; i++) {
            truck.gas(2);
        }

        for (int i = 0; i < 20; i++) {
            truck.move();
        }

        for (Vehicle car : truck.carsLoaded) {
            assertTrue(car.getCurrentLocation().x == truck.getCurrentLocation().x);
            assertTrue(car.getCurrentLocation().y == truck.getCurrentLocation().y);
        }

    }

    @Test
    void turnLeft() {
        load();

        truck.turnLeft();

        for (Vehicle car : truck.carsLoaded) {
            assertTrue(car.getOrientation() == truck.getOrientation());
        }
    }

}
 **/