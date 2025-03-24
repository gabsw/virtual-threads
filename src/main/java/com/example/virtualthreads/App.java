package com.example.virtualthreads;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newVirtualThreadPerTaskExecutor();

        for (int i = 0; i < 5; i++) {
            int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + " on " + Thread.currentThread());
                try {
                    Thread.sleep(1000); // simulate IO
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        Thread.sleep(2000); // wait for tasks to complete
        System.out.println("All tasks finished.");
    }
}
