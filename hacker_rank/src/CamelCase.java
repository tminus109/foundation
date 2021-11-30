public class CamelCase {
    public static int camelCase(String s) {
//        return s.length() - s.replaceAll("[A-Z]", "").length() + 1;

        String[] words = s.split("[A-Z]");
        return words.length;
    }

    public static void main(String[] args) {
        String s0 = "oneTwoThree";
        String s1 = "saveChangesInTheEditor";

        System.out.println(camelCase(s0));
        System.out.println(camelCase(s1));
    }
}
