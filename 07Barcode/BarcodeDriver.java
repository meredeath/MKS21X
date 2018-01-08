public class BarcodeDriver{
    public static void main(String[] args){
	Barcode a = new Barcode("11432");
	System.out.println(a);
	//Barcode b = new Barcode("pizza");
	System.out.println(a.getCode());
	System.out.println(a.getZip());
	Barcode b = new Barcode("10282");
	System.out.println(a.compareTo(b));
	System.out.println(b.compareTo(a));
	System.out.println(Barcode.toZip("|:::||:::||:|::|::||:::|:|:::|||"));
	//System.out.println(Barcode.toZip("|:::||:::||:|::|::||:::|:|:::||"));
	System.out.println(Barcode.toCode("10282"));
    }
}
