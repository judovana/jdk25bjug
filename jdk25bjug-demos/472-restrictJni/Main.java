
public class Main {

  private static native void nativeHello();

    static {
        System.loadLibrary("native");
    }

  public static void main(final String... args) throws Exception {
      Main.nativeHello();
 }
}
