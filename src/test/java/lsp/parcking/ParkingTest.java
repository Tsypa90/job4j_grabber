package lsp.parcking;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingTest {
    @Test
    public void parkPassengerCarInTrue() {
        Parking parking = new Parking(2, 3);
        PassengerCar toyotaPrius = new PassengerCar();
        assertTrue(parking.parkIn(toyotaPrius));
    }
    @Test
    public void parkPassengerCarInFalse() {
        Parking parking = new Parking(0, 3);
        PassengerCar toyotaPrius = new PassengerCar();
        assertFalse(parking.parkIn(toyotaPrius));
    }
    @Test
    public void parkTruckInTrue() {
        Parking parking = new Parking(1, 1);
        Car volvoTruck = new Truck(3);
        assertTrue(parking.parkIn(volvoTruck));
    }
    @Test
    public void parkTruckInFalse() {
        Parking parking = new Parking(1, 0);
        Car volvoTruck = new Truck(3);
        assertFalse(parking.parkIn(volvoTruck));
    }
    @Test
    public void parkTruckInFalseWhenTruckParkingFullAndNoSpaceOnPassenger() {
        Parking parking = new Parking(1, 1);
        Car volvoTruck = new Truck(3);
        Car mb = new Truck(2);
        parking.parkIn(mb);
        assertFalse(parking.parkIn(volvoTruck));
    }
    @Test
    public void parkOutTrue() {
        Parking parking = new Parking(1, 2);
        PassengerCar toyotaPrius = new PassengerCar();
        parking.parkIn(toyotaPrius);
        assertTrue(parking.parkOut(toyotaPrius));
    }
    @Test
    public void parkOutFalse() {
        Parking parking = new Parking(1, 2);
        PassengerCar toyotaPrius = new PassengerCar();
        parking.parkIn(toyotaPrius);
        parking.parkOut(toyotaPrius);
        assertFalse(parking.parkOut(toyotaPrius));
    }
    @Test
    public void whenCarNotParkInAndTryParkOutThenFalse() {
        Parking parking = new Parking(1, 2);
        PassengerCar toyotaPrius = new PassengerCar();
        assertFalse(parking.parkOut(toyotaPrius));
    }
    @Test
    public void identifyCarList() {
        Parking parking = new Parking(1, 2);
        PassengerCar toyotaPrius = new PassengerCar();
        Car mb = new Truck(2);
        parking.parkIn(toyotaPrius);
        parking.parkIn(mb);
        assertThat(parking.getCars(), is(List.of(toyotaPrius, mb)));
    }
}