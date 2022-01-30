Model stringed instruments.

Create a package called instruments. Create the corresponding classes in this package.
The MusicApp class (see below) will reference to these classes.

We start with a base, abstract class: Instrument.
It reserves (e.g. protected) the name of the instrument.
It should provide a play() method.

Next, we add another abstract class: StringedInstrument which extends Instrument.
It introduces numberOfStrings and sound() method. Implementations are yet unknown
but with the help of the sound() method, the play() method is fully implementable.

StringedInstrument has 3 descendants:

- Electric Guitar (6 strings, "Twang"),
- Bass Guitar (4 strings, "Duum-duum-duum"),
- Violin (4 strings, "Screech").

The workshop should be invoked by an App Class which is placed outside the package:

import instruments.*;

public class MusicApp {
    public static void main(String[] args) {
        System.out.println("Test 1:");
        ElectricGuitar guitar = new ElectricGuitar();
        BassGuitar bassGuitar = new BassGuitar();
        Violin violin = new Violin();
        guitar.play();
        bassGuitar.play();
        violin.play();
        System.out.println();
        System.out.println("Test 2:");
        ElectricGuitar guitar2 = new ElectricGuitar(7);
        BassGuitar bassGuitar2 = new BassGuitar(5);
        guitar2.play();
        bassGuitar2.play();
    }
}

We expect the following output:

Test 1:
Electric Guitar, a 6-stringed instrument that goes Twang.
Bass Guitar, a 4-stringed instrument that goes Duum-duum-duum.
Violin, a 4-stringed instrument that goes Screech.

Test 2:
Create Electric, Bass Guitar with 7 and 5 strings.
Electric Guitar, a 7-stringed instrument that goes Twang.
Bass Guitar, a 5-stringed instrument that goes Duum-duum-duum.
