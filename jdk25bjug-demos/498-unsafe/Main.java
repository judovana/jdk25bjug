import sun.misc.Unsafe;
import java.lang.reflect.*;

public class Main {

private static class OffHeapArray {
    private final static int BYTE = 1;
    private long size;
    private long address;

    public OffHeapArray(long size) throws NoSuchFieldException, IllegalAccessException {
        this.size = size;
        address = getUnsafe().allocateMemory(size * BYTE);
    }

    private Unsafe getUnsafe() throws IllegalAccessException, NoSuchFieldException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        return (Unsafe) f.get(null);
    }

    public void set(long i, byte value) throws NoSuchFieldException, IllegalAccessException {
        getUnsafe().putByte(address + i * BYTE, value);
    }

    public int get(long idx) throws NoSuchFieldException, IllegalAccessException {
        return getUnsafe().getByte(address + idx * BYTE);
    }

    public long size() {
        return size;
    }
    
    public void freeMemory() throws NoSuchFieldException, IllegalAccessException {
        getUnsafe().freeMemory(address);
    }
}

  public static void main(String... args) throws Exception {
        if (args.length > 0) {
          if (Long.valueOf(args[0]) == 0) {
          // no call
          }else if (Long.valueOf(args[0]) < 0) {
             new OffHeapArray(-1*Long.valueOf(args[0]));
          } else {
          	byte[] b = new byte[Integer.valueOf(args[0])];
          }
          while(true) {
            Thread.sleep(1000);
          }
        } else {
          new OffHeapArray(Long.valueOf(1));
        }
  }
}
