public class Sorts{
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
	int temp=ary[a];
	ary[a]=ary[b];
	ary[b]=temp;
    }
}
