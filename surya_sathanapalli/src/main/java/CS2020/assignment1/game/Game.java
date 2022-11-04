//IMPORTS ALL THE NESSASARY JAVA FILES
package CS2020.assignment1.game;

import java.util.Scanner;
import java.util.Random;
import CS2020.assignment1.game.GameControls;
import CS2020.assignment1.game.GameGrid;
import CS2020.assignment1.game.BattleShip;

//DEFINES GAME CLASS AND IMPLIMENTS GAME CONTROL
class Game implements GameControls {

    // INITIALIZES TWO VAIRABLES TO HOLD OBJECTS AND NUMBER OF SHIPS
    public PlayerGameGrid playerGrid;
    public OpponentGameGrid opponentGrid;
    public int numOfShips;

    // INITIALZES THE PLAYER AND OPPONENT OBJECTS BY PASSING PARAMETERS TO
    // "PlayerGameGrid" AND "OpponentGameGrid"
    public Game(int numOfRows, int numOfColumns, int numOfShips) {
        this.numOfShips = numOfShips;
        this.playerGrid = new PlayerGameGrid(numOfRows, numOfColumns, numOfShips);
        this.opponentGrid = new OpponentGameGrid(numOfRows, numOfColumns, numOfShips);
    }

    // METHOD ALLOWS FOR PLAYERS TO PLAY THIER TURN, CONVERTS INPUT TO x,y
    // COORDINATES ALSO CHECKS FOR IF VALID HIT HAS BEEN MADE AND OUPUTS THE
    // BATTLEFIELD GRID
    public void playRound(String input) {
        // DEFINES validAttack AS false, WILL REMAIN false TILL validAttack returns true
        Boolean validAttack = false;

        // SPLITS STRING INTO AN ARRAY WITH 2 ELEMENTS
        // BOTH ELEMENTS SHOULD BE INTEGERS
        String[] XY = input.split(",", 2);


        // EACH INTEGER IS PROVIDED A VARIABLE SO THE VALUES CAN BE USED AS x,y
        // CO-ORDINATES
        int xCoordinate = Integer.parseInt(XY[0]);
        int yCoordinate = Integer.parseInt(XY[1]);

        // TRAVERSES THROUGH ARRAY TO SEE OF A SHIP HAS BEEN HIT
        // CHECKS BY SENDING CO-ORDINATES TO validAttack
        for (int i = 0; i < numOfShips; i++) {
            validAttack = this.opponentGrid.ships[i].checkAttack(xCoordinate, yCoordinate);

            // IF A HIT IS successful THEN CHANGES OPPONENT GAME GRID INDEX TO "X"
            // ALSO NOTIFIES USER OF WHAT SHIP HAS BEEN HIT
            if (validAttack == true) {
                this.opponentGrid.gameGrid[xCoordinate][yCoordinate] = "X";
                System.out.println("HIT " + (this.opponentGrid.ships[i].name) + "!!!");

                // ELSE IF validAttack == false AND THE INDEX OF ARRAY ISNT ALREADY "X"
                // THEN IT COUNTS AS A MISS SO THE INDEX HAS TO CHANGE TO % AND MISS
                // NOTIFICATION
            } else if (this.opponentGrid.gameGrid[xCoordinate][yCoordinate] != "X") {
                this.opponentGrid.gameGrid[xCoordinate][yCoordinate] = "%";
                System.out.println("MISS!!!");
            }
        }
        // PRINTS GRID FOR THE END OF THE PLAYER'S TURN SO PLAYER CAN SEE HOW THEY
        // PERFORMED
        this.opponentGrid.printGrid();

    }

