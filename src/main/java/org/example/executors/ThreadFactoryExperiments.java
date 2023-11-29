package org.example.executors;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class ThreadFactoryExperiments {

    public void submitTasks() {
        Thread.UncaughtExceptionHandler handler  = (t, e) -> {
            // этот exception handler срабатывает только тогда, когда исключение не поймано.
            // Метод submit() ловит его где-то внутри, а execute() нет.
            // Поэтому этот хендлер будет вызываться только при использовании метода execute()
            System.out.println("Exception in thread "+t.getName());
            System.out.println(e.getMessage());
        };
        ThreadFactory tf = new ThreadFactoryBuilder()
                .setNameFormat("Guava thread-%d")
                .setUncaughtExceptionHandler(handler)
                .build();

        ExecutorService executor = Executors.newFixedThreadPool( 5, tf);

        for(int i = 0; i< 5; i++){
            executor.submit(() -> {
                System.out.println("I am a thread named "+Thread.currentThread().getName());
                System.out.println("Everything is okay");
                return "hi";
            });
        }
        for(int i = 0; i< 5; i++){
            executor.execute(() -> {
                System.out.println("I am a thread named " + Thread.currentThread().getName());
                System.out.println("Everything is bad");
                throw new RuntimeException("Bad day :(");
            });
        }

    }
}
