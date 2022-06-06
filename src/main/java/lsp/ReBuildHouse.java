package lsp;

public class ReBuildHouse extends House {
    public ReBuildHouse(int floor, int citizen) {
        super(floor, citizen);
    }

    public void houseCapacityReBuild(int floor, int citizen) {
        if (citizen / floor <= 3) {
            System.out.println("Don't need rebuild!");
        } else {
            super.floor++;
            System.out.println("House rebuild!");
        }
    }
}
