import java.util.*;
import java.util.stream.*;

public class NamedVars {
  private static final List<Integer> range = IntStream.rangeClosed(0, 2).boxed().collect(Collectors.toList());

  public static void main(String... args) {
    int counter = 0;
    for (Integer a : range) {
      counter++;
    }
    System.out.println("total: " + counter);
    counter = 0;
    for (Integer a : range) {
       for (Integer b : range) {
        counter++;
      }
    }
    System.out.println("total: " + counter);
  }
}
