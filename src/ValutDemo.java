import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ValutDemo {

    public static final int bound = 9999;

    public static void main(String[] args) {

        Random random = new Random();
        Vault vault = new Vault(random.nextInt(bound));
        List<Thread> threadGroup = new ArrayList<Thread>();

        AsendingHackerThread asendingHackerThread = new AsendingHackerThread(vault);
        DescendingHackerThread descendingHackerThread = new DescendingHackerThread(vault);
        PoliceThread policeThread = new PoliceThread();

        threadGroup.add(asendingHackerThread);
        threadGroup.add(descendingHackerThread);
        threadGroup.add(policeThread);

        for (Thread thread : threadGroup) {
            thread.start();
        }

    }

    public static class Vault {

        private int password;

        public Vault(int password) {
            this.password = password;
        }

        public boolean isPasswordCorrect(int guess) {
            try {
               Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return this.password == guess;
        }

    }

    public  static abstract class HackerThread extends Thread {

        protected Vault vault;

        public HackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void start() {
            System.out.println("thread started :: " + this.getName());
            super.start();
        }
    }

    public static class AsendingHackerThread extends HackerThread {

        public AsendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int counter = 0; counter < bound; counter++)
                if (vault.isPasswordCorrect(counter)) {
                    System.out.println("hacker run :: " + this.getName());
                    System.exit(0);
                }
        }
    }

    public static class DescendingHackerThread extends HackerThread {

        public DescendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int counter = bound; counter > bound; counter--)
                if (vault.isPasswordCorrect(counter)) {
                    System.out.println("hacker run  :: " + this.getName());
                    System.exit(0);
                }
        }
    }

    public static class PoliceThread extends Thread {

        @Override
        public void run() {
            for (int i = 10; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
            System.out.println("game over:");
            System.exit(0);
        }
    }
}

