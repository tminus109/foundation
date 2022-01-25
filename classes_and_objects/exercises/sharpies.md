Create a Sharpie class.

We should know the followings about each sharpie:

- color (which should be a string),
- width (which will be a number),
- inkAmount (another number).

We need to specify the color and the width at creation.
Every sharpie is created with a default inkAmount value: 100.

We can use() the Sharpie objects: using it decreases inkAmount by 10.

Create a SharpieSet class.

It contains a list of Sharpie, named listOfSharpies.
It has a method that adds a new Sharpie to the set: add(sharpie).
It has a method that returns the number of usable Sharpies:
countUsable() -> sharpie is usable if it contains ink.
It has a method that removes all unusable Sharpies: removeTrash().
