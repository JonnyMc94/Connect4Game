package Connect4;


import java.util.Random;

// Class which holds the following methods - gamePlay, placeCounter, cpuDecision, gameCon
class GameSequence extends Main {

    protected int playerPos, cpuPos;

    // main game loop
    public void gamePlay(Player player1) {

        Board board1 = new Board();
        board = board1.createBoard();
        while (true) {
            System.out.println("Enter your column placement choice(1-5)");
            playerPos = sc.nextInt();
            // loop to ensure valid column choice from user input
            while (!validNumber) {

                switch (playerPos) {
                    case 1:
                        validNumber = true;
                        break;
                    case 2:
                        validNumber = true;
                        break;
                    case 3:
                        validNumber = true;
                        break;
                    case 4:
                        validNumber = true;
                        break;
                    case 5:
                        validNumber = true;
                        break;
                    default:
                        break;
                }
                if (!validNumber) {
                    System.out.println("Please enter a valid column placement choice (1-5) to continue!");
                    playerPos = sc.nextInt();
                    if (playerPos >= 1 && playerPos <= 5) {
                        validNumber = true;
                        break;
                    }
                } else {
                    break;
                }
            }

            playerPos = board1.validColumnNumber(playerPos);
            placeCounter(board, playerPos, "Player", player1);
            getWinner(player1.getPlayerCounter(), player1.getCpuCounter(), board);

            cpuPos = cpuDecision();
            cpuPos = board1.validColumnNumber(cpuPos);
            placeCounter(board, cpuPos, "CPU", player1);


            board1.printBoard(board);
            getWinner(player1.getPlayerCounter(), player1.getCpuCounter(), board);

            if (playerWinner) {
                gameMessage = "You have won!";
                System.out.println(gameMessage);
                break;
            } else if (cpuWinner) {
                gameMessage = "The CPU has won";
                System.out.println(gameMessage);
                break;
            }

            if (movesCompleted == 20 && playerWinner && cpuWinner) {
                gameMessage = "Tie game";
                System.out.println(Main.gameMessage);
                break;
            }

        }


    }

    // Adds the player/cpu's positional choice to the appropriate ArrayList
    // Then adds counter to the next free row in the chosen column
    public void placeCounter(char[][] board, int pos, String user, Player player1) {

        char counter = ' ';
        if (user.equals("Player")) {
            counter = player1.getPlayerCounter();
            playerPieces.add(pos);
        } else if (user.equals("CPU")) {
            counter = player1.getCpuCounter();
            cpuPieces.add(pos);
        }
        // Checks if bottom "game row" in that column is empty
        // If so, places the counter - if not it checks the row above.
        for (int i = 8; i >= 2; i -= 2) {
            if (board[i][pos] == ' ') {
                board[i][pos] = counter;
                break;
            }
        }

        movesCompleted++;
        validNumber = false;

    }

    // Method to generate a random CPU placement choice
    // Also checks if the value has been chosen already by checking both ArrayLists storing
    // the cpu's and player's moves
    public int cpuDecision() {
        Random rand = new Random();

        int cpuPos = rand.nextInt(5) + 1;
        if (cpuPieces.contains(cpuPos) || playerPieces.contains(cpuPos)) {
            cpuPos = rand.nextInt(5) + 1;
        }
        return cpuPos;
    }

    // Asks the user if they want to play again after the game is over
    public static void gameCon(String choice) {

        while (!(choice.equalsIgnoreCase("N") && choice.equalsIgnoreCase("Y"))) {

            if (choice.equalsIgnoreCase("N")) {
                isPlaying = false;
                System.out.println("I hope you enjoyed your game. Goodbye! ");
                break;
            } else if (choice.equalsIgnoreCase("Y")) {
                isPlaying = true;
                break;
            } else {
                System.out.println("Please choose a valid entry to progress (y/n)");
                choice = sc.next();
            }
        }

    }
}
