package com.treasure.domain;

public class OrientationSouthStrategy implements MovementStrategy {

    public Position move(Position oldPosition, Position mapSize) {
        Position newPosition = new Position();
        int newVerticalPosition = oldPosition.getVerticalPosition() + 1;
        if(newVerticalPosition< mapSize.getVerticalPosition()){
            newPosition.setHorizontalPosition(oldPosition.getHorizontalPosition());
            newPosition.setVerticalPosition(newVerticalPosition);
            return newPosition;
        }
        return oldPosition;
    }
}
