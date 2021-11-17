public class Reverse {
    public static String reverse(String toBeReversed) {
//        StringBuilder reversedString = new StringBuilder();
//        for (int i = toBeReversed.length() - 1; i >= 0; i--) {
//            reversedString.append(toBeReversed.charAt(i));
//        }
//        return reversedString.toString();

        StringBuilder reversedString = new StringBuilder();
        reversedString.append(toBeReversed);
        return reversedString.reverse().toString();
    }

    public static void main(String[] args) {
        String toBeReversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";
        System.out.println(reverse(toBeReversed));
    }
}
