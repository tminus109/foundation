Create a Sharpie class.

We should know the followings about each Sharpie:

- color (which should be a string),
- width (which will be a number),
- inkAmount (another number).

We need to specify the color and the width at creation.
Every Sharpie is created with a default inkAmount value: 100.

We can use() the Sharpie objects: using it decreases inkAmount by 10.

Create a SharpieSet class.

It contains a list of Sharpie, named sharpieList.
It has a method that adds a new Sharpie to the set: add(sharpies).
It has a method that returns the number of usable Sharpies:
countUsable() ->Sharpie is usable if it contains ink.
It has a method that removes all unusable Sharpies: removeTrash().
