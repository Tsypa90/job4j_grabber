package lsp.parcking;

public class Truck implements Car {
    public final int space;

    public Truck(int space) {
        this.space = space;
    }

    public int getSpace() {
        return space;
    }
}
