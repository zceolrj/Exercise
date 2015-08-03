package huawei;

import java.math.BigDecimal;

public final class BigNumMultiple {
	
	/*****************************************************************************
	 Description  : 两个任意长度的长数相乘, 输出结果
	 Input Param  : 
	                String multiplierA  乘数A
	                String multiplierB  乘数B
	 Return Value : 
	                乘法结果；如果数据异常，返回null
	*****************************************************************************/
	public static String multiply (String multiplierA, String multiplierB)
	{
		if(!isNumber(multiplierA) || !isNumber(multiplierB))
		{
			return null;
		}
		
		BigDecimal bg1 = new BigDecimal(multiplierA);
		BigDecimal bg2 = new BigDecimal(multiplierB);
		
		BigDecimal result = bg1.multiply(bg2);
		String str = result.toPlainString();
		
		str = format(str);
		
	    return str;
	}
	
	// check whether the str is a number
	public static boolean isNumber(String str)
	{
		//1.can not be null or none
		if(str == null || str.isEmpty())
		{
			return false;
		}
		
		int len = str.length();
		
		//2.first char must be a digit or be '+' or '-'
		char first = str.charAt(0);
		if(!Character.isDigit(first) && first != '-' && first != '+')
		{
			return false;
		}
		
		int i = 1;
		//3.when first char is '-' or '+', second char must be digit
		if(first == '-' || first == '+')
		{
			//len can not be 1
			if(len == 1)
			{
				return false;
			}
			
			char second = str.charAt(1);
			if(!Character.isDigit(second))
			{
				return false;
			}
			
			i = 2;
		}
		
		//3.from the third char, every char must be digit or point,
		//however, point can only have one and can not appear at the last
		boolean appearPoint = false;
		for(;i<len;i++)
		{
			char c = str.charAt(i);
			if(c == '.' && !appearPoint && i != len -1)
			{
				appearPoint = true;
			}
			else if(!Character.isDigit(c))
			{
				return false;
			}
		}
		
		return true;
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
	
	
	public static void main(String[] args)
	{
		String s1 = "1000000000000000000000000000000000000000000000";
		String s2 = "1";
		String r = multiply(s1, s2);
		System.out.println(r);
		
		String str1 = "0.1";
		String str2 = "-.1";
		String str3 = "-1.1";
		String str4 = ".0";
		String str5 = "11.1.1";
		
		if(isNumber(str1))
		{
			System.out.println("str1 is number");
		}
		else
		{
			System.out.println("str1 is not number");
		}
		
		if(isNumber(str2))
		{
			System.out.println("str2 is number");
		}
		else
		{
			System.out.println("str2 is not number");
		}
		
		if(isNumber(str3))
		{
			System.out.println("str3 is number");
		}
		else
		{
			System.out.println("str3 is not number");
		}
		
		if(isNumber(str4))
		{
			System.out.println("str4 is number");
		}
		else
		{
			System.out.println("str4 is not number");
		}
		
		if(isNumber(str5))
		{
			System.out.println("str5 is number");
		}
		else
		{
			System.out.println("str5 is not number");
		}
	}
}


