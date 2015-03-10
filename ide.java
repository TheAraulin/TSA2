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
                BigDecimal[] number = new BigDecimal[n];
	
		return number;
	}
}
