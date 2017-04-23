/*****************************************************************
 The Circle class simply sets up a circle and calculates said
 circle's area.

 @author John Sprunger
 @version 1.0
 @date 11/21/2016
 *****************************************************************/
public class Circle implements Shape{

    private double radius;

    public Circle(){
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return (Math.PI * Math.pow(radius , 2));
    }
}

