    Introduction:

Create a new Spring Boot project with Gradle.
Dependencies: Web, Thymeleaf.
Optional dependencies: Lombok, DevTools.

Create an index.html file in the src/main/resources/templates/ folder.
Reproduce assets/index.png.
Download the green_fox.png.
Start your application, navigate to localhost:8080.
If it works, then you are good to go.

Create a MainController.class file where you will store all your navigation routes.
Move your html file to src/main/resources/templates folder.
Create a / route.
Fix the index.html file so that it works.
Restart your application, navigate to localhost:8080.
If it works then you are good to go.

Login Page:

We need to create a login page in order to find our pet or to generate a new one.
Create login.html and reproduce the assets/login.png page.
The input field should be a form and should send the value of name field of the Fox.class
(for further explanations see below).
Create 2 /login endpoints (GET and POST).
GET method should render the login.html.
POST method should receive name value, then it should redirect to the main page,
with the value of the @RequestParam (/?name=Karak).
From now on every endpoint should require this @RequestParam (by default it is required).

Information Page:

Create a Fox.class.
It should represent a virtual fox.
It should have at least the followings: name, list of tricks, food and drink.
Consider using more classes or enums.
Add a new Fox (created with the received name) to a list of Foxes.
Set any initial values for food and drink too.
Find the actual fox based on the name and send it to the template model.
Use Thymeleaf to replace the data.
If the fox does not know any tricks yet, display a message instead of an empty list.
If the fox's name is Mr. Green, eats salad, drinks water and knows 0 tricks,
the updated information view should represent that.

Nutrition Store:

Create a /nutritionStore route.
Create the nutrition store view's template.
Do not forget to add this to the menu on the other views.
Here you should be able to change the fox's food and drink.
You might need additional routes to achieve this.
When the button is pressed it should redirect to the information page.
Optional: the current food and drink are selected by default.

Trick Center:

Create a /trickCenter route.
Create the trick center view's template.
It should list the tricks.
Feel free to add your own tricks.
One trick can only be learned once.
Optional: do not list the tricks that have been learned already.
Optional: if all the tricks have been learned, display a message instead of the dropdown.

Optional - Action History:

Create an /actionHistory route.
Here you should display all the actions that have been made (e.g.: food change).
If no actions have been made yet, display a message.
Create the action history view's template.
Display the five latest actions to the information page.
Upgrade the information view.
