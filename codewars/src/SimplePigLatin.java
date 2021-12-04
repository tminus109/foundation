import java.util.Objects;

public class SimplePigLatin {
    public static void pigIt(String pig) {
        String[] pigs = pig.split(" ");
        StringBuilder pigged = new StringBuilder();

        for (int i = 0; i < pigs.length; i++) {
            if (Objects.equals(pigs[i], "!")) {
                pigged.append(pigs[i]);
            } else {
                pigged.append(pigs[i].substring(1)).append(pigs[i].charAt(0)).append("ay");
                if (i < pigs.length - 1) {
                    pigged.append(" ");
                }
            }
        }

        System.out.println(pigged);
    }

    public static void main(String[] args) {
        String pig1 = "Pig latin is cool";
        String pig2 = "Hello world !";

        pigIt(pig1);
        pigIt(pig2);
    }
}
