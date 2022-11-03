//IMPORTS ALL THE NESSASARY JAVA FILES
package CS2020.assignment1.game;

import CS2020.assignment1.game.GameGrid;

//OpponentGameGrid EXTENDS BattleShip class THAT EXTENDS AbstractBattleShip
class OpponentGameGrid extends GameGrid {

    public OpponentGameGrid(int width, int height, int numberOfShips) {
        super(width, height, numberOfShips);

    }

    // PRINTS GRID FOR THE PLAYERS POINT OF VIEW
    public void printGrid() {

        //PRINTS WHO'S GRID IT IS
        System.out.println("Player’s grid");

        // CHECKS FOR ALL INDEXES IN 2D ARRAY HENCE THE NESTED FOR LOOP TO GET ALL THE
        // INDEXES CHECKED
        for (int i = 0; i < (this.gameGrid.length); i++) {
            for (int j = 0; j < (this.gameGrid.length); j++) {

                // SAVES THE STRING CONTENTS INDEX to nextOut SO CAN PROCESS IF IT SHOULD BE
                // SHOWN OR NOT
                String nextOut = this.gameGrid[i][j];
                // IF nextOut IS "*" THEN IT HAS TO BE HIDDEN WITH "." AS THIS WOULD GIVE AWAY
                // OPPONENTS POSITION
                if (nextOut.equals("*")) {
                    nextOut = ".";

                }

                // OUTPUTS THE PROCESSED STRING
                System.out.print(" " + nextOut);

            }
            // PROVIDES SPACE FOR AESTHETIC
            System.out.println();
        }

    }
}