import java.util.ArrayList;
import java.util.List;

public class ThreadInterrupt {
    public static void main(String args[]){
       Thread thread = new Thread(new ThreadinterruptCase());
       thread.start();
       thread.interrupt();
    }


    private static class ThreadinterruptCase implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException fired........");
            e.printStackTrace();
        }
    }
    }
}
