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
    int treasuresCollected;


    Position advance(int horizontalSize, int verticalSize, char movement) {
        if (movement == 'D' || movement == 'G')
            makeATurn(movement);
        Position mapSize = new Position(horizontalSize, verticalSize);
        MovementStrategy movementStrategy = createMovementStrategy();
        return movementStrategy.move(position, mapSize);
    }

    void collectTreasure() {
        ++treasuresCollected;
    }

    private void makeATurn(char movement) {
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
        switch (orientation) {
            case "S":
                return new OrientationSouthStrategy();
            case "N":
                return new OrientationNorthStrategy();
            case "E":
                return new OrientationEastStrategy();
            default:
                return new OrientationWestStrategy();
        }
    }
}
