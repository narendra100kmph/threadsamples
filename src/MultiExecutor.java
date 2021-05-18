import java.util.ArrayList;
import java.util.List;

public class MultiExecutor {

    // Add any necessary member variables here
  private List<Runnable> tasks;
    /* 
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {
    this.tasks = tasks;
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        for (Runnable run : tasks){
          Thread th = new Thread(run);
          th.start();
        }
    }

    public static void main(String args[]){
        List<Runnable> list = new ArrayList<Runnable>();

        list.add(new Runnable() {
            @Override
            public void run() {
                System.out.println( Thread.currentThread().getName());
            }
        });

        list.add(new Thread(() -> { System.out.println(Thread.currentThread().getName());}));

        MultiExecutor multiExecutor = new MultiExecutor(list);

        multiExecutor.executeAll();
    }
}