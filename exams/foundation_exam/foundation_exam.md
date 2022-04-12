Getting Started:

Fork this repository under your own account.
Clone your forked repository to your computer.
Create a .gitignore file so generated files won't be committed.
Commit your progress frequently and with descriptive commit messages.
All your answers and solutions should go in this repository.
Take care of style guide.
Take care of the naming of classes, fields, variables, files, etc.


Keep in mind:

You can use any resource online, but please work individually.
Don't just copy-paste your answers and solutions, use your own words instead.
Don't push your work to GitHub until your mentor announces that the time is up.


Exercises:

Word reverser:

Create a function that takes a sentence as an input, reverses the letters in every word
(but not reverses the word order in the sentence), and returns the sentence with the
reversed words. You shouldn't care about upper or lower case letters.
Write at least 2 different unit test cases.

Example Input:

"lleW ,enod taht saw ton taht drah"

Output:

"Well done, that was not that hard"


Weekly feedback evaluator:

Write a method which can read and parse a file containing information about weekly feedback
from apprentices about a mentor.
The mentor is rated in 4 different metrics, those are respectively
(matReview, presSkills, helpfulness, explanation) separated with 1 space:

- m = matReview
- p = presSkills
- h = helpfulness
- e = explanation

- m p h e // this is just an info line which is not in the actual file
- 1 3 5 3 // this line is an answer from an apprentice
- 2 3 4 3 // this is another response ...

The method should return a map/dictionary containing the average rating (in each metric)
of the mentor.

Example: responses.txt.

Output:

{
"matReview": 2.25,
"presSkills": 4.0, // or 4 is fine as well
"helpfulness": 4.5,
"explanations": 3.75
}


Video Library:

You are going to create a Video Library where the guests can borrow videos available
in the database.

Video:

The video has title, director, release year and price
(these are the basic data that must be set when the video is created),
the number of guests who have ever borrowed the video,
and also if the video is borrowed currently.

There are two types of video:

- GrayScale: costs $6.99
- Colored: costs $3.99

It should have a toString() method which returns information about the video itself.
For example: Titanic by James Cameron from 1997 - borrowed 1 time(s).

It should have a copy() method.
The GrayScale video shall throw an error/exception with the message:
The Police will find you soon.
The Colored video shall return a clone of itself (a new object with the same basic data).

Guest:

Every guest should have a name and an address and may have a video.
The guest is able to borrow exactly one Video at one time.

It has a toString() method which gives information about the currently booked video.
For example: Jon Doe is currently borrowing the Titanic.
For example: Jon Doe is not borrowing anything currently.

It has a steal() method which creates and returns a copy of the borrowed video (if any).
If there is no video borrowed, it shall print: There is no video available to steal.

VideoStore:

It has a list of registeredGuests and a list of videos.

It has an addGuest() method where a guest is added to the store, pass a guest as an argument,
do not have a static guest inside this method. We should be able to add any guest we want.

It has an addVideo() method where a video is added to the store, pass a video as an argument,
do not have a static video inside this method. We should be able to add any videos we want.

It has a borrow() method where you can borrow videos by a guest.
It takes two parameters: guest and video.
It throws error/exception with descriptive message if the following happens:
- the guest already has a video borrowed,
- the video is currently not available.
  Otherwise, sets the video status to "borrowed", assigns the video to the guest.

It has a returnVideo() method where you can return the video back to the store.
It takes one parameter: guest.
It increases the videos borrowing number if the guest has a video.
It changes the video status to "not borrowed".
It takes the video away from the guest.

It has a getMostOftenBorrowed() method which returns the most often borrowed video.

It has a toString() method which gives information about the available videos
and the registered guests.
For example: The store has 0 video(s) available right now and 1 guests registered.
For example: The store has 1 video(s). available right now and 1 guests registered.


Command line exercise:

Take a look at this directory structure:

computer-shop
|--desktop
|   |--.git
|   |--instock
|   |   └--summary.csv
|   └--in-transit
|       └--summary.csv
└--laptop
|--in-stock
└--in-transit
└--summary.csv

Your task is to write commands in the correct order from the directory given below.
Do it with the least commands without chaining them together.

Assume that the following file is currently in the staging area:

- desktop/instock/summary.csv
- desktop/in-transit/summary.csv

Your current directory is computer-shop/.

Remove every file from the staging area: git rm --cached . (as long as desktop is the git repository)
Rename desktop/instock/ to desktop/in-stock/: mv desktop/instock desktop/in-stock
Delete the last 2 lines from desktop/in-transit/summary.csv: ?
Commit the changes: git add -A | git commit -m "commit message"
Change the laptop directory into a Git repository: cd laptop | git init (unless desktop is a git repository already)
Get the first 5 lines from desktop/in-stock/summary.csv and redirect it to laptop/in-stock/summary.csv: ?
