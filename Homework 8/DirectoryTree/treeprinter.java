import java.io.*;
// import java.nio.file.*;

public class treeprinter{
    
    public static void main(String args[]){
        File root = new File("C:/Users/peter/Documents/GitHub/OOPF17");
        File root2 = new File("C:/Users/peter/");
        File [] list = root.listFiles();
        recursiveTree(root, 0);
        // tree(root);

    }
    
    public static void recursiveTree(File root, int depth){
        File [] files = root.listFiles();
        for(int i = 0; i < files.length; i++){
            if(files[i].isDirectory()){
                spacing(files[i], depth);
                recursiveTree(files[i], depth + 1);
            } else {
                spacing(files[i], depth);
            }
        }
    }
    public static void spacing(File file, int depth){
        for(int i = 0; i < depth; i++){
            System.out.print("\t");
        }
        System.out.println(file.getName());
    }

    // public static void tree(File root){
    //     File [] list = root.listFiles();
    //     if(list == null){
    //         return;
    //     }
    //     for(File f : list){
    //         if(f.isDirectory()){
    //             tree(f.getAbsoluteFile());
    //             System.out.println("Dir:" + f.getAbsoluteFile());
    //         } else {
    //             System.out.println("\tFile:" + f.getAbsoluteFile());
    //         }
    //     }
    // }    
}

/*
Write a program that goes through your file system and outputs a tree 
diagram of all of your directories in a file called dir_tree.txt. The 
methods in the File class will probably come in very handy. For a sample 
output, check out this webpage: http://www.computerhope.com/treehlp.htm 
Make sure you get the indentation right/tree branches right.

Also, figure out why the program stopped running when we used 
Thread.sleep(), and we right clicked/marked the DOS window. 

// http://www.javapractices.com/topic/TopicAction.do?Id=68
// https://rosettacode.org/wiki/Walk_a_directory/Recursively#Java

*/
