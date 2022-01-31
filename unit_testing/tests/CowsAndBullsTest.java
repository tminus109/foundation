import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CowsAndBullsTest {
    CowsAndBulls cowsAndBulls;

    @BeforeEach
    void init() {
        cowsAndBulls = new CowsAndBulls();
    }

    @Test
    void numberToBeGuessed_is_greater_than_999() {
        assertTrue(cowsAndBulls.numberToBeGuessed > 999);
    }

    @Test
    void numberToBeGuessed_is_smaller_than_10000() {
        assertTrue(cowsAndBulls.numberToBeGuessed < 10000);
    }

    @Test
    void guessCount_equals_zero() {
        assertEquals(0, cowsAndBulls.guessCount);
    }

    @Test
    void state_happy_test() {
        assertEquals("The game hasn't started yet.", cowsAndBulls.state);
    }

    @Test
    void setState_happy_test() {
        cowsAndBulls.setState("The game is over.");
        assertEquals("The game is over.", cowsAndBulls.state);
    }

    @Test
    void getFourDigits_happy_test() {
        int number = 1234;
        int[] digitsOfNumber = {1, 2, 3, 4};
        assertArrayEquals(digitsOfNumber, cowsAndBulls.getFourDigits(number));
    }
}
