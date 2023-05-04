
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ShamimMSAS7
 */
class MyThread2 extends Thread {

    int start, end;
    int dividedNumber = -1, numberOfDivisors = -1;

    public MyThread2(String name, int i, int j) {
        super(name);
        start = i;
        end = j;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            int count = 1;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count > numberOfDivisors) {
                numberOfDivisors = count;
                dividedNumber = i;
            }
        }
    }

    public int[] array() {
        int[] array = {dividedNumber, numberOfDivisors};
        return array;
    }

}

public class Task2Bonus {

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        MyThread2 thread0 = new MyThread2("Thread-0", 1, 10000);
        MyThread2 thread1 = new MyThread2("Thread-1", 10001, 20000);
        MyThread2 thread2 = new MyThread2("Thread-2", 20001, 30000);
        MyThread2 thread3 = new MyThread2("Thread-3", 30001, 40000);
        MyThread2 thread4 = new MyThread2("Thread-4", 40001, 50000);
        MyThread2 thread5 = new MyThread2("Thread-5", 50001, 60000);
        MyThread2 thread6 = new MyThread2("Thread-6", 60001, 70000);
        MyThread2 thread7 = new MyThread2("Thread-7", 70001, 80000);
        MyThread2 thread8 = new MyThread2("Thread-8", 80001, 90000);
        MyThread2 thread9 = new MyThread2("Thread-9", 90001, 100000);

        MyThread2[] threads = {thread0, thread1, thread2, thread3, thread4, thread5, thread6, thread7, thread8, thread9};
        for (int i = 0; i < 10; i++) {
            //threads[i].start();
            threads[i].run();
        }

        try {
            for (int i = 0; i < 10; i++) {
                threads[i].join();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Task2Bonus.class.getName()).log(Level.SEVERE, null, ex);
        }

        int[] dividedNumbersArray = new int[10];
        int[] numberOfDivisorsArray = new int[10];
        
        int max=-1, maxIndex=-1;
        for(int i=0;i<10;i++){
          int [] array=threads[i].array();
          dividedNumbersArray[i]=array[0];
          numberOfDivisorsArray[i]=array[1];
          if(array[1]>=max){
              max=array[1];
              maxIndex=i;
          }
          System.out.println("From thread "+i+", the number "+dividedNumbersArray[i]+" has maximum number of divisors and the number of divisors is "+numberOfDivisorsArray[i]);
        }
        
        System.out.println("*************************************************");
        System.out.println("After merging the results of all threads,");
        System.out.println("The number "+dividedNumbersArray[maxIndex]+" has maximum number of divisors and the number of divisors is "+numberOfDivisorsArray[maxIndex]);
    
        long end=System.currentTimeMillis();
        System.out.println("*************************************************");
        System.out.println("Total execution time "+(end-start));
    
    }
}
