/*****************************************************************
 The Rectangle class simply sets up a cube and calculates said
 rectangle's area.

 @author John Sprunger
 @version 1.0
 @date 11/21/2016
 *****************************************************************/
public class Rectangle extends Square {

    public Rectangle(){
        setHeight(2.0);
        setWidth(2.0);
    }

    public Rectangle(double height, double width){
        setHeight(height);
        setWidth(width);
    }

    @Override
    public double calcArea() {
        return (getWidth() * (getHeight() * getWidth()));
    }
}

