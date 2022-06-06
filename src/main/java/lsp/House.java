package lsp;

public class House {
    public int floor;
    private int citizen;

    public House(int floor, int citizen) {
        this.floor = floor;
        this.citizen = citizen;
    }

    public boolean houseCapacity(int floor, int citizen) {
        boolean rsl = false;
        if (citizen / floor <= 3) {
            rsl = true;
        }
        return rsl;
    }
}
