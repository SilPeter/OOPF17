

class child extends parent{
    int childInt = parentInt;


    public void printInt(){
        System.out.print("Inside child: " );
        System.out.println(childInt);
        System.out.println(parentInt);
    }

}