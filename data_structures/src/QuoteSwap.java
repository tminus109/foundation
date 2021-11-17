import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class QuoteSwap {
    public static void swapQuote(List<String> list) {
//        StringBuilder quote = new StringBuilder();
//
//        for (String s : list) {
//            if (Objects.equals(s, "do")) {
//                quote.append("cannot");
//            } else if (Objects.equals(s, "cannot")) {
//                quote.append("do");
//            } else {
//                quote.append(s);
//            }
//            quote.append(" ");
//        }
//
//        System.out.println(quote.toString().trim());

        StringBuilder quote = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("do")) {
                quote.append("cannot");
            } else if (list.get(i).equals("cannot")) {
                quote.append("do");
            } else {
                quote.append(list.get(i));
            }
            if (i < list.size() - 1) {
                quote.append(" ");
            }
        }

        System.out.println(quote);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("What", "I", "do", "create,", "I", "cannot", "not", "understand.");
        swapQuote(list);
    }
}
