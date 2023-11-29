package org.example.executors;

public class ComplServiceExperimentsMain {
    public static void main(String[] args) throws InterruptedException {
        CompletionServiceExperiments complServExp = new CompletionServiceExperiments();
        complServExp.submitTasks();
        Thread.sleep(3000);
        String res = """
                -------Results-------
                %s
                ---------------------
                """.formatted(complServExp.getResults());
        System.out.println(res);
        complServExp.executor.shutdown();
    }
}