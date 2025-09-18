import java.util.concurrent.*;
import java.lang.management.*;
import java.net.*;

public class Main {

  public static Object lock = new Object();

  private static class Runner implements Runnable {
    private final int x;
    public Runner(int x){ this.x=x;}

    synchronized
    byte[] getData() {
      try { 
        byte[] buf = new byte[100];
        Socket socket = new Socket("localhost", 9111);
        int nread = socket.getInputStream().read(buf);
        return buf;
      } catch(Exception ex) {return new byte[0];}
    }

    public void run() {
      while(true) {
        try {
           System.out.println(x + ": Total Number of threads " + ManagementFactory.getThreadMXBean().getThreadCount());
           getData();
         } catch(Exception ex) {}
       }
    }
  }

  public static void main(String... args) throws Exception {
    try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
      for (int x = 0; x < 10000; x++) {
        executor.submit(new Runner(x));
      };
    }  
  }
}
