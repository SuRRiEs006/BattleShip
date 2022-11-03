//IMPORTS ALL THE NESSASARY JAVA FILES
package CS2020.assignment1.game;

import CS2020.assignment1.game.GameGrid;

//PlayerGameGrid EXTENDS BattleShip class THAT EXTENDS AbstractBattleShip
class PlayerGameGrid extends GameGrid {

    public PlayerGameGrid(int width, int height, int numberOfShips) {
        super(width, height, numberOfShips);
        // TODO Auto-generated constructor stub

    }

    public void printGrid() {

        // PRINTS WHO'S GRID IT IS
        System.out.println("Player’s grid");

        // CHECKS FOR ALL INDEXES IN 2D ARRAY HENCE THE NESTED FOR LOOP TO GET ALL THE
        // INDEXES CHECKED
        for (int i = 0; i < (this.gameGrid.length); i++) {
            for (int j = 0; j < (this.gameGrid.length); j++) {

                // CAN PRINT EVERYTHING BECAUSE THE USER CAN SEE WHAT THE OPPONENT HAS DONE TO
                // THIER GRID
                System.out.print(" " + this.gameGrid[i][j]);

            }
             // PROVIDES SPACE FOR AESTHETIC
            System.out.println();

        }

    }
}
