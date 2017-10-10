

class child extends parent{
    int childInt = parentInt;


    public void printInt(){
        System.out.print("Inside child: " );
        System.out.print(childInt + "\t" + parentInt);
        // prints both the int from child class and parent class
    }

}