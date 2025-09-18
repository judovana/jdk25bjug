public class Main {

  private static class Master {

   	Master() {
      System.out.println("I'm your master!");
    }
  }

  private static class KindMaster extends Master {

   	KindMaster() {
      System.out.println("Are you my master?");
      super();
      System.out.println("I'm kind master!");
    }
  }

  public static void main(String... args) {
    new KindMaster();
  }
}
