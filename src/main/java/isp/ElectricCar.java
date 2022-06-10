package isp;

public class ElectricCar implements Car {
    private String carName;

    @Override
    public void setName(String name) {
        carName = name;
    }

    @Override
    public void refuelGas(int liter) {
        throw new UnsupportedOperationException();
    }
}
