package tsatry2.encrypt;

import java.math.*;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import static tsatry2.ui.calcUI.statusText;
import static tsatry2.ui.decalcUI.statusTextDe;

/* Name of the class has to be "Main" only if the class is public. */
public class Ide
{
	private static final Charset UTF_8 = Charset.forName("UTF-8");
	
	
	
	public static BigDecimal[] encrypt(String input, BigDecimal a, BigDecimal b, int OpLength)
	{
            String text = input;
            int length = 0;
            if(OpLength == 0){
                length = text.length();
            }else{
                length = OpLength;
            }
            BigDecimal[] number = new BigDecimal[length];
            byte[] bytes = text.getBytes(UTF_8);
            BigDecimal ab = a.multiply(b);
            int intAB = ab.intValue();
            BigDecimal[] num = new BigDecimal[length];
            BigDecimal bdN = new BigDecimal(0);
            BigDecimal bdDenom = new BigDecimal(0);
            BigDecimal bdOne = new BigDecimal("1.0");
            
            ExecutorService executor = Executors.newFixedThreadPool(8);
            
            byte byteA;
            BigDecimal bdByte = new BigDecimal(0);
            BigDecimal bdNum = new BigDecimal(0);
            if(OpLength == 0){
                for(int i=0; i<length; i++){
                        setText("Calculating Numerator: "+i+" of "+length);
                        byteA = bytes[i];
                        bdByte = bdByte.valueOf(byteA);
                        bdNum = bdByte.add(b);
                        bdNum = bdNum.pow(length); 
                        bdNum = a.multiply(bdNum);
                        bdNum = bdNum.pow(ab.intValue());
                        num[i] = bdNum;
		}
            }else{
                byteA = bytes[0];
                    bdByte = bdByte.valueOf(byteA);
                    bdNum = bdByte.add(b);
                    bdNum = bdNum.pow(length); 
                    bdNum = a.multiply(bdNum);
                    bdNum = bdNum.pow(ab.intValue());
                    num[0] = bdNum;
            }
            bdN = BigDecimal.valueOf(length);
            bdDenom = b.multiply(bdN.subtract(a.add(bdOne)));
            setText("BdDenom "+bdDenom.intValue()+" A: "+a.intValue()+"B: "+b.intValue());
            if(bdDenom.intValue() < 0){
                bdDenom = bdDenom.multiply(BigDecimal.valueOf(-1));
            }
            setText("After 0 check: "+bdDenom.intValue());
            bdDenom = bdDenom.pow(bdDenom.intValue()/a.intValue());
        if(OpLength ==0){    
            for(int j=0; j<length; j++){
                setText("Div Running thread #: "+j+" of "+length);
                divideThread divThread = new divideThread(num[j], bdDenom);
                Future<BigDecimal> futureDiv = executor.submit(divThread);
                try {
                    number[j] = futureDiv.get().stripTrailingZeros();
                    //System.out.println("Div Thread #: "+j);
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(Ide.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            divideThread divThread = new divideThread(num[0], bdDenom);
                Future<BigDecimal> futureDiv = executor.submit(divThread);
                try {
                    number[0] = futureDiv.get().stripTrailingZeros();
                    //System.out.println("Div Thread #: "+j);
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(Ide.class.getName()).log(Level.SEVERE, null, ex);
                }
        }    
        setText("Finished Calc");

            return number;
	}
    public static void setText(String input) {
        try { 
                statusText.setText(input);
                statusText.update(statusText.getGraphics());
        } catch (NullPointerException e) {
            try {
                statusTextDe.setText(input);
                statusTextDe.update(statusTextDe.getGraphics());
            } catch (NullPointerException ex) {
            }
        }
        
    }
}
