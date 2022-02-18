Basic Webshop

Features:

The webshop stores ShopItems with at least 4 fields (properties in C#)
like name, description, price, quantityOfStock.
It can list the items in a nice table.
It contains basic links for filtering:
- List only available,
- Order by the cheapest first,
- List only those what contain "nike" in the name or description,
- Show the average of the stock,
- Show the most expensive available item's name.

Stories:

GET /webshop
Create the endpoint and display "Hello World" at your localhost in the browser.

Navigation & Header:

Create the basic HTML structure (as a template, check the Language dependent information,
if not sure where to put it).
Create the heading and the links.
Style them accordingly in the styles.css file.

ShopItem:

Create a data structure for storing the ShopItems.
Have a predefined list of items in your controller.
You can initialize the list and add some shop items in the constructor of the controller.

Display the Shop Items in a table:

Display all fields of the shop item in a different column.
For this, you can pass the whole list to your HTML template in your controller method.
Then you can use a foreach in the template to create a row for each item.
(If not sure, check the Language dependent information how to do this.)

GET /only-available:

Create an endpoint /only-available.
This endpoint should use the same template as before.
Filter out those, that are 0 in stock.
Pass the filtered shop items to the template.
Set the first link to point to this in your template.

GET /cheapest-first

Same thing as before, just order by price ascending.

GET /contains-nike

Filter out those that contain nike in the name or the description.

GET /average-stock:

Create another template with the same structure.
Instead of the table, display a header with the average of the stock quantity.

GET /most-expensive:

Using the same template as before.
Select the most expensive shop item that is available.
Display its name.

Search bar:

Create the search bar in both of your templates.
Set the method to POST and the action to /search.
Name the input field.

POST /search:

Filter only those that contain the searched keyword in the name or in the description.
Display them in the table.

Optional:

Extend ShopItem with a new field: type.

New filters:

Filter by type.
Display the prices in Euro or Forint.
Filter by price.
Keep in mind that only one filter should work at a time.

Endpoints:

GET /more-filters:

Create a new HTML like above, but this time transform the headers to links.
The My Shop should take you to the /webshop endpoint
The More >> should take you to the /more-filters endpoint.

GET /filter-by-type/{type}:

Filter out those, that type is in the url.
Use this endpoint for the 3 links in the navigation bar.

GET /price-in-eur:

The EURO link should display the prices in euro.

GET /price-in-original:

The ORIGINAL CURRENCY should display the prices in the original currency.

POST /filter-by-price:

The search bar has 3 buttons:

Above: After pressing, it should only display those which are above the price
given in the input field.
Below: After pressing, it should only display those which are below the price
given in the input field.
Exactly: After pressing, it should only display those which are exactly the price
given in the input field.
