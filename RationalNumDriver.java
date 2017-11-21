public class RationalNumDriver{
    public static void main(String[] args){
	RationalNumber a = new RationalNumber(1,2);

	System.out.println("numerator of a is: ");
	System.out.println(a.getNumerator());//should be 1

	System.out.println("denominator of a is: ");
	System.out.println(a.getDenominator());//should be 2

	System.out.println("reciprocal of a is: ");
	System.out.println(a.reciprocal());//should be 2/1

	RationalNumber b = new RationalNumber(3,4);
	System.out.println("a equals b is ");
	System.out.println(a.equals(b));//should be false

	System.out.println("a is ");
	System.out.println(a);//should be "1/2"
	System.out.println("b is ");
	System.out.println(b);//should be "3/4"
	System.out.println();
	
	RationalNumber d = new RationalNumber(-1,2);

	System.out.println(a.multiply(b));//should be 3/8
	System.out.println(a.multiply(d));//should be -1/4
	System.out.println(a.divide(b));//should be 2/3
	System.out.println(b.divide(d));//should be -3/2
	System.out.println(a.add(b));//should be 5/4
	System.out.println(a.subtract(b));//should be -1/4
	System.out.println(b.subtract(a));//should be 1/4

	System.out.println("gcd of 252 and 205 is " + RationalNumber.gcd(252,105));//should be 21
	System.out.println("gcd of 7 and 5 is " + RationalNumber.gcd(7,5));//should be 1
	System.out.println("gcd of 10 and 2 is "+RationalNumber.gcd(10,2));//should be 2
	System.out.println("gcd of 2 and 10 is "+RationalNumber.gcd(2,10));//should be 2
	System.out.println("gcd of 18 and 9 is "+RationalNumber.gcd(18,9));//should be 9
	System.out.println("gcd of 18 and 24 is "+RationalNumber.gcd(18,24));//should be 6
	System.out.println("gcd of 6 and 13 is "+RationalNumber.gcd(6,13));//should be 1
	RationalNumber c = new RationalNumber(9,12);
	c.reduce();
	System.out.println(c);//should be 3/4

	RationalNumber e = new RationalNumber(2,1);
	System.out.println(e);//should be 2
    }
}