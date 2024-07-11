package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        var maxThread = new MaxThread(numbers);
        var minThread = new MinThread(numbers);

        maxThread.start();
        LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " started");
        minThread.start();
        LOGGER.log(Level.INFO, "Thread " + minThread.getName() + " started");
        try {
            maxThread.join();
            LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " finished");
            minThread.join();
            LOGGER.log(Level.INFO, "Thread " + minThread.getName() + " finished");
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }

        Map<String, Integer> result = Map.of(
                "max", maxThread.getMax(),
                "min", minThread.getMin()
        );

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {10, -4, 67, 100, -100, 8};

        System.out.println(App.getMinMax(numbers));
    }
    // END
}
