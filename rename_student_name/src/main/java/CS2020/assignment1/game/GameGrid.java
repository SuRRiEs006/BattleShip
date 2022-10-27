package CS2020.assignment1.game;

import java.util.Random;

import CS2020.assignment1.game.AbstractGameGrid;

public class GameGrid extends AbstractGameGrid {

    public GameGrid(int width, int height, int numberOfShips) {

        this.gameGrid = new String[height][width];
        initializeGrid();
        generateShips(numberOfShips);

        for (int y = 0; y < this.ships.length; y++) {
            placeShip(this.ships[y]);
        }
    }

    // populate the grid with "." characters

    public void initializeGrid() {

        for (int i = 0; i < (this.gameGrid.length); i++) {
            for (int j = 0; j < (this.gameGrid[0].length); j++) {

                this.gameGrid[i][j] = ".";

            }

        }

    }

    // this should place the ship on the grid using "*" symbol
    public void placeShip (AbstractBattleShip ship){
        Random rand = new Random();
        
        String shipOrientation = ship.getShipOrientation();
        if (shipOrientation == "vertical"){
            int[] randomShipXY = new int[2];
            randomShipXY[0] = rand.nextInt(this.gameGrid.length-2);
            randomShipXY[1] = rand.nextInt(this.gameGrid[0].length);
            
            for (int i = randomShipXY[0]; i < (randomShipXY[0] + 3); i++) {
                
                this.gameGrid[i][randomShipXY[1]] = "*";
    
            }

        }else{
            int[] randomShipXY = new int[2];
            randomShipXY[0] = rand.nextInt(this.gameGrid.length);
            randomShipXY[1] = rand.nextInt(this.gameGrid[0].length-2);
      
            for (int i = randomShipXY[1]; i < (randomShipXY[1] + 3); i++) {
                this.gameGrid[randomShipXY[0]][i] = "*";

        }}
           
            








        }

    // this should generate ships for both player and the opponent

    public void generateShips(int numberOfShips) {
        this.ships = new BattleShip[numberOfShips];

        for (int i = 1; i < (numberOfShips + 1); i++) {

            this.ships[i - 1] = new BattleShip("Ship " + i);
        }

    }

}