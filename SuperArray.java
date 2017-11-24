public class SuperArray{
    private String[] data;
    private int size;

    public SuperArray(){
	data = new String[10];
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
	if(index<0||index>= data.length){
	    System.out.println("error: index out of range");
	    return null;
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
	if(index<0||index>=data.length){
	    System.out.println("error, index not valid");
	    return null;
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
	String[] a = new String[data.length+1];
	    for(int i=0;i<data.length;i++){
		a[i]=data[i];
	    }
	a[a.length-1]=element;
	data = a;
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
	return 0;
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
	    System.out.println("your specified value is not in the array, sorry");
	}
	return index;
    }

    public void add(int index, String element) {
        String[] newAry = new String[data.length + 1];
	if(index<0||index>data.length){
	    System.out.println("error, index out of range");
		}
        for (int x = 0; x <data.length; x++){
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
	if(index<0||index>=data.length){
	    System.out.println("error: index out of range");
	    return null;
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
	if(!contains(element)){
	    return false;
	}else{
	    remove(indexOf(element));
	}
	return true;
    }

    public String[] slice(int start, int end){
	String[] result = new String[end-start];
	int index=0;
	for(int i=start;i<end;i++){
	    result[index]=get(i);
	    index++;
	}
	return result;
    }
}