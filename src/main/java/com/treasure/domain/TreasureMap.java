package com.treasure.domain;

import javafx.geometry.Pos;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Getter
public class TreasureMap {

    int horizontalSize;
    int verticalSize;
    Adventurer adventurer;
    List<Treasure> treasures;

    public TreasureMap(int horizontalSize, int verticalSize, Adventurer adventurer) {
        this.horizontalSize = horizontalSize;
        this.verticalSize = verticalSize;
        this.adventurer = adventurer;
    }

    public void moveAdventurer() {
        lookForTreasureToCollect(adventurer.position);
        for (int i = 0; i < adventurer.getMovements().length(); i++) {
            Position nextPosition = adventurer.advance(horizontalSize, verticalSize, adventurer.getMovements().charAt(i));
            if (!nextPosition.equals(adventurer.getPosition())) {
                lookForTreasureToCollect(nextPosition);
            }
            adventurer.setPosition(nextPosition);

        }
    }

    private void lookForTreasureToCollect(Position position) {
        if (treasures != null) {
            List<Treasure> treasuresInCurrentPosition = treasuresInPosition(position);
            if (treasuresInCurrentPosition.size() > 0) {
                adventurer.collectTreasure();
                treasures.remove(treasuresInCurrentPosition.get(0));
            }
            ;
        }
    }

    private List<Treasure> treasuresInPosition(Position position) {
        return treasures
                .stream()
                .filter(treasure -> treasure.position.equals(position))
                .collect(Collectors.toList());
    }

}