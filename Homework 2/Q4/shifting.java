
public class shifting{
    public static void main(String args[]){
        int x = 4282;
        for(int i=0;i<35;i++){
            System.out.printf("%d\t\t%32s\n",i,Integer.toBinaryString(x>>>i));
        }
/*
Bitwise operation

Arithmetic shift
*/
        
        
        for(int i=0;i<35;i++){
            System.out.printf("%d\t\t%32s\n",i,Integer.toBinaryString(x));
            x = x >>> i;
        }
    }
}
