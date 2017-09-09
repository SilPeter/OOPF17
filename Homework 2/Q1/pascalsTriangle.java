/*
pascal's triangle / pyramid
*/
import java.util.*;
public class pascalsTriangle{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Height of the pyramid? ");
        int height = input.nextInt();
        printer(height);

        input.close();
    }

    public static void printer(int height){
        int tab = height;
        for (int i = 0; i < height ; i++){
            int value = 1;
            // indentions
            for (int j = 0; j < tab - 1; j++){
                System.out.printf("  "); // 2 space                
            }
            tab--;

            // value printing. first half up to height
            for (int k = 1; k <= i; k++){ 

                System.out.printf("%d ", value);
                value++;
            }
            //second half from height to 1
            for (int l = height - 1; l >= 0; l--){
                if(value == 0){ break; }
                System.out.printf("%d ", value);
                value--;
            }
            System.out.println();
        }
    }
}
