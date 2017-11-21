public class RationalNumber{
    private int numerator;
    private int denominator;

    public RationalNumber(int nume, int deno){
	numerator = nume;
	denominator = deno;
	if(deno<0){
	    numerator = -1*nume;
	    denominator = -1*deno;
	}
	if(deno==0){
	    denominator = 1;
	}
	reduce();
    }
    public int getNumerator(){
	return numerator;
    }

    public int getDenominator(){
	return denominator;
    }

    public RationalNumber reciprocal(){
	return new RationalNumber(denominator, numerator);
    }

  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
    public boolean equals(RationalNumber other){
	return((getNumerator()==other.getNumerator()) &&
	       (getDenominator()==other.getDenominator()));
    }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
    public String toString(){
	if(denominator == 1){
	    return ""+numerator;
	}
	if(numerator==0)
	    return ""+0;
	return ""+numerator+"/"+denominator;
    }

    /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
   public static int gcd(int a, int b){
    /*use euclids method or a better one*/
       if(a<0){
	   a=Math.abs(a);
       }
       if(b<0){
	   b=Math.abs(b);
       }
       if(a<b){
	   return gcd(b,a);
       }
       if(b==0){
	   return a;
       }else if(b==1){
	   return b;
       }else{
	   return gcd(b,a%b);
       }
    }
    /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after any operation you perform.
  */
  public void reduce(){
      int g = gcd(numerator,denominator);
      numerator /= g;
      denominator /= g;
  }



  /******************Operations!!!!****************/


  /**
  *
  */
  public RationalNumber multiply(RationalNumber other){
      int n = numerator * other.getNumerator();
      int d = denominator * other.getDenominator();
      RationalNumber a = new RationalNumber(n,d);
      a.reduce();
      return a;
  }

  /**
  *
  */
  public RationalNumber divide(RationalNumber other){
      other = other.reciprocal();
      return this.multiply(other);
  }

  /**
  *
  */
  public RationalNumber add(RationalNumber other){
      int a = numerator;
      int b = denominator;
      int c = other.getNumerator();
      int d = other.getDenominator();
      RationalNumber first  = new RationalNumber(a*d,b*d);
      RationalNumber last = new RationalNumber(c*b,d*b);
      int w = first.getNumerator();
      int x = first.getDenominator();
      int y = last.getNumerator();
      int z = last.getDenominator();
      RationalNumber result = new RationalNumber(w+y,x);
      result.reduce();
      return result;
  }
  /**
  *
  */
  public RationalNumber subtract(RationalNumber other){
      int a = numerator;
      int b = denominator;
      int c = other.getNumerator();
      int d = other.getDenominator();
      RationalNumber first  = new RationalNumber(a*d,b*d);
      RationalNumber last = new RationalNumber(c*b,d*b);
      int w = first.getNumerator();
      int x = first.getDenominator();
      int y = last.getNumerator();
      int z = last.getDenominator();
      RationalNumber result = new RationalNumber(w-y,x);
      result.reduce();
      return result;
  }
}