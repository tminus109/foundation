Create a pirates.Pirate class. You can add other fields and methods yet,
you must have these methods:
drinkSomeRum() - intoxicates the pirates.Pirate by one
howsItGoingMate() - when called, the pirates.Pirate replies:
if drinkSomeRun() was called less than 4 times: "Pour me anudder!"
else: "Arghh, I'ma pirates.Pirate. How d'ya d'ink its goin?". Then the pirate passes out and 
sleeps it off (gets rid of the intoxication).

If you manage to get this far, then you can try to do the following:

brawl(pirates.Pirate) - where pirate fights another pirate (if both of them are alive):
die() - this kills off the pirate. When a pirate is dead, every method simply results in:
he's dead.

And... if you get that far...

Create a pirates.Ship class:

The pirates.Ship stores pirates.Pirate instances in a list as the crew and has one captain who is also a pirates.Pirate.
When a ship is created it doesn't have a crew or a captain.
The ship can be filled with pirates and a captain via fillShip() method:
fills the ship with a captain and a random (maximum 113) number of pirates.
Ships should be represented in a nice way on command line including information about
rum consumed by the captain and its state (dead or alive) and
number of alive pirates in the crew.
Ships should have a method to battle other ships: ship.battle(otherShip).
The ship having higher calculated score wins.
The winning captain and crew has a party: everyone drinks a random number of rum :)

pirates.BattleApp:

Create a pirates.BattleApp class with a main method.
Create 2 ships, fill them with pirates.
Have a battle!

Armada:

Create an Armada class.
Contains a list of pirates.Ship.
Have an armada.war(otherArmada) method where two armada can engage in war.
It should work like merge sort,
first ship from the first armada battles the first one from the other.
The loser ship gets skipped so the next ship comes in play from the loser ship's armada,
it starts a battle with the first (not yet defeated) ship from the other armada.
Whichever armada gets to the end of its ships loses the war.
Return true if this is the winner.

WarApp:

Create a WarApp class with a main method
Create 2 armadas, fill them with ships.
Have a war!
