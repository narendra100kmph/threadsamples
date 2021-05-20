public class MinMaxMetrics {

    // Add all necessary member variables
    private volatile long min;
    private volatile long max;


    public static  void main(String args[]){
        MinMaxMetrics minMaxMetrics = new MinMaxMetrics();

        MinThread minThread = new MinThread(minMaxMetrics);
        MaxThread maxThread = new MaxThread(minMaxMetrics);

        minThread.start();
        maxThread.start();

        try {
            minThread.join();
            maxThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("min"+ minMaxMetrics.getMin() );
        System.out.println("max"+ minMaxMetrics.getMax() );


    }

    private static class MinThread extends Thread {
        private MinMaxMetrics minMaxMetrics ;

        public MinThread(MinMaxMetrics minMaxMetrics) {
           this.minMaxMetrics = minMaxMetrics;
        }
        @Override
        public void run() {
            long start = 100;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             long end  = 200;
             long diff = end- start;
              minMaxMetrics.addSample(diff);

        }

    }

    private static class MaxThread extends Thread {
       private  MinMaxMetrics minMaxMetrics ;
        public MaxThread(MinMaxMetrics minMaxMetrics) {
            this.minMaxMetrics = minMaxMetrics;
        }
        @Override
        public void run() {
            long start = 50;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long end  = 100;
            long diff = end- start;
            minMaxMetrics.addSample(diff);
        }
    }



    /**
     * Initializes all member variables
     */
    public MinMaxMetrics() {
       this.min = 20;
        this.max= 500;
    }

    /**
     * Adds a new sample to our metrics.
     */
    public  void addSample(long newSample) {
        synchronized (this) {
            this.min = Math.min(newSample, this.min);
            this.max = Math.max(newSample, this.max);
        }
    }

    /**
     * Returns the smallest sample we've seen so far.
     */
    public long getMin() {
        return max;
    }

    /**
     * Returns the biggest sample we've seen so far.
     */
    public long getMax() {
      return min;
    }


}

