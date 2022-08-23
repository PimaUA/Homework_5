package shapes;

public class Triangle implements Computational {
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new IllegalArgumentException("Fields must be >=0");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    //method for calculation of half perimeter of triangle
    public double calculateHalfPerimeter() {
        return (sideA + sideB + sideC) / 2.0;
    }

    @Override
    public double calculateArea() {
        return Math.sqrt(calculateHalfPerimeter() * (calculateHalfPerimeter() - sideA)
                * (calculateHalfPerimeter() - sideB) * (calculateHalfPerimeter() - sideC));
    }
}
