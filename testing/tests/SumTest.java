import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SumTest {
    Sum sum = new Sum();
    List<Integer> list;

    @Test
    void sum_null() {
        assertEquals(0, sum.sumList(null));
    }

    @Test
    void sum_empty_list() {
        list = new ArrayList<>();
        assertEquals(0, sum.sumList(list));
    }

    @Test
    void sum_list_of_one_element() {
        list = new ArrayList<>(List.of(4));
        assertEquals(4, sum.sumList(list));
    }

    @Test
    void sum_list_of_four_elements() {
        list = new ArrayList<>(Arrays.asList(4, 7, 911, 1));
        assertEquals(923, sum.sumList(list));
    }
}
