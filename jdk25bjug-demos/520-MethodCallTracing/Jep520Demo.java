import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Jep520Demo {

    public static void main(String[] args) throws Exception {
        Jep520Demo demo = new Jep520Demo();
        for (int i = 0; i < 5; i++) {
            demo.compute(i);
            Thread.sleep(200);
        }

        Worker w = new Worker();
        w.doWork();
    }

    @DemoMarker
    public int compute(int x) {
        return helper(x) * 2;
    }

    private int helper(int y) {
        return y + 1;
    }

    static class Worker {
        @DemoMarker
        public void doWork() {
            System.out.println("Worker is working...");
	    for (int i = 0; i < 1_000_000; i++){
	        if (i < 0){
		    System.out.println("Impossibru");
		};
	    }
        }
    }
}

