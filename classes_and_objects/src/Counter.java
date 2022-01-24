public class Counter {
    int initialCounter;
    int counter;

    Counter() {
        this.counter = 0;
        this.initialCounter = 0;
    }

    Counter(int counter) {
        this.counter = counter;
        this.initialCounter = counter;
    }

    public void add(int number) {
        this.counter += number;
    }

    public void add() {
        this.counter++;
    }

    public int get() {
        return this.counter;
    }

    public void reset() {
        this.counter = initialCounter;
    }
}
