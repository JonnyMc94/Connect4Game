package Connect4;

// Board class containing the methods createBoard, printBoard and validColumnNumber
class Board extends Main {

    // Method creating the game board by populating a 2D char array
    public char[][] createBoard() {

        char[][] board = {{'|', '1', '-', '2', '-', '3', '-', '4', '-', '5', '|'},
                {'|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'},
                {'|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|'},
                {'|', '-', '+', '-', '+', '-', '+', '-', '+', '-', '|'},
                {'|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|'},
                {'|', '-', '+', '-', '+', '-', '+', '-', '+', '-', '|'},
                {'|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|'},
                {'|', '-', '+', '-', '+', '-', '+', '-', '+', '-', '|'},
                {'|', ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ', '|'},
                {'|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|'}};

        return board;
    }

    // Nested forEach loops printing the board
    public void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    // Converts the users column placement choice to an appropriate slot in the
    // 2D board array so that it will appear correctly in the console
    public int validColumnNumber(int pos) {

        switch (pos) {
            case 1:
                pos = 1;
                break;
            case 2:
                pos = 3;
                break;
            case 3:
                pos = 5;
                break;
            case 4:
                pos = 7;
                break;
            case 5:
                pos = 9;
                break;
            default:
                break;

        }

        return pos;
    }
}
