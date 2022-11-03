//IMPORTS ALL THE NESSASARY JAVA FILES
package CS2020.assignment1.game;
import java.util.Scanner;
import CS2020.assignment1.game.Game;

class Main{
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        Game currentGame = new Game(7,7,2);
        Boolean gameOver = false;


        while(!gameOver){
            System.out.print("ENTER NEXT CO-ORDINATE : ");
            String inputCoordinate = myObj.nextLine();
            if (inputCoordinate.toLowerCase().equals("exit")){
                currentGame.exitGame("exit");
            }
            currentGame.playRound(inputCoordinate);
            gameOver = currentGame.checkVictory();
            currentGame.opponentAutoMove();
            gameOver = currentGame.checkVictory();


        }

    }
  } 