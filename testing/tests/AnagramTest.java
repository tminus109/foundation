import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {
    String input1, input2;

    @Test
    void happy_case() {
        input1 = "peach";
        input2 = "cheap";
        assertEquals(true, Anagram.isAnagram(input1, input2));
    }

    @Test
    void not_anagrams() {
        input1 = "peach";
        input2 = "beach";
        assertEquals(false, Anagram.isAnagram(input1, input2));
    }

    @Test
    void null_input_test() {
        input1 = "";
        input2 = "peach";
        assertEquals(false, Anagram.isAnagram(input1, input2));
    }
}
