package shapes;

public class Circle extends Shape implements ShapeInterface {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Fields must be >=0");
        }
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        area = PI * Math.pow(radius, 2);
        return area;
    }
}
