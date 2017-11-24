public class DriverOrdered{
    public static void main(String[] args){
	OrderedSuperArray a = new OrderedSuperArray();
	System.out.println(a);
	OrderedSuperArray test = a.slice(4,7);
	System.out.println(test);
    }
}