
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
class MyThread extends Thread {

    int start, end;
    int dividedNumber = -1, numberOfDivisors = -1;

    public MyThread(String name, int i, int j) {
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

public class Task2 {

    public static void main(String[] args) {
        MyThread thread0 = new MyThread("Thread-0", 1, 10000);
        MyThread thread1 = new MyThread("Thread-1", 10001, 20000);
        MyThread thread2 = new MyThread("Thread-2", 20001, 30000);
        MyThread thread3 = new MyThread("Thread-3", 30001, 40000);
        MyThread thread4 = new MyThread("Thread-4", 40001, 50000);
        MyThread thread5 = new MyThread("Thread-5", 50001, 60000);
        MyThread thread6 = new MyThread("Thread-6", 60001, 70000);
        MyThread thread7 = new MyThread("Thread-7", 70001, 80000);
        MyThread thread8 = new MyThread("Thread-8", 80001, 90000);
        MyThread thread9 = new MyThread("Thread-9", 90001, 100000);

        MyThread[] threads = {thread0, thread1, thread2, thread3, thread4, thread5, thread6, thread7, thread8, thread9};
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }

        try {
            for (int i = 0; i < 10; i++) {
                threads[i].join();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Task2.class.getName()).log(Level.SEVERE, null, ex);
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
    }
}
