Bank of Simba

Nants ingonyama bagithi baba!!!

Showing one Account:

We are creating a Lion King based bank account application today.
For this, create a BankAccount class in your model package/folder.
Add the fields (properties in C#) name, balance, animalType in it.
In your controller, create the first endpoint called /show.
Instantiate a new BankAccount("Simba", 2000, "lion").
Java: Add this BankAccount to the model.
Create a template where you show the fields of the BankAccount.

Formatting the balance:

Format the previous exercise's template to show balance with 2 Decimals (2000.00).
Add a currency, e.g.: $, next to the balance (2000.00 $).

HTMLception:

Create an endpoint which displays the following String:
"This is an <em>HTML</em> text. <b>Enjoy yourself!</b>"
Add this String to your new template.
Java: as both th:utext and th:text, as well.
C#: using both @ and @Html.Raw(), as well.
Check the output.

Filling multiple accounts:

Create a new endpoint and a template also.
Create a List of BankAccounts and fill them with 4-5 characters (from the movie).
Show us the elements of your List in a table.

Extending more:

Add a new column to your template, where you show the index of each element in your List.
Java (not available in C#):
In an iteration, if you use your variable name + "Stat" (e.g. ${bankAccountStat.})
there will be various new methods available for you.
Find the one which helps you to display the index of the elements in this iteration.

Marking kings:

Add a new column to your template where you show us that the owner of the BankAccount is a King.
If he is a King, make the text look shiny: add some design according to your taste :)

Extending again:

Add a new column to your template where you show us with the help of switch conditions
that the owner of the BankAccount is a Bad Guy, or a Good One.

Different aspects:

Be a Good One yourself, as well and correct that last part of the exercise you just finished,
but now without switch statements! :)

Prettify:

Now we have a template showing all the information about our BankAccounts and their owners.
Pimp this template a little to look more shiny ;)

Raise the Balance (and the King):

Create a custom form with a button, which can raise the balance of any animal by 10.
If the selected animal is a King, the increment is 100.

Creating new Bank Accounts:

Add new row of input elements to our previously created template.
With the help of these elements make sure, that the user can add new BankAccounts to our List.
