package flyweight.builder;

import flyweight.extrinsic.FlyweightAlphabet;
import flyweight.factory.FlyweightFactory;
import flyweight.intrinsic.Alphabet;

public class Builder {

    FlyweightFactory flyweightFactory;

    public Builder(FlyweightFactory flyweightFactory){
        this.flyweightFactory = flyweightFactory;
    }

    public Alphabet createAlphabet(Character character, int pos_x, int pos_y, String color){
        FlyweightAlphabet flyweightAlphabet = flyweightFactory.getObject(character);
        return new Alphabet(flyweightAlphabet, pos_x, pos_y, color);
    }
}