    // THE OPPONENT'S MOVE IS MADE THROUGH THIS METHOD.
    // RANDOM COORDINATES ALSO CHECKS FOR IF VALID HIT HAS BEEN MADE AND OUPUTS THE
    // BATTLEFIELD GRID
    public void opponentAutoMove() {

        // GENERATES AND ASSIGNS RANDOM x,y CO-ORDINATES FOR THE RANGE OF THE GAME GRID
        // TO VARIABLE
        // validAttack = false AS DEFAULT AND REMAINS UNLESS A HIT IS MADE TO SHIPS
        Random rand = new Random();
        Boolean validAttack = false;
        int xCoordinate = rand.nextInt(this.playerGrid.gameGrid.length);
        int yCoordinate = rand.nextInt(this.playerGrid.gameGrid[0].length);

        // CHECKS IF THE RANDOMLY GENERATED ATTACK CO-ORDINATES HAVE HIT ANYTHING
        // TRAVERSES THROUGH ALL THE ELEMENTS IN OPPONENT GAME GRID ARRAY
        for (int i = 0; i < numOfShips; i++) {

            // IF A VALID HIT IS MADE validAttack ATTACK WILL BE SET TO TRUE
            validAttack = this.playerGrid.ships[i].checkAttack(xCoordinate, yCoordinate);

            // IF VALID ATTACK IS SET TO TRUE THEN MUST UPDATE USER OF WHICH SHIP HIT AND
            // UPDATE GAME GRID INDEX TO "X"
            if (validAttack == true) {
                this.playerGrid.gameGrid[xCoordinate][yCoordinate] = "X";
                System.out.println("HIT " + (this.playerGrid.ships[i].name) + "!!!");

                // IF A ATTACK IS UNSUCCSESSFUL AND THE INDEX ISNT "X" THEN IT SAFE TO SAY IT
                // WAS A MISS AND THAT INDEX NEEDS TO BE UPDATED WITH "%" AND USER NOTIFIED OF
                // OPPONENT'S MISS
            } else if (this.playerGrid.gameGrid[xCoordinate][yCoordinate] != "X") {
                this.playerGrid.gameGrid[xCoordinate][yCoordinate] = "%";
                System.out.println("MISS!!!");

            }

        }
        // OUTPUTS THE PLAYER'S GRID SO THE PLAYER CAN SEE HOW THE OPPONENT PERFORMED
        this.playerGrid.printGrid();

    }

    // CHECKS TO SEE IF THERE IS WINNER SO THERE CAN BE AN END TO THE GAME WHEN ONE
    // SIDE HAS LOST ALL SHIPS
    public boolean checkVictory() {
        // DEFINES LOSS VARIABLES TO SEE WHO LOST LATER ON FOR THE MESSAGE TO BE PRINTED
        // PROPERLY IN CONSOLE WITH VARIABLE isThereWin TO BE RETURNED TO INDICATE A
        // WINNER
        boolean playerLoss = true;
        boolean opponentLoss = true;
        boolean isThereWin = false;

        // TRAVERSES THROUGH ALL THE SHIP'S INDEX SO CAN CHECK TO SEE IF THERE ARE LESS
        // THAN 2 HITS FOR BOTH PLAYERS IF THERE IS MORE THAN 2 THEN playerLoss /
        // opponentLoss IS SET TO false ACCORDINGLY
        for (int i = 0; i < numOfShips; i++) {
            if (playerGrid.ships[i].getHits() <= 2) {
                playerLoss = false;

            }
            if (opponentGrid.ships[i].getHits() <= 2) {
                opponentLoss = false;

            }

            // PRINTS OUT MESSAGE ACCORDINGLY AND SETS isThereWin TO true SO A true CAN BE
            // RETURNED
            if (playerLoss == true) {
                System.out.println("You have lost!");
                isThereWin = true;

            } else if (opponentLoss == true) {
                System.out.println("You have won!");
                isThereWin = true;

            }

        }

        // FINAL RETURN
        return isThereWin;

    }

    // EXIT METHOD IF USER IS DONE PLAYING
    public void exitGame(String input) {

        // CHECKS IF THERE IS AN EXIST REQUEST, IF THERE IS QUITS PROGRAM
        if (input.equals("exit")) {
            System.out.println("Exiting game?");
            System.out.println("Thank you for playing");
            System.exit(0);
        }
    }

    // JUST A SIMPLE GETTER METHOD
    public AbstractGameGrid getPlayersGrid() {
        return this.playerGrid;

    }

    // JUST A SIMPLE GETTER METHOD
    public AbstractGameGrid getOpponentssGrid() {
        return this.opponentGrid;
    }

}