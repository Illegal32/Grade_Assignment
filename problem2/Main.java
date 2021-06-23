package problem2;

public class Main {
    public static void main(String[] args) {

        Counter counter = new Counter();

        Incrementer inc = new Incrementer(counter);
        Reader read = new Reader(counter);

        inc.start();
        read.start();

        try {
            inc.join();
            read.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
