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
public class Ide {

    private static final Charset UTF_8 = Charset.forName("UTF-8");

    public static boolean isInteger(String s) {//checking string for ints
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public static BigDecimal[] encrypt(String input, BigDecimal a, BigDecimal b, int OpLength) {
        String text = input;//local vars from args
        int length = 0;
        if (OpLength == 0) {//checking for overwrite length
            length = text.length();//normal
        } else {
            length = OpLength;//for decryption
        }
        BigDecimal[] number = new BigDecimal[length];//crate new array
        byte[] bytes = text.getBytes(UTF_8);//get the UTF-8 byte values of text
        BigDecimal ab = a.multiply(b);//var ab = a*b
        int intAB = ab.intValue();//int value of ab
        BigDecimal[] num = new BigDecimal[length];//new array
        BigDecimal bdN = new BigDecimal(0);//new vars
        BigDecimal bdDenom = new BigDecimal(0);
        BigDecimal bdOne = new BigDecimal("1.0");//new var for exactly 1.0

        ExecutorService executor = Executors.newFixedThreadPool(8);//make threads of 8

        byte byteA;// new vars
        BigDecimal bdByte = new BigDecimal(0);
        BigDecimal bdNum = new BigDecimal(0);
        if (OpLength == 0) {//normal
            for (int i = 0; i < length; i++) {//run once for every char
                setText("Calculating Numerator: " + i + " of " + length);
                byteA = bytes[i];//get byte from array
                bdByte = bdByte.valueOf(byteA);//bigdecimal from byte
                bdNum = bdByte.add(b);//add b
                bdNum = bdNum.pow(length);//power of length of text
                bdNum = a.multiply(bdNum);//time a
                bdNum = bdNum.pow(ab.intValue());//power of ab
                num[i] = bdNum;//setting num to (a(x+b)^length)^ab
            }
        } else {//run only once but with faked length
            byteA = bytes[0];
            bdByte = bdByte.valueOf(byteA);
            bdNum = bdByte.add(b);
            bdNum = bdNum.pow(length);
            bdNum = a.multiply(bdNum);
            bdNum = bdNum.pow(ab.intValue());
            num[0] = bdNum;
        }
        bdN = BigDecimal.valueOf(length);//bd of length
        bdDenom = b.multiply(bdN.subtract(a.add(bdOne)));//b*(Length-(a+1.0))
        setText("BdDenom " + bdDenom.intValue() + " A: " + a.intValue() + "B: " + b.intValue());
        if (bdDenom.intValue() < 0) {//checking if is negative
            bdDenom = bdDenom.multiply(BigDecimal.valueOf(-1));//making positive
        }
        setText("After 0 check: " + bdDenom.intValue());
        bdDenom = bdDenom.pow(bdDenom.intValue() / a.intValue());//denominator = denominator^(denominator/a)
        if (OpLength == 0) {//normal
            for (int j = 0; j < length; j++) {
                setText("Div Running thread #: " + j + " of " + length);
                divideThread divThread = new divideThread(num[j], bdDenom);//start division thread
                Future<BigDecimal> futureDiv = executor.submit(divThread);//prepare to get
                try {
                    number[j] = futureDiv.get().stripTrailingZeros();//get while stripping trailing zeroes
                    //System.out.println("Div Thread #: "+j);
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(Ide.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {//with faked length
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
        try {//try encryption gui
            statusText.setText(input);
            statusText.update(statusText.getGraphics());
        } catch (NullPointerException e) {
            try {//else try decryption gui
                statusTextDe.setText(input);
                statusTextDe.update(statusTextDe.getGraphics());
            } catch (NullPointerException ex) {//should be impossible
            }
        }

    }
}
