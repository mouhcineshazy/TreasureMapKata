package com.treasure.domain;

public class OrientationWestStrategy implements MovementStrategy {

    public Position move(Position oldPosition, Position mapSize) {
        Position newPosition = new Position();
        int newHorizontalPosition = oldPosition.getHorizontalPosition() - 1;
        if(newHorizontalPosition>=0){
            newPosition.setHorizontalPosition(newHorizontalPosition);
            newPosition.setVerticalPosition(oldPosition.getVerticalPosition());
            return newPosition;
        }
        return oldPosition;
    }
}
