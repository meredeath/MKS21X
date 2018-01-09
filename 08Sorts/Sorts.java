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
	//selectionSort(anArray);
	//bogoSort(anArray);
	//insertionSort(anArray);
	bubbleSort(anArray);
	System.out.println(java.util.Arrays.toString(anArray));
	System.out.println(isSorted(anArray));
	/*
	int[] anArr = new int[4];
	anArr[0]=3;
	anArr[1]=2;
	anArr[2]=0;
	anArr[3]=1;
	selectionSort(anArr);
	System.out.println(java.util.Arrays.toString(anArr));
	System.out.println(isSorted(anArr));
	*/
    }
    
    public static String name(){
	return "09.Hu.Meredith";
    }

    public static void selectionSort(int[] data){
	int minIndex=0;
	int min=0;
	for(int i=0;i<data.length;i++){
	    min=data[i];
	    for(int g=i;g<data.length;g++){
		if(data[g]<=min){
		    minIndex=g;
		    min=data[g];
		}
	    }
	    System.out.println(data[minIndex]);
	    System.out.println(min);
	    swap(data,minIndex,i);
	}
	return;
	
    }

    public static void insertionSort(int[] ary){
	int index=1;
	while(index<ary.length){
	    int j=index;
	    while(j>0 && ary[j-1]>ary[j]){
		swap(ary,j,j-1);
		j=j-1;
	    }
	    index++;
	}
    }
    public static void bogoSort(int[] ary){
	while(!isSorted(ary)){
	    for(int i=0;i<ary.length;i++){
		int temp = ary[i];
		int newSpot = (int)(Math.random()*ary.length);
		ary[i]=ary[newSpot];
		ary[newSpot]=temp;
	    }
	}
    }
    public static void bubbleSort(int[] ary){
	for(int i=0;i<ary.length;i++){
	    for(int g=0;g<ary.length-i-1;g++){
		if(ary[g]>=ary[g+1]){
		    swap(ary,g,g+1);
		}
	    }
	    if(isSorted(ary)){
		return;
	    }
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
