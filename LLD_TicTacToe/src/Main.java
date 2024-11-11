import player.Player;
import player.playerConcreteClass.CrossPlayer;
import playingBoard.PlayingBoard;

import java.util.Scanner;

import static constant.Constants.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        System.out.println();
        Scanner scanner = new Scanner(System.in);

        PlayingBoard playingBoard = new PlayingBoard(3,2);

        Player playerCross = new CrossPlayer(TYPE_CROSS,SYMBOL_CROSS);
        Player playerCircle = new CrossPlayer(TYPE_CIRCLE,SYMBOL_CIRCLE);

        playingBoard.addPlayer(playerCross);
        playingBoard.addPlayer(playerCircle);

        playingBoard.initializeGame();
    }
}