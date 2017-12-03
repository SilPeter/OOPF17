import java.util.*;
import java.lang.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class threads{

    public static void main(String args[]) {
        // ExecutorService exe = Executors.newFixedThreadPool(4);
        alpha a = new alpha();
        characters1 c1 = new characters1(a);

        Thread t1 = new Thread(c1);
        t1.start();
    }

}
// https://stackoverflow.com/questions/12989397/running-3-threads-in-sequence-java
class characters1 implements Runnable{
    alpha a = new alpha();

    characters1(alpha a){
        this.a = a;
    }
    public void run(){
        while(true){
            System.out.println("Not waiting!");
            a.char1();
        }
    }
    // public void run(){
    //     for(int i = 0; i < chararr.length; i++){
    //         System.out.print(chararr[i]);
    //     }
    // }
}
class alpha{
    // https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html
    char chararr1[] = new char[]{'A', 'E', 'I', 'M', 'Q', 'U', 'Y'};
    char chararr2[] = new char[]{'B', 'F', 'J', 'N', 'R', 'V', 'Z'};
    char chararr3[] = new char[]{'C', 'G', 'K', 'O', 'S', 'W'};
    char chararr4[] = new char[]{'D', 'H', 'L', 'P', 'T', 'X'};
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();
    Condition c4 = lock.newCondition();

    public void char1(){
        lock.lock();

        try{
            System.out.println("waiting...");
            wait();
        }
        catch (Throwable t) {}

        finally{
            lock.unlock();
        }
        
    }

}
/*
Write a program that has 4 separate threads. The threads will have the 
following arrays:

Thread1: A E I M Q U Y
Thread2: B F J N R V Z
Thread3: C G K O S W
ThreadD: D H L P T X

Your goal is to synchronize the threads in such a way that they print out 
all the letters of the alphabet in order.
*/