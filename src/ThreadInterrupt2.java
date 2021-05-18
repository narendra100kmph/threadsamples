public class ThreadInterrupt2 {

    public static void main(String args[]) throws InterruptedException {
        Thread thread = new Thread(new ThreadinterruptCase());
        thread.setDaemon(true);
        thread.start();
      Thread.sleep(10);
        thread.interrupt();
    }


    private static class ThreadinterruptCase implements Runnable {
        @Override
        public void run() {
            System.out.println("InterruptedException handled........" + test());
        }
    boolean test() {
            for (int i=0 ; i< 1000 ; i++){
                //if(Thread.currentThread().isInterrupted()){
                System.out.println("exiting from interrupted thread :" + i);
               // return true;
         //   }
            }
            return false;
        }
    }
}
