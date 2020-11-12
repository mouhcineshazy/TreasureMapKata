import com.treasure.domain.*;
import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(HierarchicalContextRunner.class)
public class TreasureMapTest {
    private final int horizontalSize = 3;
    private final int verticalSize = 4;
    private static final Position POSITION = new Position(1, 1);

    @Test
    public void adventurer_should_move_verticaly_forward_given_movement_has_A_character_and_orientation_south() {

        Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "S", "A", 0);
        TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(1, 2);
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
    }

    @Test
    public void adventurer_should_move_verticaly_back_given_movement_has_A_character_and_oritentation_north() {

        Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "N", "A", 0);
        TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(1, 0);
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());

    }

    @Test
    public void adventurer_should_move_horizontaly_forward_given_movement_has_A_character_and_oritentation_East() {

        Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "E", "A", 0);
        TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(2, 1);
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
    }

    @Test
    public void adventurer_should_move_horizontaly_backward_given_movement_has_A_character_and_oritentation_West() {

        Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "O", "A", 0);
        TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(0, 1);
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
    }


    public class AdventurerTurnsRight {
        @Test
        public void adventurer_should_change_orientation_to_Ouest_and_move_forward_given_he_moves_right_and_his_orientation_is_south() {

            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "S", "D", 0);
            TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
            treasureMap.moveAdventurer();
            Position newPosition = new Position(0, 1);
            assertEquals("O", treasureMap.getAdventurer().getOrientation());
            assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
        }

        @Test
        public void adventurer_should_change_orientation_to_East_and_move_forward_given_he_moves_right_and_his_orientation_is_north() {

            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "N", "D", 0);
            TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
            treasureMap.moveAdventurer();
            Position newPosition = new Position(2, 1);
            assertEquals("E", treasureMap.getAdventurer().getOrientation());
            assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
        }

        @Test
        public void adventurer_should_change_orientation_to_South_and_move_forward_given_he_moves_right_and_his_orientation_is_east() {

            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "E", "D", 0);
            TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
            treasureMap.moveAdventurer();
            Position newPosition = new Position(1, 2);
            assertEquals("S", treasureMap.getAdventurer().getOrientation());
            assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
        }

        @Test
        public void adventurer_should_change_orientation_to_North_and_move_forward_given_he_moves_right_and_his_orientation_is_Ouest() {
            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "O", "D", 0);
            TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
            treasureMap.moveAdventurer();
            Position newPosition = new Position(1, 0);
            assertEquals("N", treasureMap.getAdventurer().getOrientation());
            assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
        }
    }

    public class AdventurerTurnsLeft {
        @Test
        public void adventurer_should_change_orientation_to_East_and_move_forward_given_he_moves_left_and_his_orientation_is_south() {

            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "S", "G", 0);
            TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
            treasureMap.moveAdventurer();
            Position newPosition = new Position(2, 1);
            assertEquals("E", treasureMap.getAdventurer().getOrientation());
            assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
        }

        @Test
        public void adventurer_should_change_orientation_to_Ouest_and_move_forward_given_he_moves_left_and_his_orientation_is_north() {

            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "N", "G", 0);
            TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
            treasureMap.moveAdventurer();
            Position newPosition = new Position(0, 1);
            assertEquals("O", treasureMap.getAdventurer().getOrientation());
            assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
        }

        @Test
        public void adventurer_should_change_orientation_to_North_and_move_forward_given_he_moves_left_and_his_orientation_is_Ouest() {

            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "O", "G", 0);
            TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
            treasureMap.moveAdventurer();
            Position newPosition = new Position(1, 2);
            assertEquals("S", treasureMap.getAdventurer().getOrientation());
            assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
        }

        @Test
        public void adventurer_should_change_orientation_to_South_and_move_forward_given_he_moves_left_and_his_orientation_is_East() {

            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "E", "G", 0);
            TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
            treasureMap.moveAdventurer();
            Position newPosition = new Position(1, 0);
            assertEquals("N", treasureMap.getAdventurer().getOrientation());
            assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
        }
    }

    @Test
    public void adventurer_performs_2_movements() {
        Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "S", "AA", 0);
        TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(1, 3);
        assertEquals("S", treasureMap.getAdventurer().getOrientation());
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
    }

    @Test
    public void adventurer_has_orientation_north_and_change_position_given_he_performs_the_set_of_movements_AADADA() {
        Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "S", "AADADA", 0);
        TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(0, 1);
        assertEquals("N", treasureMap.getAdventurer().getOrientation());
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
    }

    @Test
    public void adventurer_has_orientation_south_and_change_position_given_he_performs_the_set_of_movements_AADADAGGA() {
        Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "S", "AADADAGGA", 0);
        TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(0, 3);
        assertEquals("S", treasureMap.getAdventurer().getOrientation());

        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
    }

    @Test
    public void adventurer_should_stay_in_current_position_and_current_orientation_when_movement_is_executed_given_position_is_equal_to_maps_vertical_size() {
        Position position = new Position(1, 3);
        Adventurer adventurerIbra = new Adventurer(position, "Ibra", "S", "A", 0);
        TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(1, 3);
        assertEquals("S", treasureMap.getAdventurer().getOrientation());
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
    }

    @Test
    public void adventurer_should_stay_in_current_position_and_current_orientation_when_movement_is_executed_given_position_is_equal_to_maps_horizontal_size() {
        Position position = new Position(2, 1);
        Adventurer adventurerIbra = new Adventurer(position, "Ibra", "E", "A", 0);
        TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(2, 1);
        assertEquals("E", treasureMap.getAdventurer().getOrientation());
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
    }

    @Test
    public void adventurer_should_stay_in_current_position_and_change_orientation_when_movement_turnRight_is_executed_given_position_is_equal_to_maps_horizontal_size() {
        Position position = new Position(2, 1);
        Adventurer adventurerIbra = new Adventurer(position, "Ibra", "N", "D", 0);
        TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(2, 1);
        assertEquals("E", treasureMap.getAdventurer().getOrientation());
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
    }


    public class MapHasTreasure {

        @Test
        public void adventurer_should_collect_zero_treasures_given_no_treasure_was_on_his_path() {

            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "S", "AADADAGGA", 0);
            TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra);
            treasureMap.moveAdventurer();
            assertEquals(0, treasureMap.getAdventurer().getTreasuresCollected());
        }

        @Test
        public void adventurer_should_collect_one_treasure_given_adventurer_moves_to_a_position_with_treasure() {
            List<Treasure> treasureList = new ArrayList<>();
            Treasure treasures = new Treasure(new Position(1, 3));
            treasureList.add(treasures);
            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "S", "AA", 0);
            TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra, treasureList);
            treasureMap.moveAdventurer();
            assertEquals(1, adventurerIbra.getTreasuresCollected());
            assertEquals(0, treasureMap.getTreasures().size());
        }

        @Test
        public void adventurer_should_collect_treasures_treasure_given_adventurer_and_treasure_have_same_position() {
            List<Treasure> treasureList = new ArrayList<>();
            Treasure treasure = new Treasure(POSITION);
            treasureList.add(treasure);
            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "S", "A", 0);
            TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra, treasureList);
            treasureMap.moveAdventurer();
            assertEquals(1, adventurerIbra.getTreasuresCollected());
            assertEquals(0, treasureMap.getTreasures().size());
        }

        @Test
        public void adventurer_should_collect_three_treasures_given_adventurer_passes_by_treasures_positions_on_his_path() {
            List<Treasure> treasureList = getTreasures();
            Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "S", "AADADAGGA", 0);
            TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra, treasureList);
            treasureMap.moveAdventurer();
            assertEquals(3, treasureMap.getAdventurer().getTreasuresCollected());
            assertEquals(2, treasureMap.getTreasures().size());
        }

        private List<Treasure> getTreasures() {
            List<Treasure> treasureList = new ArrayList<>();
            Treasure treasure1 = new Treasure(new Position(1, 3));
            Treasure treasure2 = new Treasure(new Position(1, 3));
            Treasure treasure3 = new Treasure(new Position(0, 3));
            Treasure treasure4 = new Treasure(new Position(0, 3));
            Treasure treasure5 = new Treasure(new Position(0, 3));
            treasureList.add(treasure1);
            treasureList.add(treasure2);
            treasureList.add(treasure3);
            treasureList.add(treasure4);
            treasureList.add(treasure5);
            return treasureList;
        }
    }

    @Test
    public void adventurer_is_blocked_in_position_given_next_position_has_mountain() {

        List<Treasure> treasures = new ArrayList<>();
        Mountain mountain = new Mountain(new Position(1,0));
        List<Mountain> mountains = new ArrayList<>();
        mountains.add(mountain);
        Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "N", "A", 0);
        TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra,treasures, mountains);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(1, 1);
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
        assertEquals("N", treasureMap.getAdventurer().getOrientation());
    }

    @Test
    public void adventurer_is_blocked_in_position_and_changes_orientation_given_next_position_has_mountain_and_turns_right() {

        List<Treasure> treasures = new ArrayList<>();
        Mountain mountain = new Mountain(new Position(2,1));
        List<Mountain> mountains = new ArrayList<>();
        mountains.add(mountain);
        Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "N", "D", 0);
        TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra,treasures, mountains);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(1, 1);
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
        assertEquals("E", treasureMap.getAdventurer().getOrientation());
    }

    @Test
    public void adventurer_is_blocked_in_position_and_changes_orientation_given_next_position_has_mountain_and_turns_left() {

        List<Treasure> treasures = new ArrayList<>();
        Mountain mountain = new Mountain(new Position(0,1));
        List<Mountain> mountains = new ArrayList<>();
        mountains.add(mountain);
        Adventurer adventurerIbra = new Adventurer(POSITION, "Ibra", "N", "G", 0);
        TreasureMap treasureMap = new TreasureMap(horizontalSize, verticalSize, adventurerIbra,treasures, mountains);
        treasureMap.moveAdventurer();
        Position newPosition = new Position(1, 1);
        assertEquals(newPosition, treasureMap.getAdventurer().getPosition());
        assertEquals("O", treasureMap.getAdventurer().getOrientation());
    }


}
