package lsp.parcking;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingTest {
    @Ignore
    @Test
    public void parkInTrue() {
        Parking parking = new Parking(2, 3);
        PassengerCar toyotaPrius = new PassengerCar();
        assertTrue(parking.parkIn(toyotaPrius));
    }
    @Ignore
    @Test
    public void parkInFalse() {
        Parking parking = new Parking(1, 2);
        Car volvoTruck = new Truck(3);
        assertFalse(parking.parkIn(volvoTruck));
    }
    @Ignore
    @Test
    public void parkOutTrue() {
        Parking parking = new Parking(1, 2);
        PassengerCar toyotaPrius = new PassengerCar();
        parking.parkIn(toyotaPrius);
        assertTrue(parking.parkOut(toyotaPrius));
    }
    @Ignore
    @Test
    public void parkOutFalse() {
        Parking parking = new Parking(1, 2);
        PassengerCar toyotaPrius = new PassengerCar();
        parking.parkIn(toyotaPrius);
        parking.parkOut(toyotaPrius);
        assertFalse(parking.parkOut(toyotaPrius));
    }
    @Ignore
    @Test
    public void whenNoSpaceToPark() {
        Parking parking = new Parking(1, 2);
        PassengerCar toyotaPrius = new PassengerCar();
        PassengerCar nissanCube = new PassengerCar();
        parking.parkIn(toyotaPrius);
        assertFalse(parking.parkIn(nissanCube));
    }
}