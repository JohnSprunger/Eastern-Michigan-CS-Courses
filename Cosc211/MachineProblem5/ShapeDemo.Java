import java.util.ArrayList;

/*****************************************************************
 The ShapeDemo class holds the  main functionality of the program
 it handles setting up the shapes, adding them to an ArrayList
 then, showing the area of the given shape.

 @author John Sprunger
 @version 1.0
 @date 11/21/2016
 *****************************************************************/
public class ShapeDemo {

    public static void main(String[] args) {
        //List of shapes
        ArrayList<Shape> shapesList = new ArrayList<>();

        Shape circle1 = new Circle();
        Shape circle2 = new Circle(2.0);
        Shape square1 = new Square();
        Shape square2 = new Square(4.5,2.0);
        Shape cube1 = new Cube();
        Shape cube2 = new Cube(5.0, 2.0, 3.56);
        Shape rect1 = new Rectangle();
        Shape rect2 = new Rectangle(5.0,5.0);

        shapesList.add(circle1);
        shapesList.add(circle2);
        shapesList.add(square1);
        shapesList.add(square2);
        shapesList.add(cube1);
        shapesList.add(cube2);
        shapesList.add(rect1);
        shapesList.add(rect2);

        for (Shape s : shapesList) {
            displayArea(s);
        }

    }

    public static void displayArea(Shape s){
        System.out.println("The area of the " + s.getClass() + " is "  + s.calcArea());
    }
}

