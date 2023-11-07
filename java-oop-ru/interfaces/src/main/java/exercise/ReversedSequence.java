package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private final String sequence;

    @Override
    public String toString() {
        return sequence;
    }

    @Override
    public int length() {
        return sequence.length();
    }

    @Override
    public char charAt(int index) {
        return sequence.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return sequence.subSequence(start, end);
    }

    public ReversedSequence(String text) {
        sequence = new StringBuilder(text).reverse().toString();
    }
}
// END
