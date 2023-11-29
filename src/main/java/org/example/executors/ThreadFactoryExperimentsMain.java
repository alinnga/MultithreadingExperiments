package org.example.executors;

import java.util.concurrent.ExecutionException;

public class ThreadFactoryExperimentsMain {
    public static void main(String[] args) {
        ThreadFactoryExperiments thFacExp = new ThreadFactoryExperiments();
        thFacExp.submitTasks();
    }
}
