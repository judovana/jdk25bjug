import java.util.*;
public class Slave {
   public final StableValue<Random> r = StableValue.of();
   public Random getR(){ return r.orElseSet(() -> new Random());}
}
