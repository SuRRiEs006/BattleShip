package CS2020.assignment1.game;
import java.util.Scanner;
import CS2020.assignment1.game.Game;

class Main{
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        Game currentGame = new Game(4,4,1);

        System.out.print("ENTER NEXT CO-ORDINATE : ");
        String inputCoordinate = myObj.nextLine();
        currentGame.playRound(inputCoordinate);

    }
  } 