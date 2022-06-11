package lsp.parcking;

import java.util.ArrayList;
import java.util.List;

public class Parking implements ParkingService {
    private final List<Car> cars;
    private int passengerCarParkingSize;
    private int truckParkingSize;


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
        boolean rsl = false;
        if (car.getSpace() > PassengerCar.SPACE && truckParkingSize > 0) {
            rsl = cars.add(car);
            truckParkingSize--;
        } else if (car.getSpace() > PassengerCar.SPACE && passengerCarParkingSize >= car.getSpace()) {
            rsl = cars.add(car);
            passengerCarParkingSize = passengerCarParkingSize - car.getSpace();
        } else if (car.getSpace() == PassengerCar.SPACE && passengerCarParkingSize > 0) {
            rsl = cars.add(car);
            passengerCarParkingSize--;
        }
        return rsl;
    }

    @Override
    public boolean parkOut(Car car) {
        boolean rsl = false;
        if (cars.contains(car) && car.getSpace() > PassengerCar.SPACE) {
            rsl = cars.remove(car);
            truckParkingSize++;
        } else if (cars.contains(car) && car.getSpace() == PassengerCar.SPACE) {
            rsl = cars.remove(car);
            passengerCarParkingSize++;
        }
        return rsl;
    }
}
