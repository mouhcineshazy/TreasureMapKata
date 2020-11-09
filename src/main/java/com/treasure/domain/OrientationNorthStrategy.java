package com.treasure.domain;

public class OrientationNorthStrategy implements MovementStrategy {

    public Position move(Position oldPosition, Position mapSize) {
        Position newPosition = new Position();
        int newVerticalPosition = oldPosition.getVerticalPosition() - 1;
        if(newVerticalPosition >=0){
            newPosition.setHorizontalPosition(oldPosition.getHorizontalPosition());
            newPosition.setVerticalPosition(newVerticalPosition);
            return newPosition;
        }
        return oldPosition;
    }
}
