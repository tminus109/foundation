Listing Todos from MySQL

From now on, we are going to extend the project, so use the same project as in
Connection with MySQL task.
Populate the "todo" table in MySQL with new Todos either in CommandLineRunner
or directly in MySQL.
Create some elements which isDone or isUrgent already.
Create table template.

Extend Listing:

Extend the listing method with a request parameter for listing the active todos
(active means !isDone) to list only those todos which are not done yet:

http://localhost:8080/todo/?isActive=true
