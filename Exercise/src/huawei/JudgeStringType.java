package huawei;


public final class JudgeStringType {
	
	/*
	����: ����һ�����ʶ��һ���ض����ַ����ǳ����ļ�������⣬

	���������������ַ������ͣ�

	Slump��һ���ַ��������������ʣ�
	    1.��'D'��'E'��ʼ
	    2.��һ���ַ�����1������'F'
	    3.֮�����һ��Slump��'G'������һ��Slump������
	    4.�����Ķ�����Slump

	���磬DFFEFFFG��Slump

	Slimp��һ���ַ��������������ʣ�
	    1.��һ���ַ���'A'
	    2.���Slimpֻ��2���ַ�����ڶ����ַ���'H'
	    3.�������2���ַ����������2����ʽ
	        a) 'A'���һ��'B'�ٽ�һ��Slimp�ٽ�һ��'C'
	        b) 'A'���һ��Slump�ٽ�һ��'C'
	    4.�����Ķ�����Slimp

	Slurpy��һ��Slimp���һ��Slump���

	���д�����ж�һ���ַ����Ƿ�ΪSlurpy

	����: һ���ַ���
	    
	���: ��
	     
	����: 1����Slurpy
	      0������
	     
	*/
	
	public static void main(String[] args)
	{
		String str1 = "AHDFG";
		String str2 = "DFGAH";
		String str3 = "DFFEFFFG";
		String str4 = "ABADFFGCC";
		String str5 = "ADFFEFFGC";
		String str6 = "ADFFGC";
		
		if(isSlurpy(str1) == 1)
		{
			System.out.println("AHDFG is slurpy");
		}
		
		if(isSlurpy(str2) == 0)
		{
			System.out.println("DFGAH is not slurpy");
		}
		
		if(isSlump(str3))
		{
			System.out.println("DFFEFFFG is slump");
		}
		
		if(isSimple(str4))
		{
			System.out.println("ABADFFGCC is simple");
		}
		
		if(isSimple(str5))
		{
			System.out.println("ADFFEFFGC is simple");
		}
		
		if(isSimple(str6))
		{
			System.out.println("ADFFGC is simple");
		}
	}

	public static int  isSlurpy(String str)
	{
		/*������ʵ�ֹ���*/
		if(str == null)
		{
			return 0;
		}
		
		for(int i=2;i<str.length();i++)
		{
			String simple = str.substring(0, i);
			String slump = str.substring(i);
			
			if(isSimple(simple) && isSlump(slump))
			{
				return 1;
			}
		}
		
		return 0;
	}
	
	/**
	 * Slump��һ���ַ��������������ʣ�
	    1.��'D'��'E'��ʼ
	    2.��һ���ַ�����1������'F'
	    3.֮�����һ��Slump��'G'������һ��Slump������
	    4.�����Ķ�����Slump

	���磬DFFEFFFG��Slump
	 */
	public static boolean isSlump(String str)
	{
		if(str == null)
		{
			return false;
		}
		
		int len = str.length();
		
		//1. starts with D or E
		if((!str.startsWith("D")) && (!str.startsWith("E")))
		{
			return false;
		}
		
		//2. ��һ���ַ�����һ������'F'
		int startIndex = str.indexOf('F');
		if(startIndex != 1)
		{
			return false;
		}
		
		int endIndex = startIndex;
		while(endIndex < len && str.charAt(endIndex)=='F')
		{
			endIndex++;
		}
		
		//3.֮�����һ��slump��'G'
		String endStr = str.substring(endIndex);
		if(endStr == null || endStr.length()==0)
		{
			return false;
		}
		if((!isSlump(endStr)) && (!endStr.equals("G")))
		{
			return false;
		}
		
		return true;
	}
	
	/**
	 * Slimp��һ���ַ��������������ʣ�
	    1.��һ���ַ���'A'
	    2.���Slimpֻ��2���ַ�����ڶ����ַ���'H'
	    3.�������2���ַ����������2����ʽ
	        a) 'A'���һ��'B'�ٽ�һ��Slimp�ٽ�һ��'C'
	        b) 'A'���һ��Slump�ٽ�һ��'C'
	    4.�����Ķ�����Slimp
	 */
	public static boolean isSimple(String str)
	{
		if(str == null || str.length()<2)
		{
			return false;
		}
		
		//1. starts with 'A'
		if(str.charAt(0) != 'A')
		{
			return false;
		}
		
		//2.���Slimpֻ��2���ַ�����ڶ����ַ���'H'
		if(str.length() == 2 && str.charAt(1)!='H')
		{
			return false;
		}
		
		//3.�������2���ַ����������2����ʽ
        //a) 'A'���һ��'B'�ٽ�һ��Slimp�ٽ�һ��'C'
        //b) 'A'���һ��Slump�ٽ�һ��'C'
		if(str.length()>2)
		{
			if(!str.endsWith("C"))
			{
				return false;
			}
			int bIndex = str.indexOf('B');
			int startIndex;
			int endIndex = str.length() - 2;
			if(bIndex==1)//��һ��B
			{
				startIndex = 2;
			}
			else//����B
			{
				startIndex = 1;
			}
			
			if(startIndex > endIndex)
			{
				return false;
			}
			
			String subStr = str.substring(startIndex, endIndex+1);
			if((startIndex==1) && (!isSlump(subStr)))
			{
				return false;
			}
			if((startIndex==2) && (!isSimple(subStr)))
			{
				return false;
			}
		}
		
		return true;
	}
}


