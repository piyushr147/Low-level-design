import shape.Circle;
import shape.Shape;
import shape.Square;
import visitor.exporter.XmlExporterVisitor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        XmlExporterVisitor visitor = new XmlExporterVisitor();
        Shape circle = new Circle();
        Square square = new Square();
        visitor.visit(circle);
        visitor.visit(square);
    }
}