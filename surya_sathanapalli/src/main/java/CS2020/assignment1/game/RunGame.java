//IMPORTS ALL THE NESSASARY JAVA
package CS2020.assignment1.game;

import java.util.Scanner;
import CS2020.assignment1.game.Game;

// THE Main METHOD BRINGS ALL THE METHODS TOGETHER AND MAKES THE GAME PLAYABLE
class Main {
    public static void main(String[] args) {

        // SCANNER IMPORTED TO ENSURE CAN TAKE INPUTS FROM PLAYER
        Scanner myObj = new Scanner(System.in);

        // CONFIGURES NEW GAME FOR PLAYER IN THIS EXAMPLE A 7X7 GRID WITH 2 SHIPS
        Game currentGame = new Game(7, 7, 2);

        // gameOver MADE TO KNOW WHEN TO SCAPE WHILE LOOP AFTER A WINNER IS DECLARED
        Boolean gameOver = false;

        // KEEP RUNNING AS LONG AS THERE IS NO WINNER
        while (!gameOver) {
            String inputCoordinate = null;

            try {
                // ASKS FOR CO-ORDINATE TO ALLOW PLAYER TO PLAY TURN
                System.out.print("ENTER NEXT CO-ORDINATE : ");

                // COLLECTS THE INPUT PROVIDED BY PLAYER
                inputCoordinate = myObj.nextLine().toLowerCase();
                if (!inputCoordinate.equals("exit")) {

                    String[] XY = inputCoordinate.split(",", 2);

                    // EACH INTEGER IS PROVIDED A VARIABLE SO THE VALUES CAN BE USED AS x,y
                    // CO-ORDINATES
                    int xCoordinate = Integer.parseInt(XY[0]);
                    int yCoordinate = Integer.parseInt(XY[1]);

                }else{
                    //EXITS THE GAME
                    currentGame.exitGame("exit");


                }

            } catch (Exception e) {
                System.out.println("PLEASE ENTER WITH FORMAT 'X,Y' ! ");
                continue;
            }

            // CHECKS ITS NOT EXIT BECAUSE IF EXIT IT WILL END THE GAME
            // EXIT IS NOT CASE SENSATIVE BECAUSE .toLowerCase() USED

            // PLAYES THE GAME WITH INPUT PROVIDED
            currentGame.playRound(inputCoordinate);
            // CHECKS IF PLAYERS MOVE MADE THEM WIN
            gameOver = currentGame.checkVictory();

            // RANDOMLY PLAYS OPPONENTS MOVE BY CALLING .opponentAutoMove()
            currentGame.opponentAutoMove();
            // CHECKS IF OPPONENTS MOVE MADE IT WIN
            gameOver = currentGame.checkVictory();

        }

    }
}