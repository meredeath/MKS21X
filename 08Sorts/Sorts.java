import java.util.Arrays.*;
public class Sorts{
    public static void main(String[] args){
	int[] anArray = new int[10];
	for(int i=0;i<anArray.length;i++){
	    anArray[i]=(int)(Math.random()*100);
	}
	System.out.println(isSorted(anArray));
	System.out.println(name());
	System.out.println(java.util.Arrays.toString(anArray));
	insertionSort(anArray);
	System.out.println(java.util.Arrays.toString(anArray));
	System.out.println(isSorted(anArray));
    }
    
    public static String name(){
	return "09.Hu.Meredith";
    }

    public static void selectionSort(int[] data){
	int min = 0;
	for(int i=0;i<data.length-1;i++){
	    min=Math.min(data[i],data[i+1]);
	}
    }

    public static void insertionSort(int[] ary){
	int index=1;
	while(index<ary.length){
	    int j=index;
	    while(j>0 && ary[j]>ary[j-1]){
		swap(ary,j,j-1);
		j=j-1;
	    }
	    index++;
	}
    }
    public static void swap(int[] ary, int a, int b){
	int temp=ary[b];
	ary[b]=ary[a];
	ary[a]=temp;
    }

    public static boolean isSorted(int[] ary){
	for(int i=0;i<ary.length-1;i++){
	    if(ary[i]>ary[i+1]){
		return false;
	    }
	}
	return true;
    }
}
