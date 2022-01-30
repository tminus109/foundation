We are going to represent a Zoo. So we need an abstract Animal class:

- it has a name and an age field,
- it has getName() and breed() methods.

Have we got all fields and methods we should? What about gender? Any other?
Write down at least 3 fields and/or methods that should be included in Animal.

Let's think about the kinds of animals: Mammals, Reptiles, Birds, etc.
We need to define specific fields and methods for each.
For example every Bird breed() from an egg, doesn't matter if it is a penguin or a parrot.
Write down at least 2 of fields and/or methods that are common in each kind.
Most of the Reptiles breed() by laying eggs too, it is common with Birds.

Create the project and the classes above.
The Zoo app should be invoked by the following example code, outside the zoo package:

public class Zoo {
public static void main(String[] args) {
    Reptile reptile = new Reptile("Crocodile");
    Mammal mammal = new Mammal("Koala");
    Bird bird = new Bird("Parrot");
    System.out.println("How do you breed?");
    System.out.println("A " + reptile.getName() + " is breeding by " + reptile.breed() + ".");
    System.out.println("A " + mammal.getName() + " is breeding by " + mammal.breed() + ".");
    System.out.println("A " + bird.getName() + " is breeding by " + bird.breed() + ".");
    }
}

We expect the following output:

How do you breed?

A Crocodile is breeding by laying eggs.
A Koala is breeding by giving birth to live young.
A Parrot is breeding by laying eggs.
