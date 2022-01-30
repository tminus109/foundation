package cloneable;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student john = new Student("John", 20, "male", "BME");
        Student johnTheClone = (Student) john.clone();
    }
}
