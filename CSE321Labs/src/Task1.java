
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
class Thread1 extends Thread{
    public Thread1(String name){
        super(name);
    }
    public void run(){
        for(int i=1;i<=10;i++)
            System.out.println(i+" printed from "+Thread.currentThread().getName());
        
        Thread2 thread2= new Thread2("Thread 2",11,20);
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=21;i<=30;i++)
            System.out.println(i+" printed from "+Thread.currentThread().getName());
    }
}
class Thread2 extends Thread{
    int i,j;
    public Thread2(String name, int i, int j){
        super(name);
        this.i=i;
        this.j=j;
    }
    public void run(){
        while(i<=j){
            System.out.println((i++)+" printed from "+Thread.currentThread().getName());
        }
    }
}


public class Task1{
    public static void main (String[]args){
      Thread1 thread1= new Thread1("Thread 1");
      thread1.start();
    }
}

