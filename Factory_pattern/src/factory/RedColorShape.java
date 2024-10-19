package factory;

import shape.Shape;
import shape.ThreeDShape;
import shape.TwoDShape;
import shape.shapeConcreteClass.threeD.Cube;
import shape.shapeConcreteClass.threeD.Sphere;
import shape.shapeConcreteClass.twoD.Circle;
import shape.shapeConcreteClass.twoD.Square;

public class RedColorShape implements Factory{

    @Override
    public ThreeDShape get3dShape(String shape, int length) {
        if(shape=="cube")
            return new Cube(length,"red");
        else
            return new Sphere(length,"red");
    }

    @Override
    public TwoDShape get2dShape(String shape, int length) {
        if(shape=="square")
            return new Square(length,"red");
        else
            return new Circle(length,"red");
    }
}
