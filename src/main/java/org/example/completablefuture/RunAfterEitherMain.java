package org.example.completablefuture;

import java.util.concurrent.CompletableFuture;

public class RunAfterEitherMain {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> completableFutureObject1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("completable future 1");
            return "completable future 1";
        });

        CompletableFuture<String> completableFutureObject2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("completable future 2");
            return "completable future 2";
        });

        Runnable runnable = () -> System.out.println("Completed one of futures");

        completableFutureObject1.runAfterEither(completableFutureObject2, runnable);
        Thread.sleep(4000);
    }
}
