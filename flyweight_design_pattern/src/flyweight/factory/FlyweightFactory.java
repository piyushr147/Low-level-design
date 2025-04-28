package flyweight.factory;

import flyweight.extrinsic.FlyweightAlphabet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlyweightFactory {
    Map<Integer, FlyweightAlphabet> alphabetMap = new HashMap<>();

    public FlyweightAlphabet getObject(Character character) {
        int index = character;
        if (!alphabetMap.containsKey(index)) {
            FlyweightAlphabet flyweightAlphabet = new FlyweightAlphabet(character);
            alphabetMap.put(index, flyweightAlphabet);
        }
        else
            System.out.println("FlyweightAlphabet already exists, space optimized");
        return alphabetMap.get(index);
    }
}
