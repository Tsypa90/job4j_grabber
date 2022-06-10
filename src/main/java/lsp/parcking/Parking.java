package lsp.parcking;


import java.util.ArrayList;
import java.util.List;

public class Parking implements ParkingService {
    private final List<Car> cars;
    private int passengerCarParkingSize;
    private int truckParkingSize;
    private final String truckParking = "truckParking";
    private final String passengerParking = "passengerCarParking";


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
        if (car.getSpace() > 1) {
            if (truckParkingSize > 0) {
                rsl = cars.add(car);
                car.setParking(truckParking);
                truckParkingSize--;
            } else if (passengerCarParkingSize >= car.getSpace()) {
                 rsl = cars.add(car);
                 car.setParking(passengerParking);
                passengerCarParkingSize = passengerCarParkingSize - car.getSpace();
            }
        } else {
            if (passengerCarParkingSize > 0) {
                 rsl = cars.add(car);
                 car.setParking(passengerParking);
                passengerCarParkingSize--;
            }
        }
        return rsl;
    }

    @Override
    public boolean parkOut(Car car) {
        boolean rsl = false;
        if (cars.contains(car)) {
            if (car.getSpace() > 1) {
                if (car.getParking().equals(truckParking)) {
                    rsl = cars.remove(car);
                    truckParkingSize++;
                } else {
                    rsl = cars.remove(car);
                    passengerCarParkingSize = passengerCarParkingSize + car.getSpace();
                }
            } else {
                rsl = cars.remove(car);
                passengerCarParkingSize++;
            }
        }
        return rsl;
    }

    public int getPassengerCarParkingSize() {
        return passengerCarParkingSize;
    }

    public int getTruckParkingSize() {
        return truckParkingSize;
    }
}
