package CS2020.assignment1.game;
import CS2020.assignment1.game.AbstractBattleShip;
import java.util.Random;



class BattleShip extends AbstractBattleShip {

  public BattleShip(String name) {
    this.name = name;
    
    // decides ship orientation
    Random rand = new Random();

    if (rand.nextInt(2) == 0){
        this.shipOrientation = "horizontal";

    } else{
        this.shipOrientation = "vertical";

    }

    

  }












      	
	public  boolean checkAttack (int row,int column){

        return false;

    }
	
	public  String getName(){

        return null;

    }

	public  int getHits(){

        return 0;

    }
	
	public  String getShipOrientation(){

        return null;

    }
	
	public  void setHits(int numberOfHits){


    }
	
	public  int[][] getShipCoordinates(){

        return null;

    }
	
	public  void setShipCoordinates(int [][] coordinates){


    }


}