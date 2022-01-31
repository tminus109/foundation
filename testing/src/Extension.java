import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Extension {
//    int add(int a, int b) {
//        return 5;
//    }

    int add(int a, int b) {
        return a + b;
    }

//    int maxOfThree(int a, int b, int c) {
//        if (a > b)
//            return a;
//        else
//            return c;
//    }

    int maxOfThree(int a, int b, int c) {
        return Collections.max(Arrays.asList(a, b, c));
    }

//    int median(List<Integer> pool) {
//        return pool.get((pool.size() - 1) / 2);
//    }

    int median(List<Integer> pool) {
        if (pool.isEmpty()) {
            return 0;
        } else {
            return pool.get((pool.size() - 1) / 2);
        }
    }

//    boolean isVowel(char c) {
//        return Arrays.asList('a', 'u', 'o', 'e', 'i').contains(c);
//    }

    boolean isVowel(char c) {
        return Arrays.asList('a', 'e', 'i', 'o', 'u').contains(Character.toLowerCase(c));
    }

//    String translate(String hungarian) {
//        String teve = hungarian;
//        int length = teve.length();
//        for (int i = 0; i < length; i++) {
//            char c = teve.charAt(i);
//            if (isVowel(c)) {
//                teve = String.join(c + "v" + c, teve.split("" + c));
//                i += 2;
//                length += 2;
//            }
//        }
//        return teve;
//    }

    String translate(String hungarian) {
        StringBuilder teve = new StringBuilder();
        for (int i = 0; i < hungarian.length(); i++) {
            char c = hungarian.charAt(i);
            if (isVowel(c)) {
                teve.append(c).append("v").append(c);
            } else {
                teve.append(c);
            }
        }
        return teve.toString();
    }
}
