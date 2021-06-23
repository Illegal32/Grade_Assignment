package problem1;

import java.util.Queue;

public class ParallelTaskExecutor extends Thread {
    private final Queue<Task> tasks;

    public ParallelTaskExecutor(String name, Queue<Task> tasks) {
        super(name);
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (!tasks.isEmpty()) {
            // pick a task
            Task curTask = tasks.poll();

            // execute
            System.out.println(
                    this.getName() + " EXECUTING " + curTask.getName() + " with priority " + curTask.getPriority());

            try {
                Thread.sleep(curTask.getDuration());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(this.getName() + " COMPLETED " + curTask.getName() + " with priority "
                    + curTask.getPriority() + "\n");

        }
    }

}
