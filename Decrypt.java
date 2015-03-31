/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsatry2.decrypt;

import Library.anc.org.nevec.rjm.BigDecimalMath;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import static tsatry2.encrypt.Ide.encrypt;
import static tsatry2.ui.calcUI.outputTextField;
import static tsatry2.ui.calcUI.statusText;
import static tsatry2.ui.decalcUI.statusTextDe;

/**
 *
 * @author Henry
 */
public class Decrypt {

    private static final Charset UTF_8 = Charset.forName("UTF-8");

    public static String decrypt(String inputNumbers, String sa, String sb) {
        BigDecimal bdN = new BigDecimal(0);//new vars
        BigDecimal bdDenom = new BigDecimal(0);
        BigDecimal bdOne = new BigDecimal("1.0");
        BigDecimal a = new BigDecimal(0);
        BigDecimal b = new BigDecimal(0);
        double dbA = Double.parseDouble(sa);//local vars from args
        a = BigDecimal.valueOf(dbA);
        double dbB = Double.parseDouble(sb);
        b = BigDecimal.valueOf(dbB);
        BigDecimal bdNum = new BigDecimal(0);

        String[] lines = inputNumbers.split("\r\n|\r|\n");//splitting input text into individual strings
        int length = lines.length;
        bdN = BigDecimal.valueOf(length);
        String output = "";

        if (length > 3 | Integer.parseInt(sb) > 4 | Integer.parseInt(sa) > 4) {//running the per char check only if it doesnt have demanding values

            String[] charset = {"", "", "","", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", " ", "2", "3", "4", "5", "6", "7", "8", "9", "0", "1", "!", ".", ",", ";", ":", "?", "$", "-", "%", "^", "&", "*", "(", ")", "_", "=", "+", "{", "}", "[", "]", "#", "@", "/", "<", ">", "~", "`"};//list of chars supported
            char[] chars = {'\'', '"', '\\', '’'};//list of odd chars
            charset[0] = String.valueOf(chars[0]);//setting chars to strings
            charset[1] = String.valueOf(chars[1]);
            charset[2] = String.valueOf(chars[2]);
            charset[3] = String.valueOf(chars[3]);
            BigDecimal[][] charSets = new BigDecimal[charset.length][];//new arrays
            BigDecimal[] tempSet = new BigDecimal[charset.length];
            String temp = "";
            for (int i = 0; i < charset.length; i++) {//run all
                System.out.println(charset[i]);
                tempSet = encrypt(charset[i], a, b, length);//encrypt each string
                temp = tempSet[0].toPlainString();//remove wierd zeroes and formatting
                setText("Out: " + temp);
                BigDecimal tempBD = new BigDecimal(temp);
                BigDecimal[] tempBDA = {tempBD};
                charSets[i] = tempBDA;
            }
            for (int j = 0; j < length; j++) {//compare each char in input to encrypted chars
                for (int k = 0; k < charset.length; k++) {//compare char to each encryptec char
                    setText("Checking Char #: " + k);
                    BigDecimal line = new BigDecimal(lines[j]);
                    if (charSets[k][0].compareTo(line) == 0) {//compare char to encypted char
                        output = output.concat(charset[k]);//add char to finished string
                        setText("Current ouput: " + output);
                        break;
                    } else if (k == charset.length - 1) {//if gets to end add empty string and break
                        output = output.concat("");
                        break;
                    }
                }
            }
        } else {//if not cpu demanding decryption
            bdDenom = b.multiply(bdN.subtract(a.add(bdOne)));//b*(length-(a+1.0) Same as encryption
            setText("BdDenom " + bdDenom.intValue() + " A: " + a.intValue() + "B: " + b.intValue());
            if (bdDenom.intValue() < 0) {//negative check
                bdDenom = bdDenom.multiply(BigDecimal.valueOf(-1));
            }
            setText("After 0 check: " + bdDenom.intValue());
            bdDenom = bdDenom.pow(bdDenom.intValue() / a.intValue());//denom^denom/a

            ExecutorService executor = Executors.newFixedThreadPool(8);//max 8 threads

            BigDecimal[] numbers = new BigDecimal[length];
            for (int j = 0; j < length; j++) {//run all strings
                setText("Starting Numor Calc: " + j);
                if (!"".equals(lines[j]) && lines[j] != null) {//making sure is not empty or null
                    String input = lines[j].replaceAll(",", "");//remove any commas
                    multiThread multiThread = new multiThread(input, bdDenom);//init threads
                    Future<BigDecimal> futureDiv = executor.submit(multiThread);//prepare to get threads
                    try {
                        numbers[j] = futureDiv.get();//get return from threads
                    } catch (InterruptedException | ExecutionException ex) {
                        Logger.getLogger(Decrypt.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
            byte[] bytes = new byte[length];//new array

            BigDecimal ab = new BigDecimal(0);
            ab = bdOne.divide(a.multiply(b), 20, BigDecimal.ROUND_HALF_EVEN);//(1.0)/(a*b) 20 decimal places round mode half even (this is to get inverted ab for powers
//         System.out.println("Ab Int: " + ab.intValue());
//         System.out.println("AB: " + ab);
            BigDecimal iLength = new BigDecimal(0);
            iLength = bdOne.divide(bdN, 20, BigDecimal.ROUND_HALF_EVEN);//1/length for powers
//            System.out.println(iLength);
            for (int i = 0; i < length; i++) {//run all nums
                setText("Starting Number Calc: " + i);
                bdNum = numbers[i];
//                System.out.println(bdNum);
//              System.out.println("Ab Int: " + ab.doubleValue());
                setText("Before Power: " + i);
                bdNum = BigDecimalMath.root(a.multiply(b).intValue(), bdNum);//ab root of bdNum
                setText("After Power: " + i);
                bdNum = bdNum.divide(a, 200, BigDecimal.ROUND_HALF_EVEN);//devide new bdNum by a at 200 places
//              System.out.println(bdNum);
                bdNum = BigDecimalMath.root(length, bdNum);//root again at length
//              System.out.println(bdNum);
                bdNum = bdNum.subtract(b);//subtract b
//                            System.out.println(bdNum);
                bytes[i] = bdNum.byteValue();//add byte value to array
            }
            output = new String(bytes, UTF_8);//convert bytes to strings
        }
        setText("Done Decrypting");
        return output;
    }

    public static void setText(String input) {
        if (!statusTextDe.isShowing()) {//check decrypt gui
            statusText.setText(input);
            statusText.update(statusText.getGraphics());
        } else {//check encrypt gui
            statusTextDe.setText(input);
            statusTextDe.update(statusTextDe.getGraphics());
        }
    }
}
