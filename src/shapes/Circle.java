package shapes;

public class Circle implements Computational {
    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Fields must be >=0");
        }
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.pow(radius, 2)*PI;
    }
}
