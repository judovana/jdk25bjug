import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

// this is a second attempt for a demo, however since the individual Threads display as Lambda functions in profiler, there is no clear distinction and the end function busyLoop is identified as the main culprit of CPU usage, the callers are basically ignored

public class CpuVsWallIllusion {
    private static final AtomicLong busyCount = new AtomicLong();
    private static final AtomicLong sleepyCount = new AtomicLong();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Running two threads for ~20s...");

        Thread busy = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                busyLoop(20000); // ~5 ms work
                busyCount.incrementAndGet();
            }
        }, "BusyWorker");

        Thread sleepy = new Thread(() -> {
            try {
                    Thread.sleep(2); // align with wall-clock sampling
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
	    while (!Thread.currentThread().isInterrupted()) {
                busyLoop(10000); // ~0.5 ms work
                sleepyCount.incrementAndGet();
                try {
                    Thread.sleep(10); // align with wall-clock sampling
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "SleepyWorker");

        busy.start();
        sleepy.start();

        Thread.sleep(20_000); // run ~20 seconds

        busy.interrupt();
        sleepy.interrupt();
        busy.join();
        sleepy.join();

        System.out.println("Done.");
        System.out.println("BusyWorker busyLoop calls   = " + busyCount.get());
        System.out.println("SleepyWorker busyLoop calls = " + sleepyCount.get());
    }

    private static void busyLoop(long durationMicros) {
        long start = System.nanoTime();
        long durationNanos = durationMicros * 1_000;
        while (System.nanoTime() - start < durationNanos) {
            double x = Math.sqrt(ThreadLocalRandom.current().nextDouble());
            if (x == -1.0) {
                System.out.println("Impossible: " + x);
            }
        }
    }
}

