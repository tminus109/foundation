import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TelephoneBook {
    public static void main(String[] args) {
        Map<String, String> telephoneBook = new HashMap<>();
        telephoneBook.put("William A. Lathan", "405-709-1865");
        telephoneBook.put("John K. Miller", "402-247-8568");
        telephoneBook.put("Hortensia E. Foster", "606-481-6467");
        telephoneBook.put("Amanda D. Newland", "319-243-5613");
        telephoneBook.put("Brooke P. Askew", "307-687-2982");

        System.out.println(telephoneBook.get("John K. Miller"));

        for (Map.Entry<String, String> entry : telephoneBook.entrySet()) {
            if (Objects.equals(entry.getValue(), "307-687-2982")) {
                System.out.println(entry.getKey());
                break;
            }
        }

        System.out.println(telephoneBook.containsKey("Chris E. Myers"));
    }
}
