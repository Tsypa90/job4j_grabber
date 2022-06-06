package lsp;

public class BigHouse extends House {
    public BigHouse(int floor, int citizen) {
        super(floor, citizen);
    }

    public boolean houseCapacity(int floor, int citizen) {
        boolean rsl = false;
        if (citizen / floor <= 5) {
            rsl = true;
        }
        return rsl;
    }
}
