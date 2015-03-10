package tsatry1;

import java.util.*;
import java.math.*;
import java.nio.charset.Charset;

/* Name of the class has to be "Main" only if the class is public. */
public class ide
{
	private static final Charset UTF_8 = Charset.forName("UTF-8");
	public static BigDecimal[] encrypt(String input, BigDecimal a, BigDecimal b) throws java.lang.Exception
	{
		byte byteA = 0;
		BigDecimal bdByte = new BigDecimal(0);
		BigDecimal bdNum = new BigDecimal(0);
		BigDecimal bdN = new BigDecimal(0);
		BigDecimal ab = new BigDecimal(0);
		BigDecimal bdDenom = new BigDecimal(0);
		BigDecimal bdOne = new BigDecimal("1.0");
                String text = input;
		int n = text.length();
		byte[] bytes = text.getBytes(UTF_8);
		//System.out.println(n);
		//System.out.println("bytes= "+Arrays.toString(bytes));
		//System.out.println("text again= "+new String(bytes, UTF_8));
                BigDecimal[] number = new BigDecimal[n];
		for(int i=0; i<n; i++){
			bdN = bdN.valueOf(n);
			byteA = bytes[i];
			bdByte = bdByte.valueOf(byteA);
			bdNum = bdByte.add(b);
			bdNum = bdNum.pow(n); 
			bdNum = a.multiply(bdNum);
			ab = a.multiply(b);
			bdNum = bdNum.pow(ab.intValue());
			bdDenom = b.multiply(bdN.subtract(a.add(bdOne)));
                        System.out.println("BdDenom "+bdDenom.intValue()+" A: "+a.intValue()+"B: "+b.intValue());
                        if(bdDenom.intValue() < 0){
                            bdDenom = bdDenom.multiply(BigDecimal.valueOf(-1));
                        }
                        System.out.println("After 0 check: "+bdDenom.intValue());
			bdDenom = bdDenom.pow(bdDenom.intValue()/a.intValue());
			//System.out.println("Denom: " + bdDenom);
			bdNum = bdNum.divide(bdDenom, 2000, BigDecimal.ROUND_HALF_EVEN);
			//System.out.println("Number: " + bdNum);
                        number[i] = bdNum;
		}
                //System.out.println(Arrays.toString(number));
		return number;
	}
}
