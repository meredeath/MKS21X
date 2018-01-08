import java.util.Iterator;
public class SuperArrayIterator implements Iterator<String>{
    SuperArray sup;
    int current;
    int end;

    public SuperArrayIterator(SuperArray input){
	sup = input;
	current=0;
	end=input.size();
    }
    
    public void remove(){
	throw new UnsupportedOperationException();
    }

    public String next(){
	if(hasNext()){
	    current++;
	}else{
	    System.exit(0);
	}
	return sup.get(current-1);
    }

    public boolean hasNext(){
	return current <=end;
    }
}