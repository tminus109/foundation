package char_sequence;

public class ShiftedCharSequence implements CharSequence {
    String toBeShifted;
    int shiftBy;

    ShiftedCharSequence(String toBeShifted, int shiftBy) {
        this.toBeShifted = toBeShifted;
        this.shiftBy = shiftBy;
    }

    @Override
    public int length() {
        return toBeShifted.length();
    }

    @Override
    public char charAt(int index) {
        index = Math.min(index + shiftBy, toBeShifted.length() - 1);
        return toBeShifted.charAt(index);
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
