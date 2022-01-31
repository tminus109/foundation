import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppleTest {
    Apple apple = new Apple("apple");

    @Test
    void happy_case() {
        assertEquals("apple", apple.getApple());
    }

    @Test
    void unhappy_case() {
        assertNotEquals("pear", apple.getApple());
    }
}
