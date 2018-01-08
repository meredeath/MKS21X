public class Barcode implements Comparable<Barcode>{
    String zipcode;
    String barcode;

    public Barcode(String zip){
	if(!isVal(zip)){
	    throw new IllegalArgumentException();
	}
	zipcode=zip;
	barcode=toCode(zip);
    }
    
    public static boolean isInt(String zip){
	try{
	    Integer.parseInt(zip);
	    return true;
	}catch(NumberFormatException e){
	    return false;
	}
    }

    public String getCode(){
	return barcode;
    }
    public String getZip(){
	return zipcode;
    }

    public String toString(){
	return getCode()+" ("+getZip()+")";
    }

    public static boolean isVal(String zipc){
	if(zipc.length()==5 && isInt(zipc)){
	    return true;
	}
	return false;
    }

    public int compareTo(Barcode other){
	return getZip().compareTo(other.getZip());
    }

    public static String toCode(String zip){
	if(!isVal(zip)){
	    throw new IllegalArgumentException();
	}
	int[] digits = new int[5];
	for(int i=0;i<5;i++){
	    digits[i]=Integer.parseInt(zip.substring(i,i+1));
	}
	return "|"+numToBar(digits[0])+
	    numToBar(digits[1])+
	    numToBar(digits[2])+
	    numToBar(digits[3])+
	    numToBar(digits[4])+
	    calcCheckSum(zip)+"|";
    }

    public static String numToBar(int num){
	if(num>9 || num<0){
	    throw new IndexOutOfBoundsException();
	}
	String[] key = new String[10];
	key[0]="||:::";
	key[1]=":::||";
	key[2]="::|:|";
	key[3]="::||:";
	key[4]=":|::|";
	key[5]=":|:|:";
	key[6]=":||::";
	key[7]="|:::|";
	key[8]="|::|:";
	key[9]="|:|::";
	return key[num];
    }
    public static String barToNum(String bar){
	String[] key = new String[10];
	key[0]="||:::";
	key[1]=":::||";
	key[2]="::|:|";
	key[3]="::||:";
	key[4]=":|::|";
	key[5]=":|:|:";
	key[6]=":||::";
	key[7]="|:::|";
	key[8]="|::|:";
	key[9]="|:|::";
	for(int i=0;i<10;i++){
	    if(bar.equals(key[i])){
		return i+"";
	    }
	}
	throw new IllegalArgumentException();
    }

    public static String calcCheckSum(String zip){
	int sum = 0;
	for(int i=0;i<5;i++){
	    sum+=Integer.parseInt(zip.substring(i,i+1));
	}
	return numToBar(sum%10);
    }
    public static boolean isCheckSumValid(String checksum, String num){
	String correct = barToNum(calcCheckSum(num));
	return correct.equals(checksum);
    }

    public static String toZip(String code){
	String number = "";
	if(code.length()!=32){
	    throw new IllegalArgumentException();
	}
	if(!code.substring(0,1).equals("|")){
	    throw new IllegalArgumentException();
	}
	if(!code.substring(code.length()-1,code.length()).equals("|")){
	    throw new IllegalArgumentException();
	}
	String newcode = code.substring(1,code.length()-1);
	for(int g=0;g<21;g+=5){
	    number+=barToNum(newcode.substring(g,g+5));
	}
	String checksum = barToNum(newcode.substring(25,30));
	if(!isCheckSumValid(checksum, number)){
	    throw new IllegalArgumentException();
	}
	return number;
    }
    
}