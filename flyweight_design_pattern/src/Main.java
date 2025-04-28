import flyweight.builder.Builder;
import flyweight.factory.FlyweightFactory;
import flyweight.intrinsic.Alphabet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Builder builder = new Builder(new FlyweightFactory());
        Alphabet alphabet = builder.createAlphabet('A',0,0,"red");
        alphabet.print();
        alphabet = builder.createAlphabet('b',0,0,"blue");
        alphabet.print();
        alphabet = builder.createAlphabet('A',0,0,"green");
        alphabet.print();
    }
}