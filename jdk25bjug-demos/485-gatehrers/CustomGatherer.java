import java.util.*;
import java.util.function.*;
import java.util.stream.*;


public class CustomGatherer {

    static class MyGatherer  implements  Gatherer<Integer, List<Integer>, Integer> {
        
        @Override
        public Supplier<List<Integer>> initializer() {
                System.out.println("initializer");
                return () -> {
                  System.out.println("initializer called");
                  return new ArrayList<Integer>();
                };
        }
        
        @Override
        public Integrator<List<Integer>, Integer, Integer> integrator() {
            System.out.println("integrator");
            return (batch, element, downstream) -> {
                System.out.println("integrator called");
                batch.add(element);
                if (batch.size() == 2) {
                    List<Integer> completedBatch = new ArrayList<>(batch);
                    batch.clear();
                    return downstream.push(completedBatch.get(0)+completedBatch.get(1));
                }
                return true;
            };
        }
        
        @Override
        public BiConsumer<List<Integer>,Downstream<? super Integer>> finisher() {
            System.out.println("finisher");
            return (batch, downstream) -> {	
                System.out.println("finisher called");
                if (!batch.isEmpty()) {
                  System.out.println("warning an odd element!");
                }
            };
        }
        
   }

    public static void main(String[] args) {
//        List<Integer> result = List.of(1, 2, 3, 4).stream().gather(new MyGatherer()).toList();
//        System.out.println(result);
//		  result=result.stream().gather(new MyGatherer()).collect(Collectors.toList());

        List<Integer> result = List.of(1, 2, 3, 4).stream().gather(new MyGatherer()).gather(new MyGatherer()).toList();
        System.out.println(result);
//          List.of(1, 2, 3, 4).stream().gather(new MyGatherer());//.gather(new MyGatherer());//??
    }
}
