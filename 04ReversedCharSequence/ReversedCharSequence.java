public class ReversedCharSequence implements CharSequence{
    public static void main(String[] args){
	ReversedCharSequence a = new ReversedCharSequence("hello");
	System.out.println(a);
	System.out.println(a.length());
	System.out.println(a.charAt(1));
	System.out.println(a.subSequence(1,3));
    }

    private String original; //the original string
    private String reversed; //the reversed version

    //constructs a reversed version of the string
    public ReversedCharSequence(String regular){
	if(regular==null){
	    throw new UnsupportedOperationException();
	}
	original=regular;
	reversed="";
	for(int i = regular.length()-1;i>=0;i--){
	    reversed+=original.charAt(i);
	}
    }

    //returns the length of the reversed char sequence
    public int length(){
	return reversed.length();
    }

    //returns a charAt for a specified index
    public char charAt(int index){
	return reversed.charAt(index);
    }
    
    //is like substring, but for ReversedCharSequences
    public ReversedCharSequence subSequence(int start, int end){
	String result = original.substring(start,end);
	ReversedCharSequence ans = new ReversedCharSequence(result);
	return ans;
    }

    //just your regular toString function
    public String toString(){
	return reversed;
    }
}