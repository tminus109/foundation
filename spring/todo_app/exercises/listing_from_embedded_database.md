Listing Todos from embedded database

Create a Spring project with Gradle.
Add dependencies: JPA, H2, DevTools, Web, Thymeleaf, Lombok.

Create classes:
Add a Todo class with the fields:
id: long, title: String, urgent: boolean(default false), done: boolean(default false)).

Controller:
Create a new controller called TodoController which maps to /todo.
Add a public String list() method which maps to / and /list in the controller,
and returns with "This is my first Todo" string. Use the @ResponseBody annotation.
Run the application. If all works fine, then you can go ahead.

Repository:
Create a new interface which extends CrudRepository<Todo, Long>.
Inject the new repository into the controller
(since this is a very small demo application, we skip the service layer).

Put the classes into packages like: models, controllers and repositories.

Create template:
Remove @ResponseBody from the list method of the Controller.
Add the Model parameter to the list method
Make sure that the method returns the "todolist" template.
Create a new template in the src/main/resources/templates/ folder to display the Todos.

Connect to database:
Map the Todo class to the embedded database.
Use relevant annotations.
Make the id field auto-generated, incrementing value.
In the list method of the Controller use the repository to find all elements
and add them to the model as "todos" attribute.

Populate database with new Todos in the Application class:
Inject the repository.
Let the Application implement CommandLineRunner and create the run() method.
In the run() use the save() method of the repository and save a few Todos
(new Todo("I have to learn Object Relational Mapping")).
Delete the todos that you originally displayed in your HTML template
and display the new ones that are in your repository now.
Use a table for this. Show the id, title, urgent and done values for each todo.
