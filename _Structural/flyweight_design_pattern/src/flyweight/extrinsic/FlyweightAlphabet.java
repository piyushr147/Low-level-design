package flyweight.extrinsic;

import flyweight.SingleCharacter;

public class FlyweightAlphabet implements SingleCharacter {

    public Character character;

    public FlyweightAlphabet(Character character) {
        this.character = character;
    }

    @Override
    public void print() {
        System.out.println(character);
    }
}
