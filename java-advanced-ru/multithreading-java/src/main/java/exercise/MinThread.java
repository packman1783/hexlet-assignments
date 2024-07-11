package exercise;

// BEGIN
public class MinThread extends Thread {
    private int[] numbers;
    private int min;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    public int getMin() {
        return min;
    }

    @Override
    public void run() {
        int minValue = numbers[0];

        for(int num : numbers) {
            if (num < minValue) {
               minValue = num;
            }
        }

        min = minValue;
    }
}
// END
