public class OrderedSuperArray extends SuperArray{

    public OrderedSuperArray(){
	super();
    }

    public void add(int index, String value){
	add(value);
    }
    public boolean add(String value){
	if(size()==0){
	    String[] oneSlotArray = {value};
	    return true;
	}
        for(int i=0;i<size();i++){
	    if(data[i].compareTo(value)<0 && data[i+1].compareTo(value)>0){
		super.add(i+1,value);
		return true;
	    }
	}
	return false;
    }
}
