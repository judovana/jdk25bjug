import java.net.*;
import java.io.*;

public class Server {

  private static long delay=10000;

  private static class Reply extends Thread {
    private final Socket server;
    final int x;
    private Reply(int x, Socket server) {
       super("reply " + x);
       this.server=server;
       this.x=x;
    }
    public void run() {
      try {
         System.out.println(x + ":  client connected");
         OutputStream output = server.getOutputStream();
         PrintWriter writer = new PrintWriter(output, true);
         Thread.sleep(delay);
         writer.println(x + ": done");
         writer.flush();
         writer.close();
      } catch(Exception ex) {}
    }
  }


 
  public static void main(String... args) throws Exception {
    if (args.length > 0) {
      delay=Long.valueOf(args[0]);
    }
    int port = 9111;
	ServerSocket server = new ServerSocket();
    int x = 0;
    try (ServerSocket serverSocket = new ServerSocket(port)) {
      System.out.println("Server is listening on port " + port + " delaying each request for " + delay + "ms");
      while (true) {
        x++;
        Socket socket = serverSocket.accept();
         new Reply(x, socket).start();
      }
    }
  }
}
