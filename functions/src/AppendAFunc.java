public class AppendAFunc {
    public static String AppendA(String typo) {
        return typo += "a";
    }

    public static void main(String[] args) {
        String typo = "Chinchill";
        System.out.println(AppendA(typo));
    }
}
