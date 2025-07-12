package visitor;

import shape.Circle;
import shape.Shape;
import shape.Square;
import shape.Triangle;


public interface Visitor {
    public void visit(Shape shape);
    public void visit(Circle circle);
    public void visit(Square square);
    public void visit(Triangle triangle);

}
