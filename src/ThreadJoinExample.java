import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadJoinExample {


    public static void main(String[] args) throws InterruptedException {
//            List<Long> inputNumbers = Arrays.asList(100000000L, 3435L, 35435L, 2324L, 4656L, 23L, 5556L);
//
//            List<Thread> list =  new ArrayList<Thread>(inputNumbers.size());
//
//            for(Long  number : inputNumbers) {
//                list.add(new FactorialThread(number));
//            }
//            for(Thread  thread : list) {
//                System.out.println("starting thread  ::"+ thread.getName());
//                thread.start();
//            }

    }

    public static class FactorialThread {
        //   extends Thread {
         /*   private long inputNumber;
            private BigInteger result ;
            private  boolean isCompleted = false;

            public FactorialThread(long inputNumber) {
                this.inputNumber = inputNumber;
            }

            @Override
            public void run() {
                  result =  factorialCal (inputNumber);
                 System.out.println("result ::"+ result);
                 this.isCompleted = true;
            }

            private BigInteger factorialCal(long inputNumber) {
                BigInteger resultVal = BigInteger.ONE;
                if (n == 0)
                    return 1;
                if(inputNumber > 0 ) {
                    resultVal =  inputNumber * (factorialCal(inputNumber - 1));
                }
                return resultVal;
            }

            public BigInteger getResult() {
                return result;
            }

            public void setResult(BigInteger result) {
                this.result = result;
            }

            public boolean isCompleted() {
                return isCompleted;
            }

            public void setCompleted(boolean completed) {
                isCompleted = completed;
            }
        }*/
    }
}
