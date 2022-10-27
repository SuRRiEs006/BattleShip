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
        boolean hitOrMiss = false;
        if (((row == this.shipCoordinates[0][0]) && (column == this.shipCoordinates[0][1])) && (this.hits < 3)){
  
            this.hits = this.hits + 1;
            hitOrMiss = true;


        }
        return hitOrMiss;

    }
	
	public  String getName(){

        return this.name;

    }

	public  int getHits(){

        return this.hits;

    }
	
	public  String getShipOrientation(){

        return this.shipOrientation;

    }
	
	public void setHits(int numberOfHits){

        this.hits = numberOfHits;


    }
	
	public int[][] getShipCoordinates(){

        return this.shipCoordinates;

    }
	
	public  void setShipCoordinates(int [][] coordinates){

        this.shipCoordinates = coordinates;


    }


}