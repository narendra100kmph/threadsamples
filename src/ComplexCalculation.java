import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ComplexCalculation {

    public static  void  main(String args[]){

         calculateResult( BigInteger.valueOf(2), BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(3));
    }

    public static BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        BigInteger result = BigInteger.ZERO;

        List<PowerCalculatingThread> threadList = new ArrayList<PowerCalculatingThread>();

        threadList.add(new PowerCalculatingThread(base1, power1));
        threadList.add(new PowerCalculatingThread(base2, power2));

        for (PowerCalculatingThread thread : threadList) {
            thread.start();
        }

        for (PowerCalculatingThread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        for (PowerCalculatingThread thread : threadList) {
            result = result.add(thread.getResultVal());

        }

        System.out.println("Total Result :" + result);
        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger resultVal = BigInteger.ZERO;
        BigInteger result = BigInteger.ONE;
        private final BigInteger base;
        private final BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {

            resultVal = pow(base, power);
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            for(BigInteger i = BigInteger.ZERO; i.compareTo(power) !=0; i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }
            return result ;
        }

        public BigInteger getResultVal() {
            return resultVal;
        }

        public void setResultVal(BigInteger resultVal) {
            this.resultVal = resultVal;
        }
    }
}