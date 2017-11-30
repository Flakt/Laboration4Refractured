/**

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleWithTrailerTest {

    VehicleWithTrailer vehicle = new Scania();

    @Test
    void openTrailer() {
        assertFalse(vehicle.getTrailer().isOpen());

        vehicle.openTrailer();

        assertTrue(vehicle.getTrailer().isOpen());
    }

    @Test
    void move() {
        vehicle.openTrailer();
        vehicle.move();
        assertFalse(vehicle.getTrailer().isOpen());
    }



}

 **/