package CS2020.assignment1.game;

import CS2020.assignment1.game.AbstractBattleShip;
import java.util.Random;

class BattleShip extends AbstractBattleShip {

    public BattleShip(String name) {
        //TAKES name PARAMETER AND ASIGNS TO BattleShip.name
        this.name = name;
        Random rand = new Random();

        //DEPENDING ON THE BINARY RANDOM OUTPUT "horizontal" or "verticle" is assigned
        if (rand.nextInt(2) == 0) {
            this.shipOrientation = "horizontal";

        } else {
            this.shipOrientation = "vertical";

        }

    }

    // CHECK ATTACK WORKS BY TAKING x,y AS PARAMETERS AND SEEING IF THEY HIT THE
    // SHIPS
    public boolean checkAttack(int row, int column) {

        // hitOrMiss SET TO false IF SET TO TRUE AT ANY POINT IN THIS METHOD THEN ITS
        // GOING TO RETURN A true
        boolean hitOrMiss = false;

        // FOR LOOP TO TRAVERSE ALL THE FIRST DIMENTION INDEXES
        for (int i = 0; i < this.shipCoordinates.length; i++) {

            // CHECKS IF x,y AND IF THEY ARE THE SAME AND HITS < 3
            if (((row == this.shipCoordinates[i][0]) && (column == this.shipCoordinates[i][1])) && (this.hits < 3)) {

                // INCRIMENTS SHIP HIT BY ONE
                this.hits = this.hits + 1;

                // hitOrMiss = true SO CAN RETURN TRUE VALUE TO INFORM THAT HIT WAS SUCCSESSFUL
                hitOrMiss = true;

            }

        }
        // RETURNS true OR false TO INDICATE IF SHIP HIT SUCSESSFULLY
        return hitOrMiss;

    }

    // GETTER METHOD FOR SHIP UNIQUE NAME EG. "ship 1"
    public String getName() {

        return this.name;

    }

    // GETTER METHOD FOR SHIP NUMBER OF HITS RECIEVED
    public int getHits() {

        return this.hits;

    }

    // GETTER METHOD FOR SHIP ORIENTATION CAN RETURN "horizontal" OR "verticle"
    public String getShipOrientation() {

        return this.shipOrientation;

    }

    // SETTER METHOD FOR NUMBER OF HITS MADE TO SHIP
    public void setHits(int numberOfHits) {

        this.hits = numberOfHits;

    }

    // GETTER METHOD FOR SHIP CO-ORDINATES
    public int[][] getShipCoordinates() {

        return this.shipCoordinates;

    }

    // SETTER METHOD FOR SHIP CO-ORDINATES
    public void setShipCoordinates(int[][] coordinates) {

        this.shipCoordinates = coordinates;

    }

}