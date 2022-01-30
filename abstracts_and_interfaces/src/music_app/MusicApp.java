package music_app;

import instruments.BassGuitar;
import instruments.ElectricGuitar;
import instruments.Violin;

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
