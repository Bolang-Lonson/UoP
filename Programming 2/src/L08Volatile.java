import java.util.concurrent.atomic.AtomicInteger;

/**
 * It is possible to use a shared variable safely outside of synchronized code, but in that case,
 * the variable must be declared to be volatile. The volatile keyword is a modifier that can be
 * added to a global variable declaration
*/
public class L08Volatile {
    private volatile int count;

    /** 
     * A typical example of using volatile variables is to send a signal from one thread to another
     * that tells the second thread to terminate
    */
    static volatile boolean terminate = false;

    private static AtomicInteger total = new AtomicInteger();   //  the class AtomicInteger, which defines some atomic operations on an integer value, including atomic add, increment, and decrement.

    private static class SomeThread extends Thread {

        /** 
         * The run method of the second thread would check the value of terminate frequently, and it
         * would end when the value of terminate becomes true
        */
        public void run() {
            while(!terminate) {
                // Do some work
            }
        }
    }
}