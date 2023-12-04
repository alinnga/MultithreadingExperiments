package org.example.completablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AllOfMain {
    public static void main(String[] args) throws InterruptedException{
        List<String> strings = List.of("cf1", "cf2", "cf3", "cf4");
        CompletableFuture<String>[] futures = strings.stream().map(s -> CompletableFuture.supplyAsync(() -> {
            System.out.println(s);
            return s;
        })).toArray(CompletableFuture[]::new);

        Runnable runnable = () -> System.out.println("Completed all the futures");

        CompletableFuture.allOf(futures).thenRun(runnable);
        Thread.sleep(4000);
    }
}
