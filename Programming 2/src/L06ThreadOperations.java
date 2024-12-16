import textio.TextIO;

public class L06ThreadOperations {

    private final static int MAX = 10_000_000;

    private static class CountPrimesThread extends Thread {
        int id;  // An id number for this thread; specified in the constructor.
        public CountPrimesThread(int id) {
            this.id = id;
        }
        public void run() {
            long startTime = System.currentTimeMillis();
            int count = countPrimes(2,MAX);
            long elapsedTime = System.currentTimeMillis() - startTime;
            System.out.println("Thread " + id + " counted " + 
                    count + " primes in " + (elapsedTime/1000.0) + " seconds.");
        }
    }
    public static void main(String[] args) {
        int numberOfThreads = 0;

        while (numberOfThreads < 1 || numberOfThreads > 30) {
            System.out.print("How many threads do you want to use  (from 1 to 30) ?  ");
            numberOfThreads = TextIO.getlnInt();
            if (numberOfThreads < 1 || numberOfThreads > 30)
                System.out.println("Please enter a number between 1 and 30 !");
        }

        System.out.println("\nCreating " + numberOfThreads + " prime-counting threads...");

        CountPrimesThread[] workers = new CountPrimesThread[numberOfThreads];
        long startTime = System.currentTimeMillis();

        for(int i = 0; i < numberOfThreads; i++) {
            workers[i] = new CountPrimesThread(i);
            workers[i].start();
        }

        for(int i = 0; i < numberOfThreads; i++) {
            while(workers[i].isAlive()) {
                try {
                    workers[i].join();      // Wait until worker[i] finishes, if it hasn’t already.
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
            }
        }

        // At this point, all the worker threads have terminated.
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Total elapsed time: " + (elapsedTime/1000.0) + " seconds");
    }

    /**
     * Compute and return the number of prime numbers in the range
     * min to max, inclusive.
     */
    private static int countPrimes(int min, int max) {
        int count = 0;
        for (int i = min; i <= max; i++)
            if (isPrime(i))
                count++;
        return count;
    }

    /**
     * Test whether x is a prime number.  
     * x is assumed to be greater than 1.
     */
    private static boolean isPrime(int x) {
        assert x > 1;
        int top = (int)Math.sqrt(x);
        for (int i = 2; i <= top; i++)
            if ( x % i == 0 )
                return false;
        return true;
    }
}