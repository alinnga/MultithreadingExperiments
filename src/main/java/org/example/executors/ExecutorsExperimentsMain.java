package org.example.executors;

import java.util.concurrent.Future;

public class ExecutorsExperimentsMain {
    public static void main(String[] args) throws InterruptedException {
        ExecutorsExperiments executorsExperiments = new ExecutorsExperiments();
        executorsExperiments.submitTasks();
        long time = System.currentTimeMillis();
        boolean allDone = false;

        while(!allDone){
            Thread.sleep(100);
            System.out.println("Queue size: "+executorsExperiments.getQueueSize());
            System.out.println("Pool size: "+executorsExperiments.getPoolSize());

            allDone = true;
            for(Future<?> future:executorsExperiments.futures){
                allDone &= future.isDone();
            }
        }
        executorsExperiments.executor.shutdown();
        System.out.println("Time spent for 20 tasks: " + (System.currentTimeMillis()-time));
    }
}