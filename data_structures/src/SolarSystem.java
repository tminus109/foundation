import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolarSystem {

    public static List<String> putSaturn(List<String> list) {
        List<String> correctList = new ArrayList<>(list);
        correctList.add(5, "Saturn");
        return correctList;
    }

    public static void main(String[] args) {
        List<String> planetList = Arrays.asList("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Uranus", "Neptune");
        System.out.println(putSaturn(planetList));
    }
}
