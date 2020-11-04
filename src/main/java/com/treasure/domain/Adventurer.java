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


    void advance() {
        MovementStrategy movementSrategy = createMovementStrategy();
        position = movementSrategy.move(position);
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
