/** Runnable class for implementing Runnables fro the creation of threads */
class NamedRunnable implements Runnable {
    private String name;  // The name of this Runnable

    public NamedRunnable(String name) { // Constructor gives name to object.
        this.name = name;
    }

    public void run() { // The run method prints a message to standard output.
        System.out.println("Greetings from runnable '" + name +"'!");
    }
}

public class L05Runnable {
    public static void main(String[] args) {
        NamedRunnable greetings = new NamedRunnable("Saadiq");
        Thread greetingsThread = new Thread(greetings);

        greetingsThread.start();

        // Runnable is a functional interface, so that a Runnable object can be given as a lambda expression
        Thread greetingFromSaadiq = new Thread(
            () -> System.out.println("Greetings from Saadiq!")
        );

        greetingFromSaadiq.start();
    }
}