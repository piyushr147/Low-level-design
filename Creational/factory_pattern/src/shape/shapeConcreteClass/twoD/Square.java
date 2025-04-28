package shape.shapeConcreteClass.twoD;

import shape.TwoDShape;

public class Square extends TwoDShape {

    public int length;
    public String color;

    public Square(int length,String color) {
        this.length = length;
        this.color = color;
        System.out.println("HI iam square with color:"+this.color);
        System.out.println("square's area and perimeter: "+calculateArea()+", "+calculatePerimeter());

    }

    @Override
    public int calculateArea() {
        System.out.println("calculating square area");
        return length*length;
    }

    @Override
    public int calculatePerimeter() {
        System.out.println("calculating square perimeter");
        return 4*length;
    }
}
