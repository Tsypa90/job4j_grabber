package srp;

public class PrintRectangleSquare implements PrintSquare {
    @Override
    public void print(int square) {
        System.out.println(square);
    }

    private int calculateSquare(int sideA, int sideB) {
        return sideA * sideB;
    }
}
