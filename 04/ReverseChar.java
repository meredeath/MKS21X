import java.lang.CharSequence;
public class ReverseChar implements CharSequence{
    public static void main(String[] args){
	ReverseChar a = new ReverseChar("Hello");
	System.out.println(a);
    }
    String chars="";
    public ReverseChar(String s){
	chars=s.reverse();
    }
    public char charAt(int index){
	return chars.charAt(index);
    }
    public int length(){
	return chars.length();
    }
    public CharSequence subSequence(int start, int end){
	CharSequence 1 = new ReverseCharSequence("Hi");
	return chars;
    }
    public String toString(){
	return chars;
    }
    public CharSequence reverse(String s){
    }
}
