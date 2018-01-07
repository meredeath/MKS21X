public class OrderedSuperArray extends SuperArray{
    public OrderedSuperArray(){
    }
    public OrderedSuperArray(int length){
	super(length);
    }
    public OrderedSuperArray(String[] ary){
	for(int i=0;i<ary.length;i++){
	    add(ary[i]);
	}
    }
	
    public void add(int index, String value){
	add(value);
    }

    public boolean add(String value){
	if(size()==0){
	    super.add(value);
	    return true;
	}
	int high = size();
	int low = 0;
	int guess = 0;
	while(high>low){
	    guess = (high+low)/2;
	    if(data()[guess].compareTo(value)>0){
		high = guess-1;
	    }else if(data()[guess].compareTo(value)<0){
		low = guess+1;
	    }else{
		super.add(guess,value);
		return true;
	    }
	}
	super.add(low,value);
	return true;
    }
}