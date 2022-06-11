package lsp.parcking;

public class Truck implements Car {
    public final int space;

    public Truck(int space) {
        if (space <= PassengerCar.SPACE) {
            throw new IllegalStateException("It is not truck!");
        }
        this.space = space;
    }

    public int getSpace() {
        return space;
    }
}
