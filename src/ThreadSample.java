public class ThreadSample {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                    System.out.println("in  thread  : " + Thread.currentThread().getName());
                System.out.println("in  thread  : " + Thread.currentThread().getPriority());
                throw new RuntimeException("Intenetonal exception");
            }
        });

        thread.setName("New Worker Thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("before thread  : " + Thread.currentThread().getName());
        System.out.println("before thread Priority : " + Thread.currentThread().getPriority());

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("application failed  thread name  : " + t.getName() + "exception :"+e.getMessage());
            }
        });

        thread.start();
        System.out.println("after  thread  : " + Thread.currentThread().getName());

        //Thread.sleep(1000);

    }
}
