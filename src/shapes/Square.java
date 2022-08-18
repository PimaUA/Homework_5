package shapes;

public class Square extends Shape implements ShapeInterface {
    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Fields must be >=0");
        }
        super.side = side;
    }

    @Override
    public double calculateArea() {
        area = Math.pow(side, 2);
        return area;
    }
}
