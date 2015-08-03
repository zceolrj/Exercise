package huawei;

import java.math.BigDecimal;

public final class JudgeZiShouShu {
	/*
	Description  
	         �ж��Ƿ���������
	Prototype
	       	public static boolean isAutoMorphicNum(int num)
	Input Param 
	   
	      num  ��Ҫ�жϵ���
	Output Param 
	         ��
	Return Value
	         true  ��������
	         false ����������
	*/
	public static boolean isAutoMorphicNum(int num)
	{
		/*������ʵ�ֹ���*/
		if(num < 0)
		{
			return false;
		}
		
		BigDecimal n = new BigDecimal(num);
		BigDecimal p = n.multiply(n);
		
		String nStr = n.toString();
		String pStr = p.toString();
		
		int nLen = nStr.length();
		int pLen = pStr.length();
		
		for(int i=0;i<nLen;i++)
		{
			char nc = nStr.charAt(nLen-1-i);
			char pc = pStr.charAt(pLen-1-i);
			if(nc != pc)
			{
				return false;
			}
		}
		
		return true;
	}
	
//	public static void main(String[] args)
//	{
//		int num1 = 5;
//		int num2 = 6;
//		int num3 = 25;
//		int num4 = 76;
//		int num5 = 3;
//		
//		if(isAutoMorphicNum(num1))
//		{
//			System.out.println(num1 + " is ");
//		}
//		
//		if(isAutoMorphicNum(num2))
//		{
//			System.out.println(num2 + " is ");
//		}
//		
//		if(isAutoMorphicNum(num3))
//		{
//			System.out.println(num3 + " is ");
//		}
//		
//		if(isAutoMorphicNum(num4))
//		{
//			System.out.println(num4 + " is ");
//		}
//		
//		if(isAutoMorphicNum(num5))
//		{
//			System.out.println(num5 + " is ");
//		}
//	}
}