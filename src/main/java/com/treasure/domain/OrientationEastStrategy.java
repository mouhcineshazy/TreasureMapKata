package com.treasure.domain;

public class OrientationEastStrategy implements MovementStrategy {

    public Position move(Position oldPosition) {
        Position newPosition = new Position();
        int newHorizantalPosition = oldPosition.getHorizantalPosition() + 1;
        newPosition.setHorizantalPosition(newHorizantalPosition);
        newPosition.setVerticalPosition(oldPosition.getVerticalPosition());
        return newPosition;
    }
}
