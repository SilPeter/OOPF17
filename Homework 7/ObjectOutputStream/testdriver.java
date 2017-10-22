// http://www.java67.com/2012/08/what-is-transient-variable-in-java.html
// http://javabeginnerstutorial.com/core-java-tutorial/transient-vs-static-variable-java/
// transient variables doesn't allow you to save the state of a variable

// static variables are ignored during serialization and cannot be serialized
// if you remove the outputstream lines(24-30), and try to read in through inputstreams, you'll get its original initialized value rather then the declared value
/* below is original without commenting out
C:\Users\peter\Documents\GitHub\OOPF17\Homework 7\ObjectOutputStream>javac testdriver.java && java testdriver
stdriver
firstInt: 1 secondInt: 2 thirdInt: 3
firstInt: 0 secondInt: 2 thirdInt: 3                                                                        r
// below is after removing the outputstreams (24-30)
C:\Users\peter\Documents\GitHub\OOPF17\Homework 7\ObjectOutputStream>javac testdriver.java && java testdrive
stdriver
firstInt: 0 secondInt: 999 thirdInt: 999
*/

import java.io.*;
import java.util.*;

public class testdriver{

    public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException{
        // FileOutputStream fos = new FileOutputStream("output1.txt");
        // ObjectOutputStream oos = new ObjectOutputStream(fos);

        // someClass myclass = new someClass(1, 2, 3);
        // System.out.println(myclass);
        // oos.writeObject(myclass);
        // oos.flush();

        FileInputStream fip = new FileInputStream("output1.txt");
        ObjectInputStream ois = new ObjectInputStream(fip);

        someClass myotherclass = (someClass)ois.readObject();
        System.out.println(myotherclass);

    }

}
class someClass implements Serializable{
    transient int firstInt = 999;
    static int secondInt = 999;
    static transient int thirdInt = 999;

    public someClass(int firstInt, int secondInt, int thirdInt){
        this.firstInt = firstInt;
        this.secondInt = secondInt;
        this.thirdInt = thirdInt;
    }
    
    public String toString(){
        return "firstInt: " + firstInt + " secondInt: " + secondInt + " thirdInt: " + thirdInt;
    }
}
/*
If I remember correctly, ObjectOutputStream is supposed to ignore 
transient and static vatiables. We verified that the transient values 
weren't written out to the file in our demonstration, but I couldn't 
get the static variable to behave properly. 

Figure out what the correct 
behavior is supposed to be for static vatiables, and then write a 
demonstration program that shows that behavior.
*/