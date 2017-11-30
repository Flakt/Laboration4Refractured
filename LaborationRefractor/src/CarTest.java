/**
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Vehicle car = new Vehicle();



    @org.junit.jupiter.api.Test
    void gas() {
        double speed = car.getCurrentSpeed();

        car.gas(0);

        assertEquals(speed, car.getCurrentSpeed());

        car.gas(-20);
        assertEquals(speed, car.getCurrentSpeed());

        car.gas(40);
        assertTrue(car.getCurrentSpeed() > speed || car.getCurrentSpeed() == car.getEnginePower());

        speed = car.getCurrentSpeed();

        car.gas(1);
        assertTrue(car.getCurrentSpeed() > speed || car.getCurrentSpeed() == car.getEnginePower());

    }

    @org.junit.jupiter.api.Test
    void brake() {
        double speed = car.getCurrentSpeed();

        car.brake(0);
        assertEquals(speed, car.getCurrentSpeed());

        car.brake(-40);
        assertEquals(speed, car.getCurrentSpeed());

        car.brake(1);
        assertTrue(speed > car.getCurrentSpeed() || car.getCurrentSpeed() == 0);

        speed = car.getCurrentSpeed();
        car.brake(20);
        assertTrue(speed > car.getCurrentSpeed() || car.getCurrentSpeed() == 0);


    }

    @org.junit.jupiter.api.Test
    void move() {


        int x = car.getCurrentLocation().x;
        int y = car.getCurrentLocation().y;

        int count = 1;
        while (count < 1000) {
            car.gas(1);
            count++;
        }


        car.move();
        assertTrue(car.getCurrentLocation().x > x);
        assertEquals(y, car.getCurrentLocation().y);


        car.turnLeft();
        x = car.getCurrentLocation().x;
        y = car.getCurrentLocation().y;
        car.move();

        assertTrue(car.getCurrentLocation().y < y);
        assertEquals(x, car.getCurrentLocation().x);


        car.turnLeft();
        x = car.getCurrentLocation().x;
        y = car.getCurrentLocation().y;
        car.move();

        assertTrue(car.getCurrentLocation().x < x);
        assertEquals(y, car.getCurrentLocation().y);

        car.turnLeft();
        x = car.getCurrentLocation().x;
        y = car.getCurrentLocation().y;
        car.move();

        assertTrue(car.getCurrentLocation().y > y);
        assertEquals(x, car.getCurrentLocation().x);

    }


}
**/