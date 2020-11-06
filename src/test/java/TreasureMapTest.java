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
    private final int horizontalSize = 3;
    private final int verticalSize = 4;
    public static final Position POSITION = new Position(1, 1);

    @Test
    public void should_return_zero_treasures_given_map_has_no_treasure() {
        int horizantalSize = 3;
        int verticalSize = 4;

        Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "S", "A");
        TreasureMap treasureMap = new TreasureMap(horizantalSize, verticalSize, adventurerIbra);
        List<Treasure> treasures = treasureMap.findTreasure();
        assertEquals(0, treasures.size());
    }

    @Test
    public void adventurer_should_move_verticaly_forward_given_movement_has_A_character_and_orientation_south() {

        Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "S", "A");
        TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(1, 2);
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
    }

    @Test
    public void adventurer_should_move_verticaly_back_given_movement_has_A_character_and_oritentation_north() {

        Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "N", "A");
        TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(1, 0);
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());

    }

    @Test
    public void adventurer_should_move_horizontaly_forward_given_movement_has_A_character_and_oritentation_East() {

        Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "E", "A");
        TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(2, 1);
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
    }

    @Test
    public void adventurer_should_move_horizontaly_backward_given_movement_has_A_character_and_oritentation_West() {

        Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "O", "A");
        TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(0, 1);
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
    }


    public class AdventurerTurnsRight {
        @Test
        public void adventurer_should_change_orientation_to_Ouest_given_he_turns_right_and_his_orientation_is_south() {

            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "S", "D");
            TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
            treasureMap.moveAdventurer();
            assertEquals("O", treasureMap.getAdventurer().getOrientation());
        }

        @Test
        public void adventurer_should_change_orientation_to_East_given_he_turns_right_and_his_orientation_is_north() {

            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "N", "D");
            TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
            treasureMap.moveAdventurer();
            assertEquals("E", treasureMap.getAdventurer().getOrientation());
        }

        @Test
        public void adventurer_should_change_orientation_to_South_given_he_turns_right_and_his_orientation_is_east() {

            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "E", "D");
            TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
            treasureMap.moveAdventurer();
            assertEquals("S", treasureMap.getAdventurer().getOrientation());
        }

        @Test
        public void adventurer_should_change_orientation_to_North_given_he_turns_right_and_his_orientation_is_Ouest() {
            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "O", "D");
            TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
            treasureMap.moveAdventurer();
            assertEquals("N", treasureMap.getAdventurer().getOrientation());
        }
    }

    public class AdventurerTurnsLeft {
        @Test
        public void adventurer_should_change_orientation_to_East_given_he_turns_left_and_his_orientation_is_south() {

            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "S", "G");
            TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
            treasureMap.moveAdventurer();
            assertEquals("E", treasureMap.getAdventurer().getOrientation());

        }

        @Test
        public void adventurer_should_change_orientation_to_Ouest_given_he_turns_left_and_his_orientation_is_north() {

            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "N", "G");
            TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
            treasureMap.moveAdventurer();
            assertEquals("O", treasureMap.getAdventurer().getOrientation());
        }

        @Test
        public void adventurer_should_change_orientation_to_North_given_he_turns_left_and_his_orientation_is_Ouest() {

            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "O", "G");
            TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
            treasureMap.moveAdventurer();
            assertEquals("S", treasureMap.getAdventurer().getOrientation());
        }

        @Test
        public void adventurer_should_change_orientation_to_South_given_he_turns_left_and_his_orientation_is_East() {

            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "E", "G");
            TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
            treasureMap.moveAdventurer();
            assertEquals("N", treasureMap.getAdventurer().getOrientation());
        }
    }

    @Test
    public void adventurer_performs_2_movements() {
        Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "S", "AA");
        TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(1, 3);
        assertEquals("S", treasureMap.getAdventurer().getOrientation());
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
    }

    @Test
    public void adventurer_has_orientation_north_and_change_position_given_he_performs_the_set_of_movements_AADADA() {
        Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "S", "AADADA");
        TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(0, 2);
        assertEquals("N", treasureMap.getAdventurer().getOrientation());
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
    }

    @Test
    public void adventurer_has_orientation_south_and_change_position_given_he_performs_the_set_of_movements_AADADAGGA() {
        Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "S", "AADADAGGA");
        TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(0, 3);
        assertEquals("S", treasureMap.getAdventurer().getOrientation());
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
    }

    public class MapHasTreasure {


        @Test
        public void should_return_one_treasure_given_there_is_one_treasure_and_is_on_the_same_position_as_adventurer() {
            int horizantalSize = 3;
            int verticalSize = 4;
            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "E", "A");
            Position treasurePosition = new Position(1, 1);
            Treasure treasure = new Treasure(treasurePosition, 1);
            TreasureMap treasureMap = new TreasureMap(horizantalSize, verticalSize, adventurerIbra, treasure);
            List<Treasure> treasuresFound = treasureMap.findTreasure();
            assertEquals(1, treasuresFound.size());
        }
    }


}
