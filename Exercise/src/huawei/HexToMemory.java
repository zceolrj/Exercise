package huawei;


public final class HexToMemory {

	/* 功能：将十六进制字符串形式内容转为内存值形式（注：pBuffer的内存申请由调用者保证）
	 * 输入：szHexText：十六进制字符串形式，如: "6566"
	 * 输出：dataOutput,其中：内存值形式Buffer，即内存的{0x65, 0x66}
	 * 返回：返回转换成功的buffer的有效字节数
	 * 
	 * 约束：
		pBuffer的内存申请由调用者保证
		pszHexText中从左向右一定要两个有效的16进制字符才能转为一个内存值，“655”只能转为{0x65}
		16进制字符的范围为[‘0’-‘9’]，[‘A’-‘F’], [‘a’-‘f’]
		需要过滤掉字符串中间的非16进制字符后，即”65#4#3”=> {0x65,0x43} 
	 */
	public static int[] hexToBin(String szHexText)
	{
	    /* 请实现 */
		if(szHexText == null || szHexText.length()<2)
		{
			return null;
		}
		
		char[] charArr = szHexText.toCharArray();
		int len = charArr.length;
		int resultLen = 0;
		for(int i=0;i<len;i++)
		{
			if(contains(charArr[i]))
			{
				resultLen++;
			}
		}
		char[] resultArr = new char[resultLen];
		int index = 0;
		for(int i=0;i<len;i++)
		{
			if(contains(charArr[i]))
			{
				resultArr[index++] = charArr[i];
			}
		}
		
		int[] intArr = new int[resultLen/2];
		
		if(resultLen/2 == 0)
		{
			return null;
		}
		
		for(int i=0;i<intArr.length;i++)
		{
			int pos = i * 2;
			intArr[i] = (int)(charToByte(resultArr[pos])<<4 | charToByte(resultArr[pos+1]));
		}
		
	    return intArr;
	}
	
//	public static void main(String[] args)
//	{
//		String s = "#65#4#3";
//		int[] intArr = hexToBin(s);
//		if(intArr != null)
//		{
//			for(int i : intArr)
//			{
//				System.out.println(i);
//			}
//		}
//	}

	public static boolean contains(char c)
	{
		if(c >= '0' && c <='9')
		{
			return true;
		}
		else if(c >= 'A' && c <='F')
		{
			return true;
		}
		else if(c>='a' && c<='f')
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private static byte charToByte(char c) 
	{  
	    c = Character.toUpperCase(c);
		return (byte) "0123456789ABCDEF".indexOf(c);  
	} 

}