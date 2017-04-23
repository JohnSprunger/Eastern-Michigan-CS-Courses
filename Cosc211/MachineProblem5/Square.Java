/*****************************************************************
 The Square class simply sets up a square and calculates said
 square's area.

 @author John Sprunger
 @version 1.0
 @date 11/21/2016
 *****************************************************************/
public class Square implements Shape {

    private double height;

    private double width;

    public Square() {
        this.height = 1.0;
        this.width = 1.0;
    }

    public Square(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double calcArea() {
        return (height * width);
    }
}

