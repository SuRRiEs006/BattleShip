package CS2020.assignment1.game;

import java.util.Scanner;
import CS2020.assignment1.game.GameControls;
import CS2020.assignment1.game.GameGrid;
import CS2020.assignment1.game.BattleShip;

class Game implements GameControls {

    public PlayerGameGrid playerGrid;
    public OpponentGameGrid opponentGrid;
    public int numOfShips;

    public Game(int numOfRows, int numOfColumns, int numOfShips) {
        this.numOfShips = numOfShips;

        this.playerGrid = new PlayerGameGrid(numOfRows, numOfColumns, numOfShips);

        this.opponentGrid = new OpponentGameGrid(numOfRows, numOfColumns, numOfShips);

    }

    public void playRound (String input){

        Boolean validAttack = false;
        //Scanner myObj = new Scanner(System.in);

        //System.out.print("ENTER NEXT CO-ORDINATE : ");
        //String inputCoordinate = myObj.nextLine();
        String[] XY = input.split(",", 2);

        int xCoordinate = Integer.parseInt(XY[0]);
        int yCoordinate = Integer.parseInt(XY[1]);

        ///////////////////////////
        for(int i=0; i<numOfShips;i++){
            validAttack = this.opponentGrid.ships[i].checkAttack(xCoordinate,yCoordinate);
            if (validAttack == true){
                this.opponentGrid.gameGrid[yCoordinate][xCoordinate] = "X";
                System.out.println("HIT "+(this.opponentGrid.ships[i].name)+"!!!");


            }else{
                this.opponentGrid.gameGrid[xCoordinate][yCoordinate] = "%";
                System.out.println("MISS!!!");

            }            




        }
        this.opponentGrid.printGrid();





    }

    public boolean checkVictory() {
        boolean playerLoss = true;
        boolean opponentLoss = true;
        boolean isThereWin = false;

        for (int i = 0; i < numOfShips; i++) {
            if (playerGrid.ships[i].getHits() <= 2) {
                playerLoss = false;

            }
            if (opponentGrid.ships[i].getHits() <= 2) {
                opponentLoss = false;

            }

            if (playerLoss == true) {
                System.out.println("You have lost!");
                isThereWin = true;

            } else if (opponentLoss == true) {
                System.out.println("You have won!");
                isThereWin = true;

            }

        }

        return isThereWin;

    }

    public void exitGame(String input) {

        if (input == "exit") {
            System.out.println("Exiting game – thank you for playing");
            System.exit(0);
        }
    }

    public AbstractGameGrid getPlayersGrid() {
        return this.playerGrid;

    }

    public AbstractGameGrid getOpponentssGrid() {
        return this.opponentGrid;
    }

}
