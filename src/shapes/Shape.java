package shapes;

public abstract class Shape implements ShapeInterface {
    protected double side;
    protected double area;

    //method calculates sum of areas for each shape in array
    static void calculateSumArea(Shape[] shapesArray) {
        double sumArea = 0;
        for (Shape eachShape : shapesArray) {
            sumArea += eachShape.calculateArea();
        }
        System.out.printf("%.2f", sumArea);
    }
}
