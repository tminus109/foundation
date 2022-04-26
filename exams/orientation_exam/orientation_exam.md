Tinder Clone

You will create a web page where you can register your profile
and swipe random profiles (one at a time).

Highlights:

- It has a frontend which can render a register and a profile page.
- It has a backend which can store the registered user and the swipes of the user.

Register page:

GET `/`

- Should render the HTML for the register page.
- It should have:
    - a heading with the title
    - a form for the registration with inputs for:
        - username
        - select for the gender
        - age
        - description
- The form should be sent to the POST `/register` endpoint.

POST `/register`

- Should receive the registration data.
- Should check if the username is already taken.
- If taken, render the register page with an error message after the title.
- If not taken:
    - Save the user into the database.
    - Redirect to the GET `/profile` endpoint with the `userid` as a query parameter.

Swiping page:

GET `/profile`

- It should have:
    - A title containing the `current` user's name.
    - A heading with the name of the random user profile.
    - A smaller heading with the age and the gender.
    - A paragraph with the description.
    - A form for swiping containing:
        - Two hidden inputs for the `current` user's id, and the random `other` user's id.
        - A direction preferably using radio buttons, but select is good too.
- The endpoint should accept a `userid` as a request query parameter.
    - If no `userid` is provided redirect to the `/` endpoint to display the register page.
- Should find that user, and pass it to the view as `current`.
- Should get another random user from the database and pass it as `other`.
    - A totally random, no need for checking anything at all.
    - Current and other can be the same, then the user can swipe itself, awesome!

POST `/swipe`

- Should store the swipe into the database.
    - Containing the current user's id, the other user's id and the swipe direction.
    - If there is a swipe present with the given ids: overwrite it.
    - Otherwise, create a new one.
- Should redirect back to the `/profile` endpoint with the current user's id as parameter.

PUT `/swipe`
- The new swipe data should be in the request's body in JSON format,
  this is how we will be able to modify it:

  {
    "currentUserId": 2,
    "randomUserId": 7,
    "swipeDirection" : "left"
  }

- If there is no swipe data stored with the given id-s: it should return with `404`.
- If the direction is not valid it should respond with `422` status code.
- Otherwise, update the swipe data and respond with `202` status code.
- Valid directions values are left and right.

Question:

Given the following table named `apprentices`:

| id | name           | cohort_id |
|:---|:---------------|:----------|
| 1  | Benedek Mihály | 1         |
| 2  | Jana Jechová   | 2         |
| 3  | Oldřich Dostál | 1         |
| 4  | Bo Tsai        | 2         |
| 5  | Barta Ema      | 3         |
| 6  | Chan Juan Yeh  | 3         |

And given the following table named `cohorts`:

| id | name    |
|----|:--------|
| 1  | Vulpes  |
| 2  | Velox   |
| 3  | Lagopsu |

- Write an SQL statement to update the `Lagopsu` to `Lagopus`.
- Write an SQL statement to insert `Doris D. Steves` to the `Vulpes` cohort.

UPDATE cohorts SET name = "Lagopus" WHERE id = 3;
INSERT INTO apprentices VALUES (7, "Doris D. Steves", 1);
