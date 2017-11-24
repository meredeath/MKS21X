public class OrderedSuperArray extends SuperArray{
    public OrderedSuperArray(){
	super();
    }
    public void add(int index, String value){
	add(value);
    }
    /*
    public boolean add(String value){
	int i = data.length/2;
	String[] a = data;
	if(a[i]==null){
	    continue;
	}
	if(a[i].compareTo(value)==0){
	    super.add(i,value);
	}
	if(a[i].compareTo(value)>0){
	    
	return true;
	}
    }
    */
    
    public OrderedSuperArray slice(int start, int end){
	OrderedSuperArray result = new String[end-start];
	int index=0;
	for(int i=start;i<end;i++){
	    result[index]=data()[i];
	    index++;
	}
	return result;
    }
}