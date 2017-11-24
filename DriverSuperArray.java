public class DriverSuperArray{
    public static void main(String[] args){
	SuperArray a = new SuperArray();
	System.out.println("SuperArray a = " +a);
	//should be all null
	System.out.println("element 1 of a = " + a.get(1));//should be null
	System.out.println("is a empty? " + a.isEmpty());//should be true;
	a.resize();
	System.out.println("a after resize: "+a);//should be all null, but with more elements this time
	a.set(1,"banana");
	System.out.println("changing element and reprinting: "+a);
	a.set(200,"monkey");//should be error, index not valid
	a.add("chimpanzee");
	System.out.println(a);//last element should be chimpanzee
	a.add("bongo");
	System.out.println(a);//array should be really long and the last element should be bongo
	System.out.println(a.contains("happy"));//should be false
	System.out.println(a.contains("chimpanzee"));//should be true
	System.out.println(a.indexOf("chimpanzee"));//should be 20
	System.out.println(a.indexOf("demorgan"));//should be 0, error message
	System.out.println(a.lastIndexOf("chimpanzee"));//should be 20
	a.set(15,"chimpanzee");
	System.out.println(a.lastIndexOf("chimpanzee"));//should still be 20
	System.out.println(a);//should have chimp at index 15
	a.add(15,"hello");
	System.out.println(a);//should have hello and chimpanzee next to each other
	System.out.println(a.remove(15));//should be hello
	System.out.println(a);
	System.out.println(a.remove("chimpanzee"));//should be true
	System.out.println(a);//should not have chimpanzee
	String[] test = a.slice(0,3);
	System.out.println(test);
	System.out.println(a.get(4));
    }
}