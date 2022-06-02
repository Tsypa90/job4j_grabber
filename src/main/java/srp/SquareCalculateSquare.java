package srp;

public class SquareCalculateSquare implements CalculateSquare {
    @Override
    public int calculateSquare(int side) {
        return (int) Math.sqrt(side);
    }

    @Override
    public int calculatePerimeter(int sideA, int sideB) {
        return 2 * (sideA + sideB);
    }
}
