package teachers_and_students;

public class Teacher {
    void giveAnswer() {
        System.out.println("The teacher is answering a question");
    }

    void teach(Student student) {
        student.learn();
    }
}
