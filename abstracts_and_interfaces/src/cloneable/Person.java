package cloneable;

public class Person implements Cloneable {
    String name;
    int age;
    String gender;

    Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    Person() {
        this.name = "Jane Doe";
        this.age = 30;
        this.gender = "female";
    }

    void introduce() {
        System.out.println("Hi, I'm " + name + ", a " + age + "-year-old " + gender + ".");
    }

    void getGoal() {
        System.out.println("My goal is: Live for the moment!");
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
