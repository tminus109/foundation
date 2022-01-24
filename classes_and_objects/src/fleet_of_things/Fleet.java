package fleet_of_things;

import java.util.ArrayList;

public class Fleet {
    private final ArrayList<Thing> things;

    public Fleet() {
        things = new ArrayList<>();
    }

    public void add(Thing thing) {
        things.add(thing);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < things.size(); i++) {
            result.append(i + 1).append(". ").append(things.get(i)).append("\n");
        }
        return result.toString();
    }
}
