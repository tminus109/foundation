You'll have to simulate the video game's character selection screen behaviour,
more specifically the selection grid.

Selection Grid Layout in text:

| Ryu  | E.Honda | Blanka  | Guile   | Balrog | Vega    |
| Ken  | Chun Li | Zangief | Dhalsim | Sagat  | M.Bison |

Input:
The list of game characters in a 2x6 grid.
The initial position of the selection cursor (top-left is (0,0)).
A list of moves of the selection cursor (which are up, down, left, right).

Output:
The list of characters who have been hovered by the selection cursor after all the moves
(ordered and with repetition, all the ones after a move, weather successful or not, see tests).

Rules:
Selection cursor is circular horizontally but not vertically!
As you might remember from the game, the selection cursor rotates horizontally
but not vertically; that means that if I'm in the leftmost, and I try to go left again
I'll get to the rightmost (examples: from Ryu to Vega, from Ken to M.Bison)
and vice versa from rightmost to leftmost.
Instead, if I try to go further up from the upmost or further down from the downmost,
I'll just stay where I am located (examples: you can't go lower than lowest row:
Ken, Chun Li, Zangief, Dhalsim, Sagat and M.Bison in the above image.
You can't go upper than highest row:
Ryu, E.Honda, Blanka, Guile, Balrog and Vega in the above image).

Test:
For this easy version the fighters grid layout and the initial position will always be
the same in all tests, only the list of moves change.
Notice: changing some of the input data might not help you.

Examples:

1.
fighters = [
["Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"],
["Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"]
]
initial_position = (0,0)
moves = ['up', 'left', 'right', 'left', 'left']

Result:
['Ryu', 'Vega', 'Ryu', 'Vega', 'Balrog']
- the characters I've been hovering over with the selection cursor during my moves.
Notice: Ryu is the first just because it "fails" the first up. See test cases for more examples.

2.
fighters = [
["Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"],
["Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"]
]
initial_position = (0,0)
moves = ['right', 'down', 'left', 'left', 'left', 'left', 'right']

Result:
['E.Honda', 'Chun Li', 'Ken', 'M.Bison', 'Sagat', 'Dhalsim', 'Sagat']

https://www.codewars.com/kata/5853213063adbd1b9b0000be
