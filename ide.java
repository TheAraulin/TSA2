package tsatry2;

import java.util.*;
import java.math.*;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* Name of the class has to be "Main" only if the class is public. */
public class Ide
{
	private static final Charset UTF_8 = Charset.forName("UTF-8");
	
	
	
	public static BigDecimal[] encrypt(String input, BigDecimal a, BigDecimal b) throws java.lang.Exception
	{
            String text = input;
            int length = text.length();
            BigDecimal[] number = new BigDecimal[length];
            byte[] bytes = text.getBytes(UTF_8);
            BigDecimal ab = a.multiply(b);
            int intAB = ab.intValue();
            BigDecimal[] num = new BigDecimal[length];
            BigDecimal bdN = new BigDecimal(0);
            BigDecimal bdDenom = new BigDecimal(0);
            BigDecimal bdOne = new BigDecimal("1.000000000000000");
            
            ExecutorService executor = Executors.newFixedThreadPool(4);
            for(int i=0; i<length; i++){
                System.out.println("Running thread #: "+i);
                numThread NumThread = new numThread(bytes[i], length, a, b, intAB);
                Future<BigDecimal> futureNum = executor.submit(NumThread);
                num[i] = futureNum.get();
                System.out.println("Thread #: "+i+" Result from thread: "+num[i]);
            }
            
            bdN = BigDecimal.valueOf(length);
            bdDenom = b.multiply(bdN.subtract(a.add(bdOne)));
            System.out.println("BdDenom "+bdDenom.intValue()+" A: "+a.intValue()+"B: "+b.intValue());
            if(bdDenom.intValue() < 0){
                bdDenom = bdDenom.multiply(BigDecimal.valueOf(-1));
            }
            System.out.println("After 0 check: "+bdDenom.intValue());
            bdDenom = bdDenom.pow(bdDenom.intValue()/a.intValue());
            
            for(int j=0; j<length; j++){
                divideThread divThread = new divideThread(num[j], bdDenom);
                Future<BigDecimal> futureDiv = executor.submit(divThread);
                number[j] = futureDiv.get();
            }
            
            return number;
	}
}
