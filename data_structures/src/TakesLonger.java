public class TakesLonger {
    public static void main(String[] args) {
        String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";
        String substring = "always takes longer than ";
        StringBuilder stringBuilder = new StringBuilder(quote);
        stringBuilder.insert(quote.indexOf("It") + 3, substring);
        System.out.println(stringBuilder);
    }
}
