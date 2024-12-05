public class L04Threads {
    public static void main(String[] args) {
        NamedThread greetings = new NamedThread("Bolang");

        /* The start()
method returns immediately after starting the new thread of control, without waiting for
the thread to terminate. This means that the code in the thread’s run() method executes
at the same time as the statements that follow the call to the start() method */
        greetings.start();
        System.out.println("Thread has been started");
    }
}

class NamedThread extends Thread {
    private String name;

    public NamedThread(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("Greetings from thread '" + name + "'!");
    }
}