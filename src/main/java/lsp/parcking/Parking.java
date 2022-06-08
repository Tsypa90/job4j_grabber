package lsp.parcking;


import java.util.ArrayList;
import java.util.List;

public class Parking implements ParkingService {
    private final List<Car> cars;

    public Parking(int passengerCarParkingSize, int truckParkingSize) {
        if (truckParkingSize < 2 && passengerCarParkingSize == 0) {
            throw new IllegalStateException("Parking must have more parking space!");
        }
        this.cars = new ArrayList<>(passengerCarParkingSize + truckParkingSize);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    @Override
    public boolean parkIn(Car car) {
        return false;
    }

    @Override
    public boolean parkOut(Car car) {
        return false;
    }
}
