
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
class MyThread3 extends Thread {

    int[] a;

    public MyThread3(String name, int[] a) {
        super(name);
        this.a = a;
    }

    public void run() {
        if (a.length > 1) {

            int[] x = copyArray(a, 0, (a.length - 1) / 2);

            int[] y = copyArray(a, (a.length - 1) / 2 + 1, a.length - 1);
            MyThread3 thread2=new MyThread3("Thread 2", x);
            MyThread3 thread3=new MyThread3("Thread 3", y);
            thread2.start();
            thread3.start();
            try {
                thread2.join();
                thread3.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread3.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            a=merge(thread2.a,thread3.a);
        }
    }

    public int[] merge(int[] a, int[] b) {
        int c[] = new int[a.length + b.length];
        int i = 0, j = 0;
        for (int k = 0; k < c.length; k++) {
            if (i == a.length) {
                c[k] = b[j++];
            } else if (j == b.length) {
                c[k] = a[i++];
            } else {
                if (a[i] < b[j]) {
                    c[k] = a[i++];
                } else {
                    c[k] = b[j++];
                }
            }
        }
        return c;
    }

     int[] copyArray(int[] a, int x, int y) {
        int b[] = new int[y - x + 1];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[x++];
        }
        return b;
    }

}

public class Task3 {

    public static void main(String[] args) {
        int[] array = {3, 456, 34, 546, 67, 34, 667, 786, 53, 42, 67, 78, 42, 67, 89, 1};
        MyThread3 thread=new MyThread3("Thread 1", array);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Task3.class.getName()).log(Level.SEVERE, null, ex);
        }
        array=thread.a;
        printArray(array);
    }

    static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
