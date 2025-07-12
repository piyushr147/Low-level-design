package visitor.exporter;

import shape.Circle;
import shape.Shape;
import shape.Square;
import shape.Triangle;
import visitor.Visitor;

public class XmlExporterVisitor implements Visitor {
    @Override
    public void visit(Shape shape) {
        System.out.println("shape exporter");
    }

    @Override
    public void visit(Circle circle) {
        System.out.println("circle exporter");
    }

    @Override
    public void visit(Square square) {
        System.out.println("square exporter");
    }

    @Override
    public void visit(Triangle triangle) {
        System.out.println("triangle exporter");
    }
}
