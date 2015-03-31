package tsatry2.encrypt;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

class divideThread implements Callable<BigDecimal>{
	BigDecimal bdDenom = new BigDecimal(0);
	BigDecimal bdNum = new BigDecimal(0);


public divideThread(BigDecimal num, BigDecimal denom){
	bdDenom = denom;//args to local vars
	bdNum = num;
}

	@Override
	public BigDecimal call() throws Exception{
		bdNum = bdNum.divide(bdDenom, 500, BigDecimal.ROUND_HALF_EVEN);//divide bdNum by bdDenom with 500 decimals places with rounding mode half-even
		return bdNum;
	}
}
