public class CompareLength {
    public static void main(String[] args) {
        int[] firstArrayOfNumbers = {1, 2, 3};
        int[] secondArrayOfNumbers = {4, 5};
        if (secondArrayOfNumbers.length > firstArrayOfNumbers.length) {
            System.out.println("A secondArrayOfNumbers hosszabb");
        } else {
            System.out.println("A firstArrayOfNumbers hosszabb");
        }
    }
}
