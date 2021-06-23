package problem1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
    public static void main(String[] args) {

        try {
            Queue<Task> queue = getAllTasksInQueue();

              // TODO
             //ParallelTaskExecutor ex1 = new ParallelTaskExecutor("Worker1", queue);
            //ParallelTaskExecutor ex2 = new ParallelTaskExecutor("Worker2", queue);
           //ParallelTaskExecutor ex3 = new ParallelTaskExecutor("Worker2", queue);

         // ParallelTaskExecutor[] workers = new
        // ParallelTaskExecutor[Runtime.getRuntime().availableProcessors()];
            ParallelTaskExecutor[] workers = new ParallelTaskExecutor[10];

            long start = System.currentTimeMillis();

            for (int i = 0; i < workers.length; i++) {
                workers[i] = new ParallelTaskExecutor("Worker " + (i + 1), queue);
                workers[i].start();
                // workers[i].join();
            }

            for (ParallelTaskExecutor ex : workers)
                ex.join();

            long end = System.currentTimeMillis();
            System.out.println("Total time cost: " + (end - start));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    static Queue<Task> getAllTasksInQueue() throws IOException {
        Queue<Task> tasks = new PriorityQueue<>();

        try (BufferedReader br = new BufferedReader(new FileReader(new File("data/tasks.csv")))) {
            String line = br.readLine(); // first line is the header

            while ((line = br.readLine()) != null) {
                tasks.add(Task.parseToTask(line));
            }
        }

        return tasks;
    }

}
