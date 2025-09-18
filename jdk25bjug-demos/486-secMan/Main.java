import java.security.*;

public class Main {

  public static  class MySecurityManager extends SecurityManager {

    @Override
    public void checkPermission(Permission perm) {
	
    }
  }

  public static void main(String... args) throws Exception {
    SecurityManager hell = new MySecurityManager();
    if (args.length > 0) {
      System.setSecurityManager(hell);
    }
  }
}
