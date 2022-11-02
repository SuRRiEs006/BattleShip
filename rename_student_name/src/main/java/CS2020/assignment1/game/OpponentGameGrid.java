package CS2020.assignment1.game;
import CS2020.assignment1.game.GameGrid;


class OpponentGameGrid extends GameGrid{

    public OpponentGameGrid(int width, int height, int numberOfShips) {
        super(width, height, numberOfShips);
        //TODO Auto-generated constructor stub
    }


    public void printGrid(){

        System.out.println("Player’s grid");
        for (int i = 0; i < (this.gameGrid.length); i++) {
            for (int j = 0; j < (this.gameGrid.length); j++) {
                
                String nextOut = this.gameGrid[i][j];
                if (nextOut == "*"){
                    nextOut = ".";

                }
                    

                System.out.print(nextOut);

            }

            System.out.println();

        }
    
}
}