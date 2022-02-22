Add updating function

Work on the same project.
Add a new column to your view table with "edit" text.
Make it clickable.
Extend the controller class with two different methods (GET, POST) mapping to /{id}/edit.
The goal is to edit the clicked item on a redirected editing page.
The edit page should be a simple form.
The user should be able to edit the name of the todo item, and the status of urgent and done.
Then the new object should be passed back and saved.
One method should GET the object and send to view page to set its properties.
The other method should POST it to the database.
Here you should think about the process like find(the)One object,
set its new data and save (POST) to the database.
Don't forget to specify the id in the template when you create the 'edit' link.
After the user edited the todo, the list page should appear again.
