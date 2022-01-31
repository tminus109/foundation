Create a class which is capable of playing exactly one game of Cows and Bulls (CAB).
The player have to guess a 4-digit number.
For every digit that the player guessed correctly in the correct place, they have a “cow”.
For every digit the player guessed correctly in the wrong place is a “bull.”
If the player types a number that does not exist, that guess will not have any result.

Example: If the number to be found is "7624" and the player types "7296",
the result is: "1 cow, 2 bulls".

The CowsAndBulls object should have a random 4-digit number, which is the goal to guess.
The CowsAndBulls object should have a state where the game state is stored (playing, finished).
The CowsAndBulls object should have a counter where it counts the guesses.
The CowsAndBulls object should have a guess method, which returns the guess result.
All methods, including constructor should be tested.
