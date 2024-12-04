public class L04Threads {
    public static void main(String[] args) {
        NamedThread greetings = new NamedThread("Bolang");

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