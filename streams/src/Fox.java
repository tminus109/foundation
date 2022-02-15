public class Fox {
    String name;
    String color;
    int age;

    public Fox(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Fox[" + age + ", " + color + ", " + name + "]";
    }

    public String getColor() {
        return color;
    }
}
