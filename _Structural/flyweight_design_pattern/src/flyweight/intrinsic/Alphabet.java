package flyweight.intrinsic;

import flyweight.SingleCharacter;
import flyweight.extrinsic.FlyweightAlphabet;

public class Alphabet implements SingleCharacter {

    public int pos_x;
    public int pos_y;
    public String color;
    public FlyweightAlphabet flyweightAlphabet;

    public Alphabet(FlyweightAlphabet flyweightAlphabet, int pos_x, int pos_y, String color) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.color = color;
        this.flyweightAlphabet = flyweightAlphabet;
    }

    @Override
    public void print() {
        flyweightAlphabet.print();
    }
}
