import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    Animal animal;

    @BeforeEach
    void init() {
        animal = new Animal();
    }

    @Test
    void eat_function_decreases_hunger_by_one() {
        animal.eat();
        assertEquals(49, animal.hunger);
    }

    @Test
    void drink_function_decreases_thirst_by_one() {
        animal.drink();
        assertEquals(49, animal.thirst);
    }

    @Test
    void play_function_increases_hunger_and_thirst_by_one() {
        animal.play();
        assertEquals(51, animal.hunger);
        assertEquals(51, animal.thirst);
    }
}
