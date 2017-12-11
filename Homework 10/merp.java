import java.lang.reflect.*;
import java.io.*;
import java.util.*;

public class merp{
    public static void main(String args[]) throws Throwable{
        File root = new File("C:/Users/peter/Documents/GitHub/OOPF17/Homework 10/plugin");

        findPlugin(root);
        System.out.print("Which would you like to run? ");
        Scanner input = new Scanner(System.in);
        int choice = 0;
        
        choice = input.nextInt();
        if(choice < plugins.size() && choice >= 0){
            usePlugin(root, choice);
        } else {
            System.out.println("invalid");
        }

        input.close();
    }
    static int counter = 0;
    static ArrayList<String> plugins = new ArrayList<String>();

    public static void usePlugin(File root, int choice) throws Throwable{
        File [] files = root.listFiles();
        for(int i = 0; i < files.length; i++){
            if(files[i].isDirectory()){
                usePlugin(files[i], choice);
            } else if(files[i].isFile()){
/*--------------------------------------------------------
                // Class<?> myclass = Class.forName(plugins.get(choice));
                // // Error
class pathing issue
                // Class<?> myclass = Class.forName("alpha");
                // Error regardless
--------------------------------------------------------*/
                
                Object myinstance = myclass.newInstance();
                Method mymethod1 = myclass.getMethod("whoSaysHello");
                Method mymethod2 = myclass.getMethod("whoSaysBye");
                mymethod1.invoke(myinstance);
                mymethod2.invoke(myinstance);
            }
        }
    }
    public static void findPlugin(File root){
        // this method lists the available plugins found from root 
        File [] files = root.listFiles();
        for(File file: files){
            if(file.isDirectory()){
                findPlugin(file);
            } else if(file.isFile()){
                System.out.println(counter + ") " + file.getName());
                plugins.add(counter, file.getName());
                counter++;
            }
        } 
    }
    
}
/*
Write a program that can handle plugins.

Your plugin interface is:

public abstract class myplugin{
        public void whoSaysHello(){}
        public void whoSaysBye(){}
}

Create two separate plugins from that abstract class. Place them in a
directory called plugin.

Your main program will search through the plugin directory looking for
plugin names, it'll then give the user an option whether they want to
execute the first plugin or the second plugin (print the plugin names on
the screen) And depending on the choice, it'll execute the two functions
in the chosen plugin.

*/