Build a hero based walking on tiles and killing monsters type of board.
The hero is controlled in a maze using the keyboard.
Heroes and monsters have levels and stats depending on their levels.
The goal is to reach the highest level
by killing the monsters holding the keys to the next level.

Plan your work.
Fork this repository (under your user).
Clone the repository to your computer.
Go through the technical details.

Launching the board is running the `app.GameFrame` class' `main()` method.

Here's an example, it contains a big drawable canvas with one image painted on it,
and handling pressing keys, for moving your hero around.
Be aware, that these are just all the needed concepts put in one place,
you can separate anything anyhow.


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent implements KeyListener {
int testBoxX;
int testBoxY;

public Board() {
testBoxX = 300;
testBoxY = 300;
}

Set the size of your draw gameFrame:

setPreferredSize(new Dimension(720, 720));
setVisible(true);

@Override
public void paint(Graphics graphics) {
super.paint(graphics);
graphics.fillRect(testBoxX, testBoxY, 100, 100);
}

Here you have a 720x720 canvas.
You can create and draw an image using the class below e.g.:

PositionedImage image = new PositionedImage("your_image.png", 300, 300);
image.draw(graphics);

public static void main(String[] args) {

Here is how you set up a new window and adding our gameFrame to it:

JFrame frame = new JFrame("RPG Game");
Board gameFrame = new Board();
frame.add(gameFrame);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
frame.pack();

Here is how you can add a key event listener.
The gameFrame object will be notified when hitting any key
with the system calling one of the below 3 methods:

frame.addKeyListener(gameFrame);

Notice (at the top) that we can only do this
because this Board class (the type of the gameFrame object) is also a KeyListener.
}

To be a KeyListener, the class needs to have these 3 methods in it:

@Override
public void keyTyped(KeyEvent e) {}

@Override
public void keyPressed(KeyEvent e) {}

But actually we can use just this one for our goals here:

@Override
public void keyReleased(KeyEvent e) {

When the up or down keys hit, we change the position of our box:

if (e.getKeyCode() == KeyEvent.VK_UP) {
testBoxY -= 100;
} else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
testBoxY += 100;
}

and redraw to have a new picture with the new coordinates:

repaint();
}
}

You can use this image class as a base:

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PositionedImage {
BufferedImage image;
int posX, posY;

public PositionedImage(String filename, int posX, int posY) {
this.posX = posX;
this.posY = posY;
try {
image = ImageIO.read(new File(filename));
} catch (IOException e) {
e.printStackTrace();
}
}

public void draw(Graphics graphics) {
if (image != null) {
graphics.drawImage(image, posX, posY, null);
}
}
}


Plan your architecture. In your architecture you should consider the following components:

Models:

- GameObject,
- Characters (monsters, hero),
- Monster (types),
- Hero,
- Area,
- Tile (emptyTile, notEmptyTile).

GameLogic:

- current hero,
- current area.

Main:

- handling events,
- current board.

(Think about task breakdown in Kanban together.)

Now that you see the big picture, go through the stories together and think
about how to break them down into tasks:

- classes,
- methods,
- data,
- actions.

Extend the story cards with some of these points as a reminder.
