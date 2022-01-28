Person:

Create a Person class with the following fields:
name: the name of the person,
age: the age of the person (whole number),
gender: the gender of the person (male / female)

And the following methods:
introduce(): prints out "Hi, I'm name, a age year old gender."
getGoal(): prints out "My goal is: Live for the moment!"

And the following constructors:
Person(name, age, gender)
Person(): sets name to Jane Doe, age to 30, gender to female

Student:

Create a Student class that has the same fields and methods as the Person class,
and has the following additional fields:
previousOrganization: the name of the student’s previous company / school,
skippedDays: the number of days skipped from the course

methods:
getGoal(): prints out "Be a junior software developer.",
introduce(): "Hi, I'm name, a age year old gender from previousOrganization
who skipped skippedDays days from the course already.",
skipDays(numberOfDays): increases skippedDays by numberOfDays

The Student class has the following constructors:
Student(name, age, gender, previousOrganization):
beside the given parameters, it sets skippedDays to 0,
Student(): sets name to Jane Doe, age to 30, gender to female,
previousOrganization to The School of Life, skippedDays to 0

Mentor:

Create a Mentor class that has the same fields and methods as the Person class,
and has the following additional fields:
level: the level of the mentor (junior / intermediate / senior),

methods:
getGoal(): prints out "Educate brilliant junior software developers.",
introduce(): "Hi, I'm name, a age year old gender level mentor."

The Mentor class has the following constructors:
Mentor(name, age, gender, level),
Mentor(): sets name to Jane Doe, age to 30, gender to female, level to intermediate

Sponsor:

Create a Sponsor class that has the same fields and methods as the Person class,
and has the following additional fields:
company: name of the company,
hiredStudents: number of students hired,

method:
introduce(): "Hi, I'm name, a age year old gender who represents company
and hired hiredStudents students so far.",
hire(): increase hiredStudents by 1,
getGoal(): prints out "Hire brilliant junior software developers."

The Sponsor class has the following constructors:
Sponsor(name, age, gender, company): beside the given parameters,
it sets hiredStudents to 0,
Sponsor(): sets name to Jane Doe, age to 30, gender to female,
company to Google and hiredStudents to 0

Test input:

ArrayList<Person> people = new ArrayList<>();
ArrayList<Student> students = new ArrayList<>();
ArrayList<Mentor> mentors = new ArrayList<>();
ArrayList<Sponsor> sponsors = new ArrayList<>();

Person mark = new Person("Mark", 46, "male");
people.add(mark);
Person jane = new Person();
people.add(jane);
Student john = new Student("John Doe", 20, "male", "BME");
students.add(john);
Student student = new Student();
students.add(student);
Mentor gandhi = new Mentor("Gandhi", 148, "male", "senior");
mentors.add(gandhi);
Mentor mentor = new Mentor();
mentors.add(mentor);
Sponsor sponsor = new Sponsor();
sponsors.add(sponsor);
Sponsor elon = new Sponsor("Elon Musk", 46, "male", "SpaceX");
sponsors.add(elon);
student.skipDays(3);

for (int i = 0; i < 5; i++) {
elon.hire();
}

for (int i = 0; i < 3; i++) {
sponsor.hire();
}

for (Person person : people) {
person.introduce();
person.getGoal();
}

for (Student person : students) {
person.introduce();
person.getGoal();
}

for (Mentor person : mentors) {
person.introduce();
person.getGoal();
}

for (Sponsor person : sponsors) {
person.introduce();
person.getGoal();
}

Test output:

Hi, I'm Mark, a 46-year-old male.
My goal is: Live for the moment.
Hi, I'm Jane Doe, a 30-year-old female.
My goal is: Live for the moment.
Hi, I'm John Doe, a 20-year-old male from BME
who skipped 0 days from the course already.
My goal is: Be a junior software developer.
Hi, I'm Jane Doe, a 30-year-old female from The School of Life
who skipped 3 days from the course already.
My goal is: Be a junior software developer.
Hi, I'm Gandhi, a 148-year-old male senior mentor.
My goal is: Educate brilliant junior software developers.
Hi, I'm Jane Doe, a 30-year-old female intermediate mentor.
My goal is: Educate brilliant junior software developers.
Hi, I'm Jane Doe, a 30-year-old female who represents Google and hired 3 students so far.
My goal is: Hire brilliant junior software developers.
Hi, I'm Elon Musk, a 46-year-old male who represents SpaceX and hired 5 students so far.
My goal is: Hire brilliant junior software developers.
