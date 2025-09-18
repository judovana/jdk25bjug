import java.util.stream.*;
import java.util.*;

public class DirectReuse {


   private static List<String> remap() {
      return Arrays.asList(1, 2, 3, 4).stream().gather(Gatherer.of((state, element, downstream) -> { downstream.push("'" + (element*3) +"'");return true;})).map(n->n.toString()).toList();
      //return Arrays.asList(1, 2, 3, 4).stream().map(n -> n * 3).map(n -> "'"+n+"'").toList();
}


    public static void main(String[] args){
		remap().stream().forEach( n -> System.out.println(n));
    }
}
