public class TodoPrint {
    public static void main(String[] args) {
        String todoText = " - Buy milk\n";
        String line0 = "My todo:";
        String line1 = " - Download games";
        String line3 = " - Diablo";
        int indent = 3;
        StringBuilder stringBuilder = new StringBuilder(todoText);
        stringBuilder.insert(0, line0 + "\n");
        stringBuilder.insert(stringBuilder.length(), line1 + "\n");
        stringBuilder.insert(stringBuilder.length(), line3.indent(indent));
        System.out.println(stringBuilder);
    }
}
