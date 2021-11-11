import java.util.ArrayList;

public class CandyShop {
    public static ArrayList<Object> repairSweetList(ArrayList<Object> arrayList) {
        arrayList.set(1, "Croissant");
        arrayList.set(3, "Ice cream");
        return arrayList;
    }

    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add("Cupcake");
        arrayList.add(2);
        arrayList.add("Brownie");
        arrayList.add(false);
        System.out.println(repairSweetList(arrayList));
    }
}
