package lsp.parcking;


import java.util.ArrayList;
import java.util.List;

public class Parking implements ParkingService {
    private final List<Car> cars;
    private final int passengerCarParkingSize;
    private final int truckParkingSize;


    public Parking(int passengerCarParkingSize, int truckParkingSize) {
        this.truckParkingSize = truckParkingSize;
        this.passengerCarParkingSize = passengerCarParkingSize;
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
