
/*
Question 1: Access a protected variable of the parent class from a child 
class. Make sure that the parent and the child classes are in different 
packages.
*/


public class driver {
    public static void main(String args[]){

        grabber funcgrabber = new grabber();
        funcgrabber.grab();
    }

}

class grabber extends child{
    public void grab(){
        printInt();
    }
}
