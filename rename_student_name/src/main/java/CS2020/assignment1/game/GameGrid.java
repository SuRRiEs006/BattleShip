package CS2020.assignment1.game;
import CS2020.assignment1.game.AbstractGameGrid;


public class GameGrid extends AbstractGameGrid{


    public GameGrid(int width, int height, int numberOfShips){

        this.gameGrid = new String[width][height];
        initializeGrid();
        generateShips(numberOfShips);

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
	public void placeShip (AbstractBattleShip ship){}
	
	//this should generate ships for both player and the opponent 


	public void generateShips (int numberOfShips) {
        this.ships = new BattleShip [numberOfShips];
        
        for(int i=1; i<(numberOfShips+1); i++){
            
            this.ships[i-1]= new BattleShip("Ship "+i) ;
        }

        

    }


}