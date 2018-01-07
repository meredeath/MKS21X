import java.lang.UnsupportedOperationException;
public class SuperArray{
    private String[] data;
    private int size;

    public SuperArray(){
	data = new String[10];
	size = 0;
    }
    public SuperArray(int length){
	data = new String[length];
	size = 0;
    }

    public void clear(){
	for(int i=0;i<data.length;i++){
	    data[i]=null;
	}
	size=0;
    }

    public int size(){
	return size;
    }

    public String[] data(){
	return data;
    }

    public boolean isEmpty(){
	return size==0;
    }

    public String get(int index){
	if(index<0||index>= size()){
	    throw new UnsupportedOperationException();
	}
	else
	    return data[index];
    }

    public String toString(){
	String result = "[";
	int index = 0;
	while(index<data.length-1){
	    result += data[index]+" ,";
	    index++;
	}
	result += data[data.length-1]+"]";
	return result;
    }

    public String set(int index, String element){
	if(index<0||index>=size()){
	    throw new UnsupportedOperationException();
	}
	String old = get(index);
	data[index] = element;
	return old;
    }

    public void resize(){
	String[] newone = new String[data.length*2];
	for (int i=0;i<data.length;i++){
	    newone[i]=data[i];
	}
	data = newone;
    }

    public boolean add(String element){
	if(size==data.length){
	    resize();
	}
	data[size]=element;
	size++;
	return true;
    }

    public boolean contains(String target){
	for(int i=0;i<data.length;i++){
	    if(data[i]==null)
		continue;
	    if(data[i].equals(target))
		return true;
	}
	return false;
    }

    public int indexOf(String target){
	for(int i=0;i<data.length;i++){
	    if(data[i]==null)
		continue;
	    if(data[i].equals(target))
		return i;
	}
	System.out.println("not found");
	return -1;
    }

    public int lastIndexOf(String target){
	int index = 0;
	for(int i=0;i<data.length;i++){
	    if(data[i]==null){
		continue;
	    }
	    if(data[i].equals(target)){
		index = i;
	    }
	}
	if(index==0){
	    throw new UnsupportedOperationException();
	}
	return index;
    }
    
    public void add(int index, String element) {
	if(index<0||index>size()){
	    throw new UnsupportedOperationException();
	}
	if(size==data.length){
	    resize();
	}
	String[] newAry = new String[data.length];
        for (int x = 0; x <size(); x++){
		if (x <index){
		    newAry[x]=data[x];
		}
		if(x>=index){
		    newAry[x+1]=data[x];
		}
        }
	newAry[index]=element;
        data = newAry;
	size++;
    }

    public String remove(int index){
	if(index<0||index>size()){
	    throw new UnsupportedOperationException();
	}
	String stuff = get(index);
	for(int i=index;i<data.length-1;i++){
	    data[i]=data[i+1];
	}
	size-=1;
	data[data.length-1]=null;
	return stuff;
    }
    
    public boolean remove(String element){
	/*
	if(!contains(element)){
	    return false;
	}else{
	    remove(indexOf(element));
	}
	return true;
	*/
	for(int i=0;i<size();i++){
	    if(data[i].equals(element)){
		remove(i);
		return true;
	    }
	}
	return false;
    }

    public SuperArray slice(int start, int end){
	SuperArray result = new SuperArray(end-start);
	int index=0;
	for(int i=start;i<end;i++){
	    result.set(index,get(i));
	    index++;
	}
	return result;
    }
}