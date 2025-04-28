package factory;

import shape.Shape;
import shape.ThreeDShape;
import shape.TwoDShape;
import shape.shapeConcreteClass.threeD.Cube;
import shape.shapeConcreteClass.threeD.Sphere;
import shape.shapeConcreteClass.twoD.Circle;
import shape.shapeConcreteClass.twoD.Square;

import java.util.Objects;

public class BlueColorShape implements Factory{

    @Override
    public ThreeDShape get3dShape(String shape, int length) {
        if(Objects.equals(shape, "cube"))
            return new Cube(length,"blue");
        else
            return new Sphere(length,"blue");
    }

    @Override
    public TwoDShape get2dShape(String shape, int length) {
        if(Objects.equals(shape, "square"))
            return new Square(length,"blue");
        else
            return new Circle(length,"blue");
    }
}
