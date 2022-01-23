public class DivideByZero {
    public static void main(String[] args) {
        divideTen(3);
        divideTen(0);
        divideTen(-1);
    }

    public static void divideTen(int n) {
        try {
            System.out.println(10 / n);
        } catch (Exception e) {
            System.out.println("fail");
        }
    }
}
