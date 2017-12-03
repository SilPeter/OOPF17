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


public class threadedAlphabet{
    public static void main(String args[]){

        tracker tracker = new tracker();
        
        A myA = new A(tracker);
        B myB = new B(tracker);
        C myC = new C(tracker);
        D myD = new D(tracker);

        Thread t1 = new Thread(myA);
        Thread t2 = new Thread(myB);
        Thread t3 = new Thread(myC);
        Thread t4 = new Thread(myD);

        t1.start();
		t2.start();
		t3.start();
		t4.start();
    }
}
class tracker{
    private int tracker = 1;
    public int getT(){
        return tracker;
    }
    public void setT(int tracker){
        this.tracker = tracker;
    }
}
class A implements Runnable{
    char chararr1[] = new char[]{'A', 'E', 'I', 'M', 'Q', 'U', 'Y'};
    tracker tracker;
    A(tracker tracker){
        this.tracker = tracker;
    }
    @Override
    public void run(){
        try{
            synchronized(tracker){
                for(int i = 0; i < chararr1.length; i++){
                    while(tracker.getT() != 1){
                        tracker.wait();
                    }

                    System.out.print(chararr1[i]);
                    tracker.setT(2);
                    
                    tracker.notifyAll();
                }
            }
        } catch (Throwable th) {}
    } // end run

}

class B implements Runnable{
    char chararr2[] = new char[]{'B', 'F', 'J', 'N', 'R', 'V', 'Z'};
    tracker tracker;
    B(tracker tracker){
        this.tracker = tracker;
    }
    @Override
    public void run(){
        try{
            synchronized(tracker){
                for(int i = 0; i < chararr2.length; i++){
                    while(tracker.getT() != 2){
                        tracker.wait();
                    }

                    System.out.print(chararr2[i]);
                    tracker.setT(3);
                    tracker.notifyAll();
                }
            }
        } catch (Throwable th) {}
    } // end run

}

class C implements Runnable{
    char chararr3[] = new char[]{'C', 'G', 'K', 'O', 'S', 'W'};
    tracker tracker;
    C(tracker tracker){
        this.tracker = tracker;
    }
    @Override
    public void run(){
        try{
            synchronized(tracker){
                for(int i = 0; i < chararr3.length; i++){
                    while(tracker.getT() != 3){
                        tracker.wait();
                    }

                    System.out.print(chararr3[i]);
                    tracker.setT(4);
                    tracker.notifyAll();
                }
            }
        } catch (Throwable th) {}
    } // end run

}

class D implements Runnable{
    char chararr4[] = new char[]{'D', 'H', 'L', 'P', 'T', 'X'};
    tracker tracker;
    D(tracker tracker){
        this.tracker = tracker;
    }
    @Override
    public void run(){
        try{
            synchronized(tracker){
                for(int i = 0; i < chararr4.length; i++){
                    while(tracker.getT() != 4){
                        tracker.wait();
                    }

                    System.out.print(chararr4[i]);
                    tracker.setT(1);
                    tracker.notifyAll();
                }
            }
        } catch (Throwable th) {}
    } // end run

}
