package com.treasure.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@AllArgsConstructor
@Getter
public class TreasureMap {

    int horizantalSize;
    int verticalSize;
    Adventurer adventurer;
    Treasure treasure;

    public TreasureMap(int horizantalSize, int verticalSize, Adventurer adventurer) {
        this.horizantalSize = horizantalSize;
        this.verticalSize = verticalSize;
        this.adventurer = adventurer;
    }

    public void moveAdventurer() {
       adventurer.advance();
    }

    public List<Treasure> findTreasure() {
        List<Treasure> treasureCollected = new ArrayList<>();
        if(!this.getTreasure().isPresent()){
             return treasureCollected;
        }
        if(this.isTreasureAndAdventurerAreOnTheSamePosition()) {
            treasureCollected.add(this.treasure);
            this.treasure.setTreasureCount(this.treasure.getTreasureCount()-1);
        }
        return treasureCollected;
    }

    private boolean isTreasureAndAdventurerAreOnTheSamePosition(){
        return this.adventurer.getPosition().equals(treasure.getPosition());
    }


    private Optional<Treasure> getTreasure(){
        return ofNullable(treasure);
    }
}
