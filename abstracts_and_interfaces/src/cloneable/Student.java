package cloneable;

public class Student extends Person {
    String previousOrganization;
    int skippedDays;

    Student(String name, int age, String gender, String previousOrganization) {
        super(name, age, gender);
        this.previousOrganization = previousOrganization;
        this.skippedDays = 0;
    }

    Student() {
        super();
        this.previousOrganization = "The School of Life";
        this.skippedDays = 0;
    }

    @Override
    void getGoal() {
        System.out.println("My goal is: Be a junior software developer.");
    }

    @Override
    void introduce() {
        System.out.println("Hi, I'm " + name + " a " + age
                + "-year-old " + gender + " from " + previousOrganization + " who skipped "
                + skippedDays + " days from the course already.");
    }

    void skipDays(int numberOfDays) {
        skippedDays += numberOfDays;
    }
}
