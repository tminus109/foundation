Peer to Peer Chat application
Write a chat application that connects to other peer applications.

Tasks:


Set up the environments:

Use environment variables.

About environment variables: ttps://www.youtube.com/watch?v=pjh9rU9h22Q
Reading environment variables in java: https://docs.oracle.com/javase/tutorial/essential/environment/env.html
Try your environment variables on heroku as well: https://devcenter.heroku.com/articles/config-vars

Create a CHAT_APP_DB_URL environment variable that stores the url to the local or remote database.
Create a CHAT_APP_DB_USERNAME environment variable that stores the username to the local or remote database.
Create a CHAT_APP_DB_PASSWORD environment variable that stores the password to the local or remote database.

Development environment:
- Host: localhost
- Database: a local SQL database

Production environment:
- Host: Heroku or Azure
- Database: Postgre database on Heroku or SQL Server on Azure


Main page:

Create a main page containing a heading that is accessible from the / route.


Logging:

Each http request should be logged to the standard out (System.out.println() in Java).
Also, if any error has happened in the routes it should log the error to the standard error (System.err.println() in Java.

A log message should have the following fields:

- Path: The path of the endpoint like: /.
- Method: The method of the endpoint like: GET.
- Date and Time: It should print the date in a format like this: 2017-05-16 21:47:19.040.
- Log Level: INFO on http requests and ERROR on any occurred error.
- Request Data: It should log all the request params from the endpoint.

The log should look like this: 2017-05-16 21:47:19.040 INFO Request /message POST text=apple

The logs should be configurable by an environment variable called CHAT_APP_LOG_LEVEL.
If this variable is set to ERROR it should only print the error messages,
any other cases it should print both error and info level messages.

Read the logs in Heroku: https://devcenter.heroku.com/articles/logging


[comment]: <> (Client id, Peer address:)

[comment]: <> (Each application should store a unique id &#40;string&#41;, that is different from any other.)
[comment]: <> (Please use your GitHub username for this purpose.)

[comment]: <> (Each application should store an IP address of another application that it will connect to.)
[comment]: <> (This is the address where your application forwards the created or received chat messages.)
[comment]: <> (Both of the values should be loaded from the following environment variables: CHAT_APP_UNIQUE_ID, CHAT_APP_PEER_ADDRESS)


Register page:

Create a new page at the /register path.

If the "Enter" button is clicked, it should create a new user in the database and redirect to the main page.
If the username is not specified, it should show an error on the top of the page: "The username field is empty".

[comment]: <> (At this point we handle only one user for the application :)

The Register page should redirect to the Main page if 1 user is present in the database.
The Main page should redirect to the Register page if 1 user is not present in the database.


Main page:

Create a form under the title that consists a text input and an update button.

The text input should store the username of the user.
If the update button is clicked, then it should update the username in your database
(so we still have just 1 user in the database that you can modify).
After the update, the application should stay or redirect back to this Main page.

If the username is not specified it should show an error on the top of the page: "The username field is empty".


Save new message:

Add a list of messages to your main page. Each message should have a username and a text field.

The page should have a default message in its list:
- username: App
- text: Hi there! Submit your message using the send button!

All the other messages should appear under this message.
Under the messages there should be a form that can add a new message.
If the send button is clicked, it should store a new message in the database, and it should show up in the list.

Each message should have a stored:
- username
- text
- timestamp, when the message was created,
- random generated id (between 1000000 - 9999999).


Receive new message:

Create a REST POST endpoint called /api/message/receive.

It should expect a JSON input:

{
"message": {
"id": 7655482,
"username": "EggDice",
"text": "How you doin'?",
"timestamp": 1322018752992
},
"client": {
"id": "EggDice"
}
}

(Where the client id is the identifier of the application client detailed in the next story).

When the endpoint is requested, it should save the message into the database.
Then it should respond with a simple JSON object and a 200 status as response:

{
"status": "ok"
}

If any of the fields are missing, it should respond with 401 as status and a JSON object like this:

{
"status": "error",
"message": "Missing field(s): message.timestamp, client.id"
}

[comment]: <> (Add a refresh link to your application: refresh)


Create automated tests:

Please, test your endpoint using MockMvc.


Broadcast new message:

When the user posts a new message on the page the application should broadcast that message to the stored address.
It should send an HTTP request to /api/message/receive endpoint on the configured address.

The request should send your client id (stored in CHAT_APP_UNIQUE_ID) and the message object.

[comment]: <> (Either you can use the RestTemplate object which is already included in spring-boot or the Retrofit library)
[comment]: <> (what we previously tried out on gradle day.)


Forward received message:

When the application receives a message from a peer, and the message is not originally broadcast by the application,
then it should forward the message to the stored peer (CHAT_APP_PEER_ADDRESS) by submitting an HTTP request
to its /api/message/receive endpoint. All message and client details should be the same as the received message.
If the message was broadcast originally by the application, then it should not forward the message again.


Try it with your fellows:

Find one of your classmates and connect your deployed applications by setting the IP addresses, in the environment variables.
If it works, invite more and more peers to the circle.
The goal is to make a circle from each of the applications written by the Green Foxers.


Optional Tasks:


Better looking Main page: make the main page pretty using bootstrap.


Better looking Register page: ake the Register page pretty using bootstrap.


Feel free to add a specific header image for your Register page (and even your messages page).


[comment]: <> (Auto refresh:)

[comment]: <> (Make your chat messages appearing every 5-10 seconds.)
[comment]: <> (Check out some javascript solution for auto refresh and copy it to your project.)


Auto refresh Vol 2:

The refreshing every now and then is not the perfect solution, the page should refresh exactly when a new message arrives.
In order to do that, you need to have a direct connection between your server and every single browser
that currently has the page open (aka client).
We can do that with websockets (this is exactly how web based chat applications work).

Check it out:
Java Spring: https://spring.io/guides/gs/messaging-stomp-websocket/


List of users:

Create a list on the main page that shows all the usernames that occurred in the messages.

[comment]: <> (All the usernames should be marked that has written a message less than 10 minutes ago.)
