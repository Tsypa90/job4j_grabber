package lsp.parcking;

import java.util.ArrayList;
import java.util.List;

public class Parking implements ParkingService {
    private final int parkingSize;
    private final List<Car> cars = new ArrayList<>();

    public Parking(int parkingSize) {
        this.parkingSize = parkingSize;
    }

    @Override
    public boolean parkIn(Car car) {
        return false;
    }

    @Override
    public boolean parkOut(Car car) {
        return false;
    }

    public List<Car> getCars() {
        return cars;
    }
}
