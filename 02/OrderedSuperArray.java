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

    /*
    public boolean add(String value){
	if (size == 0){
	    return false;
	}
	int lowerBound = 0;
	int upperBound = size-1;
	int curIn = 0;
	while (true) {
	    curIn = (upperBound + lowerBound) / 2;
	    if (data[curIn].compareTo(value)==0) {
		super.add(curIn,value);
		return true;
	    } else if (data[curIn].compareTo(value)<0) {
		lowerBound = curIn + 1; // its in the upper
		if (lowerBound > upperBound){
		    super.add(curIn + 1,value);
		    return true;
	    } else {
		upperBound = curIn - 1; // its in the lower
		if (lowerBound > upperBound){
		    super.add(curIn,value);
		    return true;
		}
		}
	    }
	}
    }
    */
    public boolean add(String value){
	if(size()==0){
	    super.add(value);
	    return true;
	}
	/*
	if(size()==1){
	    if(data()[0].compareTo(value)<0){
		super.add(value);
		return true;
	    }else{
		super.add(0,value);
		return true;
	    }
	}
	*/
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

    /*
    public OrderedSuperArray slice(int start, int end){
	OrderedSuperArray result = new OrderedSuperArray(end-start);
	int index=0;
	for(int i=start;i<end;i++){
	    result.set(index,get(i));
	    index++;
	}
	return result;
    }


    public boolean add(String value){
	for(int i=0;i<size;i++){
	    if(this.get(i)==null){
		continue;
	    }
	    if(this.get(i).compareTo(value)>=0){
		super.add(i,value);
		return true;
	    }
	}
	super.add(value);
	return true;
    }
    */
}