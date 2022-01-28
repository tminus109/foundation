Aircraft:

Create a class that represents an aircraft.
There are 2 types of aircraft: F16 and F35.
Both aircraft should keep track of their ammunition:

F16
Max ammo: 8
Base damage: 30

F35
Max ammo: 12
Base damage: 50

All aircraft should be created with an empty ammo storage.

Methods:

fight()
It should use all the ammo (set it to 0) and it should return the damage it causes;
damage is calculated by multiplying the base damage by the ammunition.

refillAmmo()
It should take a number as a parameter that represents the ammunition coming from a station.
Increase the ammo of the aircraft by the right amount.
It can't have more ammo than the parameter value or the max ammo of the aircraft.
It should return the remaining (unused) ammo.
E.g. Filling an empty F35 with 300 would completely fill the aircraft
and would return the remaining 288.

getType()
It should return the type of the aircraft as a string.

getStatus()
It should return a string like: Type F35, Ammo: 10, Base Damage: 50, All Damage: 500

isPriority()
It should return if the aircraft is priority in the ammo fill queue.
It's true for F35 and false for F16.

Carrier:

Create a class that represents an aircraft-carrier.
The carrier should be able to store aircraft.
Each carrier should have a store of ammo represented by a number.
The initial ammo should be given as a constructor parameter.
The carrier also has a health point which is also given as a constructor parameter.

Methods:

add()
It should take a new aircraft and add it to its storage.

fill()
It should fill all the aircraft with ammo and subtract the taken ammo from the ammo storage.
It should start to fill the aircraft that are priority first.
It should throw an exception if there is no ammo when this method is called.

fight()
It should take another carrier as a reference parameter and
fire all the ammo from the aircraft to it.
Subtract all the damage from the other carrier's health points.

getStatus()
It should return a string describing its, and all of its aircraft' statuses
in the following format:

HP: 5000, Aircraft count: 5, Ammo Storage: 2300, Total damage: 2280

Aircraft:

Type F35, Ammo: 12, Base Damage: 50, All Damage: 600
Type F35, Ammo: 12, Base Damage: 50, All Damage: 600
Type F35, Ammo: 12, Base Damage: 50, All Damage: 600
Type F16, Ammo: 8, Base Damage: 30, All Damage: 240
Type F16, Ammo: 8, Base Damage: 30, All Damage: 240

If the health points are 0 then it should return: It's dead Jim :(
