import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

class CountLettersTest {
    CountLetters countLetters;
    HashMap<Character, Integer> expected;
    String string;

    @BeforeEach
    void init() {
        countLetters = new CountLetters();
        expected = new HashMap<>();
        expected.put('b', 2);
        expected.put('a', 1);
        expected.put('y', 1);
    }

    @Test
    void happy_case() {
        string = "baby";
        HashMap<Character, Integer> toTest = new HashMap<>(countLetters.dictionary(string));
        assertEquals(expected, toTest);
    }

    @Test
    void unhappy_case() {
        string = "girl";
        HashMap<Character, Integer> toTest = new HashMap<>(countLetters.dictionary(string));
        assertNotEquals(expected, toTest);
    }
}
