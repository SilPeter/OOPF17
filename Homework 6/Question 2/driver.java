public class driver{
    public static void main(String args[]){

        // C , I , AND G IS WRONG
        Dog d = new Dog();
        System.out.println(d.call(3));


        Object c = new Cat();
        System.out.println(c);


        Pet p = new Pet();
        System.out.println(p);

        Pet q = new Dog();
        System.out.println(q.call());

        Cat t = new Cat();
        System.out.println(t.toString("Come here, kitty"));

        

        Dog e = new Dog();
        System.out.println(e.feet());

        System.out.println("Driver ran");
    }
}
// https://www.usna.edu/Users/cs/wcbrown/courses/S11IC211/classes/L12/HW/Homework.html