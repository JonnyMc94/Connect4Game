package Connect4;

// Player class which has the colourDecision and colourChoice methods
// as well as getters/setters for player/cpu counter colour

 public class Player extends Main {

    protected boolean validColour;
    private char playerCounter, cpuCounter;


    // A method which requests and validates users colour choice (Y/R) using a switch statement
    public void colourDecision() {

        System.out.println("Choose the color of your counter, 'Y' for Yellow or 'R' for Red");
        String playerColour = sc.next();
        char colour = playerColour.toUpperCase().charAt(0);


        // loop to ensure valid number choice from user input
        while (!validColour) {

            switch (colour) {
                case 'Y':
                    validColour = true;
                    break;
                case 'R':
                    validColour = true;
                    break;
                default:
                    break;
            }
            if (!validColour) {
                System.out.println("Please choose a valid colour to progress");
                playerColour = sc.next();
                colour = playerColour.toUpperCase().charAt(0);
            } else {
                break;
            }
        }

        colourChoice(colour);
    }

    // Assigns the colour choice to the char variables playerCounter and cpuCounter
    public void colourChoice(char colour) {
        if (colour == 'R') {
            setPlayerCounter('R');
            setCpuCounter('Y');
        } else {
            setPlayerCounter('Y');
            setCpuCounter('R');
        }

    }

    // Accessor and mutator methods for Player and CPU counters

    public char getPlayerCounter() {
        return playerCounter;
    }

    public void setPlayerCounter(char playerCounter) {
        this.playerCounter = playerCounter;
    }

    public char getCpuCounter() {
        return cpuCounter;
    }

    public void setCpuCounter(char cpuCounter) {
        this.cpuCounter = cpuCounter;
    }
}
