package player;

import java.security.KeyPair;
import java.util.ArrayList;

public class Player {
    public int type;
    public char symbol;
    private ArrayList<Integer> pair = new ArrayList<>(2);

    public Player(int type,char symbol){
        this.type = type;
        this.symbol = symbol;
    }

    public void setLatestMove(int i,int j){
        pair.add(0,i);
        pair.add(1,j);
    }

    public ArrayList<Integer> getLatestMove(){
        return pair;
    }
}
