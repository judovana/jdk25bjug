
public class Main {

  private static native void nativeHello(long iter, byte[] array);

    static {
        System.loadLibrary("native");
    }

  public static void main(final String... args) throws Exception {
   if (args.length > 0) {
      new Thread (new Runnable() {
        public void run(){
          int counter = 0;
          while (true) {
            counter++;
            int sizer=10;
            if (args.length > 1) {
              sizer=Integer.valueOf(args[1]);
            }
            byte[] useless = new byte[sizer*1024*1024];
            System.err.println(counter + ". allocated: "+useless.length);
          }
        }
      }).start();
//      Thread.sleep(1000);
      new Thread (new Runnable() {
        public void run(){
          Main.nativeHello(Long.valueOf(args[0]),  new byte[1024*1024]);
       }
      }).start();
   } else {
      Main.nativeHello(0, null);
   }
 }
}
