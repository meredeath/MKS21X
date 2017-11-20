public class SuperArray{

    private String[] data;
    private int size;

    public SuperArray(){
	data = new int[];
    }

    public void clear(){
	for (int i = 0; i<data.length; i++)
	    data[i] = 0.0;
    }
    public int size(){
	return data.length+1;
    }
    public void add(int index, String element){
	size = data.size();
    }
    
}
