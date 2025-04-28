import factory.Factory;
import factory.RedColorShape;
import shape.ThreeDShape;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Factory factory = new RedColorShape();
        ThreeDShape threeDShape = factory.get3dShape("cube",5);
    }
}