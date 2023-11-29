package org.example.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorsExperiments {
    public ExecutorService executor =
            new ThreadPoolExecutor(
                    3, // исходное количество потоков
                    10, // максимальное количество потоков
                    10, TimeUnit.SECONDS, // время жизни потока
                    new LinkedBlockingQueue<>(10) // очередь задач
            );
    //Executors.newCachedThreadPool();
    //Executors.newFixedThreadPool(3);
    //Executors.newFixedThreadPool(4);
    //Executors.newFixedThreadPool(20);

    public List<Future<?>> futures = new ArrayList<>();

    public void submitTasks() {
        int count = 0;

        while (count < 20) {
            int finalCount = count;
            long time = System.currentTimeMillis();
            Future<?> future = executor.submit(() -> {
                System.out.println("task " + finalCount + " waited for " + (System.currentTimeMillis() - time) + " milliseconds in queue");
                System.out.println("task" + finalCount + " start");
                LoadGenerator.work();
                System.out.println("task" + finalCount + " finish");
            });
            futures.add(future);
            count++;
        }
    }

    public int getQueueSize() {
        return ((ThreadPoolExecutor) executor).getQueue().size();
    }

    public int getPoolSize() {
        return ((ThreadPoolExecutor) executor).getPoolSize();
    }
}
