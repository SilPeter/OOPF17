class MyString{
    private String string;
    private char [] characters;

    public MyString(char[] chars){
        
        /* java8api     string = new String(chars);
            String(char[] value)
            Allocates a new String so that it represents the sequence of characters currently contained in the character array argument.
        */

        for(int i = 0; i < chars.length; i++){
            characters[i] = chars[i];
        }

    }
    public char charAt(int index){
        return characters[index];
    }

    public int length(){
        return characters.length;
    }
/*
    public MyString toLowerCase();
    public MyString toUpperCase();
*/
    public boolean equals(MyString s){
        if(s.length() == characters.length){
            for(int i = 0; i < characters.length; i++){
                if(s.charAt(i) != characters[i]){
                    return false;
                }
            }
            return true;
        }
        return false;
        /*
        if(s.length() == string.length()){
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) != string.charAt(i)){
                    return false;
                }
            }
            return true;
        }
        return false;
        */
    }

/*
    public MyString getMyString(){
        MyString my_str = new MyString(string);
        return my_str;
    }
*/

    public String toString(){
        String my_str = new String();
        for(int i = 0; i < string.length(); i++){
            my_str += string.charAt(i);
        }
        return my_str;
    }
}

public class StringClass{
    public static void main(String args[]){
        char [] charArray = {'h', 'e', 'l', 'l', 'o'};
        MyString s1 = new MyString(charArray);
        System.out.println(s1.charAt(6));
        //System.out.println(s1.getMyString());
        
        }

}
