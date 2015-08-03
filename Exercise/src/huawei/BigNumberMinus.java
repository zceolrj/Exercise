package huawei;

import java.math.BigDecimal;


public final class BigNumberMinus {
	/*****************************************************************************
	Description  : 两个任意长度的正数相减
	Input Param  : String minuend   被减数，以\0表示字符串结束
	               String subtrahend  减数，以\0表示字符串结束
	Return Value :  减法结果，必须以\0表示字符串结束
	*****************************************************************************/
	public static String decrease(String minuend,String subtrahend )
	{

	    /* 在这里实现功能 */
		BigDecimal bg1 = new BigDecimal(minuend);
		BigDecimal bg2 = new BigDecimal(subtrahend);
		
		BigDecimal result = bg1.subtract(bg2);
		String str = result.toString();
		
		str = format(str);

	    return str;

	}
	
	public static String format(String str)
	{
		StringBuffer sb = new StringBuffer(str);
		
		int index = str.indexOf('.');
		int len = str.length();
		if(index != -1)
		{
			int i;
			for (i = len - 1; i > index; i--) 
			{
				if (str.charAt(i) == '0') 
				{
					sb.deleteCharAt(i);
				} 
				else 
				{
					break;
				}
			}

			if (i == index) 
			{
				sb.deleteCharAt(index);
			}
			
			for(i=0;i<index-1;i++)
			{
				if(str.charAt(i)=='0')
				{
					sb.deleteCharAt(0);
				}
				else
				{
					break;
				}
			}
		}
		
		return sb.toString();
	}
	
//	public static void main(String[] args)
//	{
//		String minuend = "8.5";
//		String subtrahend = "7.5";
//		String result = Demo.decrease(minuend, subtrahend);
//		
//		System.out.println(result);
//	}


}