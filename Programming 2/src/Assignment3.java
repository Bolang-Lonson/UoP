import java.text.SimpleDateFormat;
import java.util.Date;

// Main Clock class
class Clock {
    private volatile boolean running = true;


    public void start() {
        // Thread for updating time
        Thread updateThread = new Thread(new TimeUpdater(), "TimeUpdaterThread");
        updateThread.setPriority(Thread.MIN_PRIORITY);

        // Thread for displaying time
        Thread displayThread = new Thread(new TimeDisplay(), "TimeDisplayThread");
        displayThread.setPriority(Thread.MAX_PRIORITY);

        // Start both threads
        updateThread.start();
        displayThread.start();
    }

    // Runnable class for updating time in the background
    private class TimeUpdater implements Runnable {
        @Override
        public void run() {
            while (running) {
                // Background update logic (simulate updating internal state, if needed)
                try {
                    Thread.sleep(1000); // Simulate a 1-second interval for updating
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    // Runnable class for displaying time continuously
    private class TimeDisplay implements Runnable {
        @Override
        public void run() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
            while (running) {
                String currentTime = dateFormat.format(new Date());
                System.out.println(currentTime);
                try {
                    Thread.sleep(1000); // Update every second
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

public class Assignment3 {
    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.start();
    }
}