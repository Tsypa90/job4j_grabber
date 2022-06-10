package lsp.parcking;

public class Truck implements Car {
    public final int space;
    private String parking = null;

    public Truck(int space) {
        if (space <= 1) {
            throw new IllegalStateException("It is not truck!");
        }
        this.space = space;
    }

    public int getSpace() {
        return space;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }
}
