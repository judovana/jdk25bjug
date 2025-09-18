import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

//this is inspired by JEP text, where it says that waiting for server response is one of the examples, where the function is running, but not using CPU
//fakeresponder is a public server where you can set approximate response time in ms as a parameter, which is quite useful for testing
//two threads.. one works full time, the other tries to periodically contact fakeresponder server with ~5s waittime
//did not provide useful information as even wallclock sampling realized that the server thread is not consuming CPU time

public class CpuVsWallIoDemo {
    private static final AtomicLong busyCount = new AtomicLong();
    private static final AtomicLong ioCount = new AtomicLong();

    public static void main(String[] args) throws Exception {
        System.out.println("Running two threads for ~20s...");

        Thread busy = new Thread(() -> runBusyWorker(), "BusyWorker");
        Thread io   = new Thread(() -> runIoWorker(), "IoWorker");

        busy.start();
        io.start();

        Thread.sleep(20_000); // run ~20s

        busy.interrupt();
        io.interrupt();
        busy.join();
        io.join();

        System.out.println("Done.");
        System.out.println("BusyWorker busyLoop calls = " + busyCount.get());
        System.out.println("IoWorker HTTPS calls      = " + ioCount.get());
    }

    private static void runBusyWorker() {
        while (!Thread.currentThread().isInterrupted()) {
            busyLoop(5000000); // ~5s CPU burn
            busyCount.incrementAndGet();
        }
    }

    private static void runIoWorker() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create("https://fakeresponder.com/?sleep=5000"))
                .build();

        while (!Thread.currentThread().isInterrupted()) {
            try {
                client.send(req, HttpResponse.BodyHandlers.ofString());
                ioCount.incrementAndGet();
            } catch (Exception e) {
                System.err.println("I/O error: " + e);
                break;
            }
        }
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

