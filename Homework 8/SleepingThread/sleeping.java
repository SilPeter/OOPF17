// https://superuser.com/questions/459609/what-does-it-do-exactly-if-i-click-in-the-window-of-cmd

public class sleeping{
    public static void main(String args[]){
        say mysay = new say();
        Thread th1 = new Thread(mysay);
        th1.start();
    }
}

class say extends Thread {
    public void run (){
        try{
            for(int i = 0; i < 1000; i++){
                Thread.sleep(5000);
                System.out.print("Lalala ");
            }
        } catch (Throwable th){ }
    }
}