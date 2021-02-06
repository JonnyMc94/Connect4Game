package Connect4;
import Connect4.Board;
import java.util.*;

// Main class containing the game loop, getWinner and resetValues methods
public class Main {

    protected static char[][] board;

    protected static ArrayList<Integer> playerPieces = new ArrayList<>(), cpuPieces = new ArrayList<>();
    protected static Scanner sc;
    protected static String gameMessage;
    protected static int movesCompleted;
    protected static boolean playerWinner, cpuWinner, validNumber, isPlaying;

    public static void main(String args[]) {

        Player player1 = new Player();
        GameSequence game1 = new GameSequence();
        player1.colourDecision();

        // Do-while loop which runs the game and then prompts a response from the user
        // whether they want to continue or not upon winning/losing/drawing
        do {
            game1.gamePlay(player1);
            sc.nextLine();
            System.out.println("Would you like to play again? (y/n)");
            String choice = sc.nextLine();
            String finalChoice = choice.toUpperCase();
            game1.gameCon(finalChoice);
            resetValues();
        } while (isPlaying);
    }



    // Four linear search algorithms that run after every round of turns to determine whether or not there
    // has been a winner yet
    public void getWinner(char playerPiece, char cpuPiece, char[][] board) {
        // search algorithm to check for 4 across
        for (int i = 2; i < board.length; i++) {
            for (int j = 1; j < board[0].length - 6; j++) {
                if (board[i][j] == playerPiece &&
                        board[i][j + 2] == playerPiece &&
                        board[i][j + 4] == playerPiece &&
                        board[i][j + 6] == playerPiece) {
                    playerWinner = true;
                } else if (board[i][j] == cpuPiece &&
                        board[i][j + 2] == cpuPiece &&
                        board[i][j + 4] == cpuPiece &&
                        board[i][j + 6] == cpuPiece) {
                    cpuWinner = true;
                }
            }
        }
        // search algorithm to check for 4 down
        for (int i = 2; i < board.length - 6; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == playerPiece &&
                        board[i + 2][j] == playerPiece &&
                        board[i + 4][j] == playerPiece &&
                        board[i + 6][j] == playerPiece) {
                    playerWinner = true;
                } else if (board[i][j] == cpuPiece &&
                        board[i + 2][j] == cpuPiece &&
                        board[i + 4][j] == cpuPiece &&
                        board[i + 6][j] == cpuPiece) {
                    cpuWinner = true;
                }
            }
        }
        // search algorithm to check upward diagonal
        for (int i = 8; i < board.length - 6; i++) {
            for (int j = 1; j < board[0].length - 6; j++) {
                if (board[i][j] == playerPiece &&
                        board[i - 2][j + 2] == playerPiece &&
                        board[i - 4][j + 4] == playerPiece &&
                        board[i - 6][j + 6] == playerPiece) {
                    playerWinner = true;
                } else if (board[i][j] == cpuPiece &&
                        board[i - 2][j + 2] == cpuPiece &&
                        board[i - 4][j + 4] == cpuPiece &&
                        board[i - 6][j + 6] == cpuPiece) {
                    cpuWinner = true;
                }
            }
        }

        // search algorithm to check downward diagonal
        for (int i = 2; i < board.length - 6; i++) {
            for (int j = 1; j < board[0].length - 6; j++) {
                if (board[i][j] == playerPiece &&
                        board[i + 2][j + 2] == playerPiece &&
                        board[i + 4][j + 4] == playerPiece &&
                        board[i + 6][j + 6] == playerPiece) {
                    playerWinner = true;
                } else if (board[i][j] == cpuPiece &&
                        board[i + 2][j + 2] == cpuPiece &&
                        board[i + 4][j + 4] == cpuPiece &&
                        board[i + 6][j + 6] == cpuPiece) {
                    cpuWinner = true;
                }
            }
        }

    }

    // Resets values necessary for the game loop to execute correctly again after a game
    public static void resetValues() {

        gameMessage = " ";
        movesCompleted = 0;
        boolean flag = false;
        playerWinner = false;
        cpuWinner = false;
        validNumber = false;

    }


}

