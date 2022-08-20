package shapes;

public class Triangle implements Computational {
    private final double height;
    private final double side;

    public Triangle(double side, double height) {
        if (side <= 0 || height <= 0) {
            throw new IllegalArgumentException("Fields must be >=0");
        }
        this.side = side;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * side * height;
    }
}
