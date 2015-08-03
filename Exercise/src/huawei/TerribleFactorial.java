package huawei;

import java.math.BigDecimal;

public final class TerribleFactorial {
	
	public static String  calcNN(int n)
	{
		if(n<=0)
		{
			return "1";
		}
		
		BigDecimal bd = new BigDecimal(1);
		for(int i=2;i<=n;i++)
		{
			BigDecimal temp = new BigDecimal(i);
			bd = bd.multiply(temp);
		}
		
		return bd.toString();
	}
	
	
}