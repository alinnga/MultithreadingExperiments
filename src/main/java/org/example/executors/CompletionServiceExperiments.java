package org.example.executors;

import java.util.concurrent.*;

public class CompletionServiceExperiments {
    ExecutorService executor = Executors.newFixedThreadPool(4);
    CompletionService<String> complService = new ExecutorCompletionService<>(executor);

    public void submitTasks(){
        int count = 0;

        while (count < 20) {
            int finalCount = count;
            long time = System.currentTimeMillis();
            complService.submit(() -> {
                System.out.println("task " + finalCount + " waited for " + (System.currentTimeMillis() - time) + " milliseconds in queue");
                System.out.println("task" + finalCount + " start");
                LoadGenerator.work();
                System.out.println("task" + finalCount + " finish");
                return "result of task " + finalCount;
            });
            count++;
        }
    }

    public String getResults(){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i< 20; i++){
            Future<String> result = complService.poll();
            try {
                if(result != null){
                    s.append(result.get());
                    s.append("\n");
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return s.toString();
    }
}
