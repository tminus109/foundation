package sharpie;

import java.util.List;

public class SharpieSet {
    List<Sharpie> sharpieList;

    void add(Sharpie sharpie) {
        sharpieList.add(sharpie);
    }

    int countUsable() {
        int usableSharpieCount = 0;
        for (Sharpie sharpie : sharpieList) {
            if (sharpie.inkAmount > 0) {
                usableSharpieCount++;
            }
        }
        return usableSharpieCount;
    }

    void removeTrash() {
        for (int i = 0; i < sharpieList.size(); i++) {
            if (sharpieList.get(i).inkAmount <= 0) {
                sharpieList.remove(sharpieList.get(i));
            }
        }
    }
}
