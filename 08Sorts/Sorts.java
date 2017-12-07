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
}
