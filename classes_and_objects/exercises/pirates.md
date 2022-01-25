Create a Pirate class.

You can add other fields and methods yet, you must have these methods:

drinkSomeRum() - intoxicates the Pirate by one.
howsItGoingMate() - when called, the Pirate replies:
if drinkSomeRun() was called less than 4 times:
"Pour me anudder!" else: "Arghh, I'ma Pirate. How d'ya d'ink its goin?".
Then the pirate passes out and sleeps it off (gets rid of the intoxication).

If you manage to get this far, then you can try to do the following:

brawl(Pirate) - where pirate fights another pirate (if both of them are alive).
die() - this kills off the pirate. When a pirate is dead, every method simply results in:
"He's dead".

And if you get that far...

Create a Ship class:

The Ship stores Pirate instances in a list as the crew and has one captain who is also a Pirate.
When a ship is created it doesn't have a crew.
The ship can be filled with pirates via fillShip() method:
fills the ship with a random (maximum 113) number of pirates.
Ships should be represented in a nice way on command line.
Ships should have a method to battle other ships: ship.battle(otherShip).
The ship having higher calculated score wins.
The winning captain and crew has a party: everyone drinks a random number of rum :)

BattleApp:

Create a BattleApp class with a main method.
Create 2 ships, fill them with pirates.
Have a battle!

Armada:

Create an Armada class.
Contains a list of Ship.
Have an armada.war(otherArmada) method where two armadas can engage in war.
Whichever armada gets to the end of its ships loses the war.

WarApp:

Create a WarApp class with a main method.
Create 2 armadas, fill them with ships.
Have a war!
