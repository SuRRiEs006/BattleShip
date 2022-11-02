package CS2020.assignment1.game;
import CS2020.assignment1.game.GameControls;
import CS2020.assignment1.game.GameGrid;


class Game implements GameControls{

    public AbstractGameGrid playerGrid;
    public AbstractGameGrid opponentGrid;
    public int numOfShips;

    public Game(int numOfRows, int numOfColumns, int numOfShips){
        this.numOfShips = numOfShips;

        this.playerGrid = new PlayerGameGrid(numOfRows,numOfColumns,numOfShips);
        
        this.opponentGrid = new OpponentGameGrid(numOfRows,numOfColumns,numOfShips);
        
        
    }
    
    public void playRound (String input){}
	
	public boolean checkVictory(){
        boolean playerLoss = true;
        boolean opponentLoss = true;
        boolean isThereWin = false;

        for(int i=0; i<numOfShips;i++){
            if (playerGrid.ships[i].getHits() <= 2){
                playerLoss = false;


            }if (opponentGrid.ships[i].getHits() <= 2){
                opponentLoss = false;

            }

            if (playerLoss==true){
                System.out.println("You have lost!");
                isThereWin = true;

            }else if (opponentLoss==true){
                System.out.println("You have won!");
                isThereWin = true;



            }
        


        }
        

        return isThereWin;

        
    }
	
	public void exitGame (String input){

        if (input=="exit"){
        System.out.println("Exiting game – thank you for playing");
        System.exit(0);
    }
    }
	
	public AbstractGameGrid getPlayersGrid(){
        return this.playerGrid;

    }
	
	public AbstractGameGrid getOpponentssGrid(){
        return this.opponentGrid;
    }
    

    
}
