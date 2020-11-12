package com.treasure.domain;

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
    List<Mountain> mountains;

    public TreasureMap(int horizontalSize, int verticalSize, Adventurer adventurer) {
        this.horizontalSize = horizontalSize;
        this.verticalSize = verticalSize;
        this.adventurer = adventurer;
    }

    public TreasureMap(int horizontalSize, int verticalSize, Adventurer adventurer, List<Treasure> treasures) {
        this.horizontalSize = horizontalSize;
        this.verticalSize = verticalSize;
        this.adventurer = adventurer;
        this.treasures = treasures;
    }

    public void moveAdventurer() {
        lookForTreasureToCollect(adventurer.position);
        for (int i = 0; i < adventurer.getMovements().length(); i++) {
            Position nextPosition = adventurer.advance(horizontalSize, verticalSize, adventurer.getMovements().charAt(i));
            if (!nextPosition.equals(adventurer.getPosition())) {
                lookForTreasureToCollect(nextPosition);
            }
            if (!nextPositionHasMountain(nextPosition))
                adventurer.setPosition(nextPosition);
        }
    }

    private boolean nextPositionHasMountain(Position nextPosition) {
        if (mountains != null) {
            List<Mountain> mountainsInPosition = mountains
                    .stream()
                    .filter(mountain -> mountain.getPosition().equals(nextPosition))
                    .collect(Collectors.toList());
            return mountainsInPosition.size() > 0;
        }
        return false;
    }

    private void lookForTreasureToCollect(Position position) {
        if (treasures != null) {
            List<Treasure> treasuresInCurrentPosition = treasuresInPosition(position);
            if (treasuresInCurrentPosition.size() > 0) {
                adventurer.collectTreasure();
                treasures.remove(treasuresInCurrentPosition.get(0));
            }
        }
    }

    private List<Treasure> treasuresInPosition(Position position) {
        return treasures
                .stream()
                .filter(treasure -> treasure.position.equals(position))
                .collect(Collectors.toList());
    }

}