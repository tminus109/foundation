Add deleting function

Work on the same project.
Add a new column to your view table with the "delete" text.
Clicking on "delete" removes the todo item from the database.
Extend the controller class with a delete method mapping to /{id}/delete
to delete the clicked item.
The id of the clicked item should be read from the path.
(Java Hint: use @PathVariable long id as the method parameter.)
Use the repository to delete the todo with the id.
Don't forget to specify the id in the template when you create the "delete" button.
After the user deleted the item, the list page should appear again.
