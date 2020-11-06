package com.treasure.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Adventurer {

    Position position;
    String adventurerName;
    String orientation;
    String movements;


    void executeMovements() {
        for (int i = 0; i < movements.length(); i++) {
            if(movements.charAt(i) == 'D' || movements.charAt(i) == 'G'){
               makeATurn(movements.charAt(i));
            }else if(movements.charAt(i) == 'A'){
                advance();
            }
        }
    }

    private void advance(){
        MovementStrategy movementSrategy = createMovementStrategy();
        position = movementSrategy.move(position);
    }

    private void makeATurn(char movement){
        if (movement == 'D') {
            switch (orientation) {
                case "S":
                    orientation = "O";
                    break;
                case "N":
                    orientation = "E";
                    break;
                case "E":
                    orientation = "S";
                    break;
                case "O":
                    orientation = "N";
            }
        } else if (movement == 'G')
            if (orientation.equals("S")) orientation = "E";
            else if (orientation.equals("N")) orientation = "O";
            else if (orientation.equals("O")) orientation = "S";
            else if (orientation.equals("E")) orientation = "N";
    }

    private MovementStrategy createMovementStrategy() {
        if (orientation.equals("S"))
            return new OrientationSouthStrategy();
        else if (orientation.equals("N"))
            return new OrientationNorthStrategy();
        else if (orientation.equals("E"))
            return new OrientationEastStrategy();
        return new OrientationWestStrategy();
    }
}
