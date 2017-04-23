/*****************************************************************
 The Cube class simply sets up a cube and calculates said
 cube's area.

 @author John Sprunger
 @version 1.0
 @date 11/21/2016
 *****************************************************************/
public class Cube extends Square implements Shape{

    private double length;

    public Cube() {
        this.length = 1.0;
    }

    public Cube(double length, double height, double width) {
        this.length = length;
        setWidth(width);
        setHeight(height);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double calcArea() {
        return (getHeight() * getWidth() * this.length);
    }
}

