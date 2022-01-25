package teachers_and_students;

public class Student {
    void learn() {
        System.out.println("The student is learning");
    }

    void question(Teacher teacher) {
        teacher.giveAnswer();
    }
}
