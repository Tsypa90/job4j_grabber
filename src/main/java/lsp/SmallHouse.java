package lsp;

public class SmallHouse extends House {
    public SmallHouse(int floor, int citizen) {
        super(floor, citizen);
    }

    public boolean houseCapacity(int floor, int citizen) {
        boolean rsl = false;
        if (citizen / floor <= 2) {
            rsl = true;
        }
        return rsl;
    }
}
