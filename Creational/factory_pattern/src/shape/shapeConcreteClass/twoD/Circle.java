package shape.shapeConcreteClass.twoD;

import shape.TwoDShape;

public class Circle extends TwoDShape {

    public int radius;
    public String color;

    public Circle(int radius,String color) {
        this.radius = radius;
        this.color = color;
        System.out.println("HI iam circle with color:"+this.color);
        System.out.println("circle's area and perimeter: "+calculateArea()+", "+calculatePerimeter());
    }

    @Override
    public int calculateArea() {
        System.out.println("calculating circle area");
        return radius*radius*3;
    }

    @Override
    public int calculatePerimeter() {
        System.out.println("calculating circle perimeter");
        return 2*radius*3;
    }
}
