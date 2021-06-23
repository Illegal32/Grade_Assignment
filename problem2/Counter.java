package problem2;

public class Counter {
    private int count = 0;
    private boolean isModified = false;

    public synchronized void increment() throws InterruptedException {
        if (isModified)
            wait(); // there is already a modification, it must be read first

        System.out.println("\n" + Thread.currentThread().getName() + " incremented " + ++count);

        isModified = true;
        notify();
    }

    public synchronized void get() throws InterruptedException {
        if (!isModified)
            wait(); // there is no recent increment to be read

        System.out.println(Thread.currentThread().getName() + " reading " + count);

        isModified = false;
        notify();
    }
}
