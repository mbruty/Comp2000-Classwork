package net.bruty.algofun.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentHuntingTest {

    @org.junit.jupiter.api.Test
    void find() {

        List<Map<String, Boolean>> blocks = new ArrayList<>();
        blocks.add(craftMap(false, true, false));
        blocks.add(craftMap(true, false, false));
        blocks.add(craftMap(true, true, false));
        blocks.add(craftMap(false, true, false));
        blocks.add(craftMap(false, true, true));
        assertEquals(ApartmentHunting.find(blocks, new String[] { "gym", "school", "store"}), 3);

    }

    private static Map<String, Boolean> craftMap(boolean gym, boolean school, boolean store){
        Map<String, Boolean> temp = new HashMap<>();
        temp.put("gym", gym);
        temp.put("school", school);
        temp.put("store", store);
        return temp;
    }
}