package before;

public class Mentor extends Person {
    String level;

    Mentor(String name, int age, String gender, String level) {
        super(name, age, gender);
        this.level = level;
    }

    Mentor() {
        super();
        this.level = "intermediate";
    }

    @Override
    void getGoal() {
        System.out.println("My goal is: Educate brilliant junior software developers.");
    }

    @Override
    void introduce() {
        System.out.println("Hi, I'm " + name + " a " + age + "-year-old " + gender
                + " " + level + " mentor.");
    }
}
