import com.treasure.domain.Adventurer;
import com.treasure.domain.Position;
import com.treasure.domain.Treasure;
import com.treasure.domain.TreasureMap;
import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(HierarchicalContextRunner.class)
public class TreasureMapTest {
    private final int horizantalSize = 3;
    private final int verticalSize = 4;

    @Test
    public void should_return_zero_treasures_given_map_has_no_treasure() {
        int horizantalSize = 3;
        int verticalSize = 4;
        Position position = new Position(1,1);
        Adventurer adventurerIbra = new Adventurer(position, "Ibra", "S", "A");
        TreasureMap treasureMap = new TreasureMap(horizantalSize, verticalSize, adventurerIbra);
        List<Treasure> treasures = treasureMap.findTreasure();
        assertEquals(0, treasures.size());
    }

    @Test
    public void adventurer_should_move_verticaly_forward_given_movement_has_A_character_and_orientation_south() {
        Position position = new Position(1,1);
        Adventurer adventurerIbra = new Adventurer(position, "Ibra", "S", "A");
        TreasureMap treasureMap = new TreasureMap(horizantalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(1,2);
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
    }

    @Test
    public void adventurer_should_move_verticaly_back_given_movement_has_A_character_and_oritentation_north() {
        Position position = new Position(1,1);
        Adventurer adventurerIbra = new Adventurer(position, "Ibra", "N", "A");
        TreasureMap treasureMap = new TreasureMap(horizantalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(1,0);
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());

    }
    @Test
    public void adventurer_should_move_horizontaly_forward_given_movement_has_A_character_and_oritentation_East() {
        Position position = new Position(1,1);
        Adventurer adventurerIbra = new Adventurer(position, "Ibra", "E", "A");
        TreasureMap treasureMap = new TreasureMap(horizantalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(0,1);
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
    }

    @Test
    public void adventurer_should_move_horizontaly_backward_given_movement_has_A_character_and_oritentation_West() {
        Position position = new Position(1,1);
        Adventurer adventurerIbra = new Adventurer(position, "Ibra", "O", "A");
        TreasureMap treasureMap = new TreasureMap(horizantalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(2,1);
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
    }

    public class MapHasTreasure {


        @Test
        public void should_return_one_treasure_given_there_is_one_treasure_and_is_on_the_same_position_as_adventurer() {
            int horizantalSize = 3;
            int verticalSize = 4;
            Position adventurerPposition = new Position(1,1);
            Adventurer adventurerIbra = new Adventurer(adventurerPposition, "Ibra", "E", "A");
            Position treasurePosition = new Position(1,1);
            Treasure treasure = new Treasure(treasurePosition, 1);
            TreasureMap treasureMap = new TreasureMap(horizantalSize, verticalSize, adventurerIbra, treasure);
            List<Treasure> treasuresFound = treasureMap.findTreasure();
            assertEquals(1, treasuresFound.size());
        }
    }


}
