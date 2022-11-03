package CS2020.assignment1.game;
import CS2020.assignment1.game.AbstractGameGrid;
import java.util.Random;


public class GameGrid extends AbstractGameGrid{


    public GameGrid(int width, int height, int numberOfShips){

        this.gameGrid = new String[width][height];
        initializeGrid();
        generateShips(numberOfShips);

        for(int z=0; z<numberOfShips; z++){
            placeShip(this.ships[z]);
        }


    }

		
    //populate the grid with "." characters



	public void initializeGrid() {

        for(int i=0; i<(this.gameGrid.length); i++){
            for(int j=0; j<(this.gameGrid[0].length); j++){

                this.gameGrid[i][j] = ".";


            }



        }

    }
	
	//this should place the ship on the grid using "*" symbol
	public void placeShip (AbstractBattleShip ship){
        String shipOrientation = ship.shipOrientation;
        int[][] shipCoordinates = new int[3][2];
        if (shipOrientation.equals("vertical")) {
            Random rand = new Random();
            int randVertical = rand.nextInt(this.gameGrid.length - 2);
            int randHorizontal = rand.nextInt(this.gameGrid.length);

            for (int i = randVertical; i < randVertical + 3; i++) {
                int indexValue = i - randVertical;
                this.gameGrid[i][randHorizontal] = "*";

                shipCoordinates[indexValue][0] = i; // (x,y) format FIRST X
                shipCoordinates[indexValue][1] = randHorizontal; // NOW Y
                System.out.println(ship.name+": "+ship.shipOrientation+i+","+randHorizontal);

            }

        }else{
            Random rand = new Random();
            int randVertical = rand.nextInt(this.gameGrid.length);
            int randHorizontal = rand.nextInt(this.gameGrid.length - 2);

            for (int i = randHorizontal; i < randHorizontal + 3; i++) {

                int indexValue = i - randHorizontal;
                this.gameGrid[randVertical][i] = "*";

                shipCoordinates[indexValue][0] = randVertical; // (x,y) format FIRST X
                shipCoordinates[indexValue][1] = i; // NOW Y
                System.out.println(ship.name+": "+ship.shipOrientation+i+","+randHorizontal);
            }
            

        }

        ship.setShipCoordinates(shipCoordinates);

    }
	
	//this should generate ships for both player and the opponent 


	public void generateShips (int numberOfShips) {
        this.ships = new BattleShip [numberOfShips];
        
        for(int i=1; i<(numberOfShips+1); i++){
            
            this.ships[i-1]= new BattleShip("Ship "+i) ;
        }

        

    }


}