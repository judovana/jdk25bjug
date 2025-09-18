import java.util.*;
public class Slave {
   private class LazyHolder {
        static final Random INSTANCE = new Random();
    }
   public Random getR(){return LazyHolder.INSTANCE;}
}
