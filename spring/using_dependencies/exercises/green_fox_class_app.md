Green Fox Class App:

Create a controller with a few endpoints where Green Fox can manage their students.

First steps:

Have a main page at /gfa.
This should contain links to all available pages.
list all students at first. List all students at /gfa/list.
It should display an unordered list with all the students.
Use the StudentService below, as a dependency for your controller.

@Service
public class StudentService {
private List<String> names;

public StudentService() {
names = new ArrayList<>();
names.add("Sanyi");
names.add("Lilla");
names.add("John");
}

public List<String> findAll() {
return names;
}

public void save(String student) {
names.add(student);
}
}

Adding new students:

Extend the links with: add new Student.
Add new student at new /gfa/add endpoint.
It should contain a form with an input for the new student's name.
Send the form to the POST /gfa/save endpoint,
where you can use the service's save() method to save it.

Add student count to main page:

Before the links, have a header containing the current user count.
Extend the service with a count() method.

Add a student checker page at /gfa/check:

With a form for a name.
Submitting a name, the app can display if the student is already in the list.
Add a link to the main page.
