package exercise;

// BEGIN
public class MaxThread extends Thread {
    private int[] numbers;
    private int max;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    public int getMax() {
        return max;
    }

    @Override
    public void run() {
        int maxValue = numbers[0];

        for (int num : numbers) {
            if (num > maxValue) {
                maxValue = num;
            }
        }

        max = maxValue;
    }
}
// END
