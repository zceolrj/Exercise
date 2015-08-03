package huawei;

import java.math.BigDecimal;


public final class BigNumberMinus {
	/*****************************************************************************
	Description  : �������ⳤ�ȵ��������
	Input Param  : String minuend   ����������\0��ʾ�ַ�������
	               String subtrahend  ��������\0��ʾ�ַ�������
	Return Value :  ���������������\0��ʾ�ַ�������
	*****************************************************************************/
	public static String decrease(String minuend,String subtrahend )
	{

	    /* ������ʵ�ֹ��� */
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