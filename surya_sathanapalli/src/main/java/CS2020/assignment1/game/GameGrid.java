//IMPORTS ALL THE NESSASARY JAVA FILES
package CS2020.assignment1.game;

import CS2020.assignment1.game.AbstractGameGrid;
import java.util.Random;

//BattleShip CLASS EXTENDS AbstractBattleShip
public class GameGrid extends AbstractGameGrid {

    // INITALIZE METHOD ENSURES GAME GRID IS MADE AND SHIPS ARE PLACED ON THE GRID
    public GameGrid(int width, int height, int numberOfShips) {

        // GAME GRID IS MADE AND POPULATED WITH "." USING initializeGrid method
        this.gameGrid = new String[width][height];
        initializeGrid();

        // SHIPS ARE GENERATED AND CAN THEN BE PLACED ON THE BOARD
        generateShips(numberOfShips);

        // ALL SHIP CO-ORDINATES MUST BE PLACED ON GRID
        for (int z = 0; z < numberOfShips; z++) {
            placeShip(this.ships[z]);
        }

    }

    // POPULATES GRID WITH "."
    public void initializeGrid() {

        // USED NESTED FOR LOOP BECAUSE WE ARE TRYING TO ACCESS EACH ELEMENT OF A 2D
        // ARRAY THEREFORE A FOR LOOP PER DIMENSION
        for (int i = 0; i < (this.gameGrid.length); i++) {
            for (int j = 0; j < (this.gameGrid[0].length); j++) {

                // ALL ELEMENTS ARE POPULATED WITH "."
                this.gameGrid[i][j] = ".";

            }

        }

    }

    // PLACES SHIP IN A RANDOM LOCATION FOR SHIP PARAMETER PASSED
    public void placeShip(AbstractBattleShip ship) {

        // SHIP ORIENTATION IS FETCHED AS IT IS IMPORTANT TO ENSURE THE SHIP DOES
        // "overflow"
        String shipOrientation = ship.shipOrientation;
        int desiredShipLength = 3;

        // shipCoordinates VARIABLE INITIALIZED SO THE 3 POINTS OF SHIP CAN BE STORED
        int[][] shipCoordinates = new int[desiredShipLength][2];

        // IF VERTICAL POSITIONING THEN A RANDOM HORIZONTAL POINT IS PICKED AS THE WHOLE
        // WIDTH CAN BE USED NO PROBLEM. THEN A RANDOM VERTICAL INDEX BETWEEN
        // 0-(GRID LENGTH-2) IS CHOSEN AS WE NEED TO ACOUNT FOR THE SPACE THE VERTICAL
        // SHIP WILL OCCUPY
        if (shipOrientation.equals("vertical")) {

            // BELOW IS THE RANDOM INT BEING PICKED FROM DESCRIPTION ABOVE
            Random rand = new Random();
            int randVertical = rand.nextInt(this.gameGrid.length - 2);
            int randHorizontal = rand.nextInt(this.gameGrid.length);

            // ADDS THE 3 POINTS ONWARD FROM THE POINT SELECTED FROM THE RANDOM VERTICAL
            // THE FOR LOOP INCREMENTS BY 1, WITH 3 REPETITIONS TO ALLOCATE THE SHIP SPACE
            for (int i = randVertical; i < randVertical + desiredShipLength; i++) {

                // TO CORRECT FOR OVERFLOW
                int indexValue = i - randVertical;

                // OVER WRITES THE "." IN POSITION TO "*" TO SHOW A SHIP
                this.gameGrid[i][randHorizontal] = "*";

                // SHIPS CO-ORDINATES ARE STORED SO THEY CAN BE STORED FOR FUTURE USE OF
                // E.G IDENTIFYING IF SHIPS GOT HIT
                shipCoordinates[indexValue][0] = i; // (x,y) format FIRST X
                shipCoordinates[indexValue][1] = randHorizontal; // NOW Y

                // THE BELOW IS JUST FOR DEBUGGING, UNCOMMENT AND RUN FOR SHIP CO-ORDINATES TO
                // BE PRTINTED IN TERMINAL
                // System.out.println(ship.name+": "+ship.shipOrientation+"
                // "+i+","+randHorizontal);

            }

        } else {
            // IF HORIZONTAL POSITIONING THEN A RANDOM VERTICAL POINT IS PICKED AS THE WHOLE
            // WIDTH CAN BE USED NO PROBLEM. THEN A RANDOM HORIZONAL INDEX BETWEEN
            // 0-(GRID LENGTH-2) IS CHOSEN AS WE NEED TO ACOUNT FOR THE SPACE THE VERTICAL
            // SHIP WILL OCCUPY
            Random rand = new Random();

            // BELOW IS THE RANDOM INT BEING PICKED FROM DESCRIPTION ABOVE
            int randVertical = rand.nextInt(this.gameGrid.length);
            int randHorizontal = rand.nextInt(this.gameGrid.length - 2);

            // ADDS THE desiredShipLength POINTS ONWARD FROM THE POINT SELECTED FROM THE RANDOM HORIZONTAL
            // THE FOR LOOP INCREMENTS BY 1, WITH desiredShipLength REPETITIONS TO ALLOCATE THE SHIP SPACE
            for (int i = randHorizontal; i < randHorizontal + desiredShipLength; i++) {

                // TO CORRECT FOR OVERFLOW
                int indexValue = i - randHorizontal;

                // OVER WRITES THE "." IN POSITION TO "*" TO SHOW A SHIP
                this.gameGrid[randVertical][i] = "*";

                // SHIPS CO-ORDINATES ARE STORED SO THEY CAN BE STORED FOR FUTURE USE OF
                // E.G IDENTIFYING IF SHIPS GOT HIT
                shipCoordinates[indexValue][0] = randVertical; // (x,y) format FIRST X
                shipCoordinates[indexValue][1] = i; // NOW Y

                // THE BELOW IS JUST FOR DEBUGGING, UNCOMMENT AND RUN FOR SHIP CO-ORDINATES TO
                // BE PRTINTED IN TERMINAL
                // System.out.println(ship.name+": "+ship.shipOrientation+i+","+randHorizontal);
            }

        }
        // SETS ALL THE CO-ORDINATES COLLECTED FOR HORIZONTAL AND VERTICAL SHIPS USING
        // THE SHIP'S SETTER METHOD
        ship.setShipCoordinates(shipCoordinates);

    }

    // THIS SHOULD GENERATE SHIPS FOR BOTH PLAYER AND THE OPPONENT AMOUNT BASED ON
    // PARAMETER
    public void generateShips(int numberOfShips) {

        // INITIALIZES VARIABLE FOR NUMBER OF SHIPS TO BE MADE
        this.ships = new BattleShip[numberOfShips];

        // FOR LOOP TO ENSURE THAT ALL THE SHIPS ARE NAMED
        // WE START i from 1 AS WE DONT WANT TO NAME A SHIP "Ship 0"
        for (int i = 1; i < (numberOfShips + 1); i++) {

            // AS ALL INDEXES ARE INCREASED BY 1 MUST DECREASE BY 1 TO ADD FROM THE 0 INDEX
            this.ships[i-1] = new BattleShip("Ship " + i);
        }

    }

}