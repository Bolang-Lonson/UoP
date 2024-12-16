/* To fix the problem of race conditions, there has to be some way for a thread to get exclusive
access to a shared resource. 
It’s done with synchronized
methods and with the synchronized statement
 */

class ThreadSafeCounter {
    private int count = 0;

    synchronized public void increment() {
        count++;
    }

    synchronized public int getValue() {
        return count;
    }
}

public class L07Synchronized {
    public static void main(String[] args) {
        ThreadSafeCounter tsc = new ThreadSafeCounter();
        tsc.increment();
    }
}