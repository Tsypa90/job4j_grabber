package lsp.parcking;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingTest {
    @Ignore
    @Test
    public void parkIn() {
        Parking parking = new Parking(5);
        PassengerCar toyotaPrius = new PassengerCar();
        Truck volvo = new Truck(3);
        Truck mb = new Truck(3);
        parking.parkIn(toyotaPrius);
        parking.parkIn(mb);
        assertFalse(parking.parkIn(volvo));
    }
    @Ignore
    @Test
    public void parkOut() {
        Parking parking = new Parking(5);
        PassengerCar toyotaPrius = new PassengerCar();
        Truck mb = new Truck(3);
        parking.parkIn(toyotaPrius);
        parking.parkIn(mb);
        parking.parkOut(toyotaPrius);
        int expected = 3;
        assertThat(parking.getCars().size(), is(expected));
    }

    @Ignore
    @Test
    public void whenInAndNoSpaceThenOutAndIn() {
        Parking parking = new Parking(5);
        PassengerCar toyotaPrius = new PassengerCar();
        PassengerCar nissanCube = new PassengerCar();
        Truck mb = new Truck(3);
        Truck volvo = new Truck(2);
        parking.parkIn(toyotaPrius);
        parking.parkIn(nissanCube);
        parking.parkIn(mb);
        parking.parkIn(volvo);
        parking.parkOut(mb);
        assertTrue(parking.parkIn(volvo));
    }
}