import java.util.concurrent.ThreadLocalRandom;

//best example I was able to produce.. but it can differ based on a machine.. you can try to add sleep before executing the second lazy thread to modify the result and get a best possible sampling frequency to make a difference
//individual busyLoop and lazyLoop end methods for easy tracking, although they are identical

public class CpuVsWallThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Running two workers for ~20s...");

        Thread workerA = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                busyWorkLong(8_000); // ~8 ms of CPU work
                try {
                    Thread.sleep(2); // rest some time
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "HardWorker");

        Thread workerB = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                busyWorkShort(2_000); // ~2 ms of CPU work
                try {
                    Thread.sleep(8); // rest most of the time
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "LazyWorker");

        workerA.start();
        workerB.start();

        // Let both threads run for ~20 seconds
        Thread.sleep(20_000);

        // Stop threads gracefully
        workerA.interrupt();
        workerB.interrupt();
        workerA.join();
        workerB.join();

        System.out.println("Done. Analyze with JFR.");
    }

    private static void busyWorkLong(long durationMicros) {
        busyLoop(durationMicros);
    }

    private static void busyWorkShort(long durationMicros) {
        lazyLoop(durationMicros);
    }

    private static void busyLoop(long durationMicros) {
        long start = System.nanoTime();
        long durationNanos = durationMicros * 1_000;
        while (System.nanoTime() - start < durationNanos) {
            double x = Math.sqrt(ThreadLocalRandom.current().nextDouble());
            if (x == -1.0) { // avoid dead code elimination
                System.out.println("Impossible: " + x);
            }
        }
    }

    private static void lazyLoop(long durationMicros) {
        long start = System.nanoTime();
        long durationNanos = durationMicros * 1_000;
        while (System.nanoTime() - start < durationNanos) {
            double x = Math.sqrt(ThreadLocalRandom.current().nextDouble());
            if (x == -1.0) { // avoid dead code elimination
                System.out.println("Impossible: " + x);
            }
        }
    }

}

