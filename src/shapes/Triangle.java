package shapes;

public class Triangle extends Shape implements ShapeInterface {
    private double height;

    public Triangle(double side, double height) {
        if (side <= 0 || height <= 0) {
            throw new IllegalArgumentException("Fields must be >=0");
        }
        super.side = side;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        area = 0.5 * side * height;
        return area;
    }
}
