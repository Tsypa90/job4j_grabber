package lsp.parcking;

public class PassengerCar implements Car {
    public static final int SPACE = 1;
    private String parking = null;

    public int getSpace() {
        return SPACE;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }
}
