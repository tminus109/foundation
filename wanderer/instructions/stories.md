Stories should be followed by implementation.
Completing a story means you made a little progress on the project.
Keep in mind, that you have to develop the complete board.
So when working on a specific story,
you should be able to reuse the implementation later in other parts of the board.

Draw a screen with tiles:

1. Draw a single tile.
2. Fill the screen with the tile.
3. Add wall tiles.

Place a character on it and move with key bindings:

4. Add the Hero.

Interactions:

The player should be able to move the hero by using their arrow keys.

5. Move around:

When any of the arrow keys are pressed by the user,
the hero should move to that direction.

6. Hero direction:

When the hero is moved by the arrow keys,
the hero should face the direction where he went.

7. Map boundaries:

Given the hero on any edge of the maze,
when the hero is moved by the arrow keys towards the edge,
it should not move or leave the maze, only its direction should change, if necessary.

8. Walls:

Given the hero next to a wall tile,
when the hero is moved by the arrow keys towards the wall tile, it should not move,
only its direction should change, if necessary.

Extend with different kinds of sprites.

9. Skeletons:

When the maze is rendered on the screen,
3 skeletons should be on the maze, somewhere on floor type tiles.

10. Boss:

When the maze is rendered on the screen,
a boss should be on the maze, somewhere on floor type tiles.

Create HUD, fight & board logic:

11. Stats:

Stats should appear below the maze in a white box as black strings. It should contain:

- The level of the Hero,
- The current HP (health point) of the Hero,
- The max HP of the Hero,
- The DP (defend point) of the Hero,
- The SP (strike point) of the Hero.

Like this: `Hero (Level 1) HP: 8/10 | DP: 8 | SP: 6`

12. Strike:

Characters are able to strike as detailed in the specifications.md file.

13. Battle logic:

After a hero character performed a strike the defender should strike back the same way.

14. Next area:

When the enemy with the key is killed,
the hero should enter the new level automatically.

Optional features:

15. Update sprites on moving hero:

The sprites should only move when the player moves the hero.

16. Random maze:

When maze is created the placement of walls should be random.
Make sure that all floor tiles are connected.

17. Leveling:

Add more hp / damage to the hero according to the specification.
Add more hp / damage to the monsters.
Implement random events which happen when entering the new area.

18. Monsters moving around:

Move the monsters around regardless of player moving hero or not.
Speed up their movement level by level.
