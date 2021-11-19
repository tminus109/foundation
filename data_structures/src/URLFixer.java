public class URLFixer {
    public static void main(String[] args) {
        String url = "https//www.reddit.com/r/nevertellmethebots";
        StringBuilder stringBuilder = new StringBuilder(url.replace("bots", "odds"));
        stringBuilder.insert(5, ':');
        System.out.println(stringBuilder);
    }
}
