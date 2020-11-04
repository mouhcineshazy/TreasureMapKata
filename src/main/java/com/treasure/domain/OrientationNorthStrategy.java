package com.treasure.domain;

public class OrientationNorthStrategy implements MovementStrategy {

    public Position move(Position oldPosition) {
        Position newPosition = new Position();
        int newVerticalPosition = oldPosition.getVerticalPosition() - 1;
        newPosition.setHorizantalPosition(oldPosition.getHorizantalPosition());
        newPosition.setVerticalPosition(newVerticalPosition);
        return newPosition;
    }
}
