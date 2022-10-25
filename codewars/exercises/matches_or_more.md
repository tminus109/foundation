"Hello Traveler. I wanna play a game".

There is a game called 23 Matches.
Rules: there are 23 matches on the table. Each turn a player takes 1, 2 or 3 matches away.
Player who takes the last match loses.
This is a generalized version of the game.
Here we have X matches, and we can take up to Y matches away each turn.

Example: X = 13, Y = 4

There are X = 13 matches on the table.
Player 1 takes 1 match -> 12 left on the table.
Player 2 takes 4 matches -> 8 left on the table.
Player 1 takes 2 matches -> 6 left on the table.
Player 2 takes 3 matches -> 3 left on the table.
Player 1 takes 2 matches -> 1 left on the table.
Player 2 takes last match.
Player 2 loses.

You're about to write a BOT to compete with my bot.

To do this, implement function createBot/create_bot which accepts two arguments:

X - initial number of matches on the table (20 <= X <= 1000)
Y - max number of matches to be taken away each turn (2 <= Y <= 19)

Your function must return an object of the following structure:

//example bot:

let myBot = {
name: "Optional name as string",
makeMove: matchesStillOnTable => matchesToTake
}

Your bot will always start the game. The game is always winnable for your bot - there are
no cheap tricks or edgy corner cases.

https://www.codewars.com/kata/5a9dbc735ee396ef590001de
