public class Greet {
    public static String greet(String input) {
        return "Greetings dear " + input;
    }

    public static void main(String[] args) {
        String al = "Green Fox";
        System.out.println(greet(al));
    }
}
