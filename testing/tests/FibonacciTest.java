import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    int n;

    @Test
    void happy_test_n0() {
        n = 0;
        assertEquals(0, Fibonacci.fibonacci(n));
    }

    @Test
    void happy_test_n1() {
        n = 1;
        assertEquals(1, Fibonacci.fibonacci(n));
    }

    @Test
    void happy_test_n5() {
        n = 5;
        assertEquals(5, Fibonacci.fibonacci(n));
    }

    @Test
    void happy_test_n9() {
        n = 9;
        assertEquals(34, Fibonacci.fibonacci(n));
    }

    @Test
    void fibonacci_negative_input_test() {
        n = -234;
        assertEquals(0, Fibonacci.fibonacci(n));
    }
}
