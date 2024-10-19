package factory;

import shape.Shape;
import shape.ThreeDShape;
import shape.TwoDShape;

public interface Factory {
    ThreeDShape get3dShape(String shape, int length);
    TwoDShape get2dShape(String shape, int length);
}
