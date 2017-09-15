class MyString{
    private String string;

    public MyString(char[] chars){
        string = new String(chars);
        /* java8api
            String(char[] value)
            Allocates a new String so that it represents the sequence of characters currently contained in the character array argument.
        */
        /*
        for(int i = 0; i < chars.length; i++){
            this.string += chars[1];
        }
        */
    }
    public char charAt(int index){
        
        if(index < 0 || string.length() < index){
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        return string.charAt(index);
    }

    public int length(){
        return string.length();
    }
/*
    public MyString toLowerCase();
    public MyString toUpperCase();
*/
    public boolean equals(MyString s){
        if(s.length() == string.length()){
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) != string.charAt(i)){
                    return false;
                }
            }
            return true;
        }
        return false;
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
