package char_sequence;

public class Gnirts implements CharSequence {
    String gnirt;

    Gnirts(String gnirt) {
        this.gnirt = gnirt;
    }

    @Override
    public int length() {
        return gnirt.length();
    }

    @Override
    public char charAt(int index) {
        index = Math.max(gnirt.length() - index - 1, 0);
        return gnirt.charAt(index);
    }

    @Override
    public boolean isEmpty() {
        return CharSequence.super.isEmpty();
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
