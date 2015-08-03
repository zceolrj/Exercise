package huawei;


public final class JudgeStringType {
	
	/*
	功能: 根据一组规则识别一个特定的字符串是常见的计算机问题，

	定义了如下三种字符串类型：

	Slump是一串字符，具有如下性质：
	    1.以'D'或'E'开始
	    2.第一个字符后由1个或多个'F'
	    3.之后跟着一个Slump或'G'，至此一个Slump结束。
	    4.其他的都不是Slump

	例如，DFFEFFFG是Slump

	Slimp是一串字符，具有如下性质：
	    1.第一个字符是'A'
	    2.如果Slimp只有2个字符，则第二个字符是'H'
	    3.如果大于2个字符，则可能有2种形式
	        a) 'A'后接一个'B'再接一个Slimp再接一个'C'
	        b) 'A'后接一个Slump再接一个'C'
	    4.其他的都不是Slimp

	Slurpy是一个Slimp后接一个Slump组成

	请编写程序判断一个字符串是否为Slurpy

	输入: 一个字符串
	    
	输出: 无
	     
	返回: 1，是Slurpy
	      0，不是
	     
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
		/*在这里实现功能*/
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
	 * Slump是一串字符，具有如下性质：
	    1.以'D'或'E'开始
	    2.第一个字符后由1个或多个'F'
	    3.之后跟着一个Slump或'G'，至此一个Slump结束。
	    4.其他的都不是Slump

	例如，DFFEFFFG是Slump
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
		
		//2. 第一个字符后由一个或多个'F'
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
		
		//3.之后跟着一个slump或'G'
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
	 * Slimp是一串字符，具有如下性质：
	    1.第一个字符是'A'
	    2.如果Slimp只有2个字符，则第二个字符是'H'
	    3.如果大于2个字符，则可能有2种形式
	        a) 'A'后接一个'B'再接一个Slimp再接一个'C'
	        b) 'A'后接一个Slump再接一个'C'
	    4.其他的都不是Slimp
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
		
		//2.如果Slimp只有2个字符，则第二个字符是'H'
		if(str.length() == 2 && str.charAt(1)!='H')
		{
			return false;
		}
		
		//3.如果大于2个字符，则可能有2种形式
        //a) 'A'后接一个'B'再接一个Slimp再接一个'C'
        //b) 'A'后接一个Slump再接一个'C'
		if(str.length()>2)
		{
			if(!str.endsWith("C"))
			{
				return false;
			}
			int bIndex = str.indexOf('B');
			int startIndex;
			int endIndex = str.length() - 2;
			if(bIndex==1)//接一个B
			{
				startIndex = 2;
			}
			else//不接B
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


