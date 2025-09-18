import java.util.*;
import java.util.function.*;
import java.util.stream.*;


public class CustomCollector {

    public static class CustomCollectorImpl implements Collector<Integer, List<Integer>, List<Integer>> {
            Integer add = null;

            @Override
            public Supplier<List<Integer>> supplier() {
                System.out.println("supplier");
                return () -> {
                  System.out.println("supplier called");
                  return new ArrayList<Integer>();
                };
            }

            @Override
            public BiConsumer<List<Integer>, Integer> accumulator() {
                System.out.println("accumulator");
                return (List<Integer> l, Integer i) -> {
                  System.out.println("accumulator called");
                  if(add ==null){
                    add=i;
                  } else {
                    l.add(i+add);
                    add=null;
                  }
                };
            }

            @Override
            public BinaryOperator<List<Integer>> combiner() {
                System.out.println("combiner");
                return (list1, list2) -> {
                    System.out.println("combiner called");
                    list1.addAll(list2);
                    return list1;
                };
            }

            @Override
            public Function<List<Integer>, List<Integer>> finisher() {
                System.out.println("finisher");
                return (List<Integer> l) -> {
                   System.out.println("finisher called");
                   return Collections.unmodifiableList(l);
              };
            }

            @Override
            public Set<Characteristics> characteristics() {
                System.out.println("characteristics");
                return Collections.emptySet();
            }
        };

    public static void main(String[] args) {
        //List.of(1, 2, 3, 4).stream().collect(new CustomCollectorImpl());
        List<Integer> result = List.of(1, 2, 3, 4).stream().collect(new CustomCollectorImpl());
        System.out.println(result);
		result=result.stream().collect(new CustomCollectorImpl());
        System.out.println(result);
    }
}
