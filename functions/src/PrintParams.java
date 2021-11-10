import java.util.Arrays;

public class PrintParams {
    public static void printParams(String... params) {
        System.out.println(Arrays.toString(params));
    }

    public static void main(String[] args) {
        printParams("one", "two", "three", "four", "five");
    }
}
