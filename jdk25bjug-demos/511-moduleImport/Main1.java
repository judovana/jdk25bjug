//import java.io.*;
//import java.util.*;
import module java.base;

public class Main1 {

  public static void main(String... args) throws Exception {
        if (args.length > 0) {
           Map<Integer, File> map = new HashMap<>();
           for (int x = 0 ; x < Integer.valueOf(args[0]); x++) {
              map.put(Integer.valueOf(x), new File(""+x));
           }
           System.out.println("I'm alive with " + map.size() + " indexed files");
        } else {         System.out.println("I'm alive"); }
  }
}
