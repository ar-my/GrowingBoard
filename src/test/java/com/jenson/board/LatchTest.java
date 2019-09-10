package com.jenson.board;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class LatchTest {
    private final static int THREADS = 10;
    private static CountDownLatch latch = new CountDownLatch(THREADS);

    private static class RandomSleepRunnable implements Runnable {
        private int id;
        private static Random random = new Random(System.currentTimeMillis());

        public RandomSleepRunnable(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("Thread(" + id + ") Start. ");
            // generate around 1000 ~ 2000ms
            int delay = random.nextInt(1001) + 1000;

            try {
                System.out.println("Thread(" + id + ") : Sleep " + delay + "ms");
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            System.out.println("Thread(" + id + ") End. ");
        }
    }

    @Test
    public void test_latch() {
        IntStream.range(0, 10).forEach(i -> new Thread(new RandomSleepRunnable(i)).start());

        try {
            latch.await(3000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All Threads Terminated");
    }
}
