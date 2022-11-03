package CS2020.assignment1.game;
import java.util.Scanner;
import CS2020.assignment1.game.Game;

class Main{
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        Game currentGame = new Game(4,4,2);
        Boolean gameOver = false;




        //System.out.print("ENTER NEXT CO-ORDINATE : ");
        //String inputCoordinate = myObj.nextLine();
        while(!gameOver){
            System.out.print("ENTER NEXT CO-ORDINATE : ");
            String inputCoordinate = myObj.nextLine();
            currentGame.playRound(inputCoordinate);
            gameOver = currentGame.checkVictory();
            currentGame.opponentAutoMove();
            gameOver = currentGame.checkVictory();


        }


        // currentGame.playRound("1,0");
        // currentGame.playRound("1,1");
        // currentGame.playRound("1,2");
        // currentGame.playRound("1,3");

        // currentGame.playRound("2,0");
        // currentGame.playRound("2,1");
        // currentGame.playRound("2,2");0,0
        
        // currentGame.playRound("2,3");

        // currentGame.playRound("3,0"); 
        // currentGame.playRound("3,1");
        // currentGame.playRound("3,2");
        // currentGame.playRound("3,3");


        //currentGame.playRound(inputCoordinate);

    }
  } 