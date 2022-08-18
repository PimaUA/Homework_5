package shapes;

public class Main {

    public static void main(String[] args) {

        Shape circle = new Circle(4);
        Shape triangle = new Triangle(6, 2);
        Shape square = new Square(7);

        Shape[] shapesArray = new Shape[]{circle, triangle, square};

        Shape.calculateSumArea(shapesArray);
    }
}
