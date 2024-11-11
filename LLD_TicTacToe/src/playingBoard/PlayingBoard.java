package playingBoard;

import player.Player;
import java.util.*;
import static constant.Constants.SYMBOL_CROSS;
import static java.lang.System.exit;

public class PlayingBoard {
    int size;
    char[][] board;
    private Player player;
    private Queue<Player> playerQueue = new LinkedList<>();

    public PlayingBoard(int size,int players){
        this.size = size;
        board = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '0';
            }
        }
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public void addPlayer(Player player){
        playerQueue.add(player);
    }

    public void initializeGame(){
        while(true){
            printBoard();
            Player player = playerQueue.remove();
            playerQueue.add(player);
            this.player = player;
            System.out.println("player with symbol " + player.symbol + ",play your move");
            makeMove();
            if(checkIfPlayerWins())
                exit(0);
        }
    }

    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void makeMove(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer for x-axis: ");
        int move_x = scanner.nextInt();
        System.out.print("Enter an integer for y-axis: ");
        int move_y = scanner.nextInt();

        if(!isValidMove(move_x,move_y)){
            System.out.println("The move is already made by another player, try again..");
            makeMove();
        }
        else{
            board[move_x][move_y] = player.symbol;
        }
    }

    public boolean isValidMove(int i,int j){
        if(board[i][j]=='0')
            return true;
        return false;
    }

    public boolean checkIfPlayerWins(){
        if(checkForColumn()||checkForRow()||checkForDiagonal()){
            System.out.println("Player Wins end of the game..");
            return true;
        }
        return false;
    }

    public boolean checkForRow(){
        for(int i=0;i<size;i++) {
            boolean player_wins = true;
            for (int j = 0; j < size; j++) {
                if (board[i][j] != player.symbol) {
                    player_wins = false;
                    break;
                }
            }
            if(player_wins)
                return true;
        }
        return false;
    }

    public boolean checkForColumn(){
        for(int i=0;i<size;i++) {
            boolean player_wins = true;
            for(int j=0;j<size;j++){
                if(board[j][i] != player.symbol) {
                    player_wins = false;
                    break;
                }
            }
            if(player_wins)
                return true;
        }
        return false;
    }

    public boolean checkForDiagonal(){
        boolean player_wins = true;
        for(int i=0;i<size;i++){
            if(board[i][i] != player.symbol) {
                player_wins = false;
                break;
            }
        }
        if(player_wins)
            return true;
        int i=size-1,j=0;
        while(i != -1){
            if(board[i][j] != player.symbol)
                return false;
            i--;
            j++;
        }
        return true;
    }
}
