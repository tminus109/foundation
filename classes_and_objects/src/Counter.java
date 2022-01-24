public class Counter {
    int initialCounter;
    int counter;

    Counter() {
        this.initialCounter = 0;
        this.counter = 0;
    }

    Counter(int counter) {
        this.initialCounter = counter;
        this.counter = counter;
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
