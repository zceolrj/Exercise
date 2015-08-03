package huawei;


public final class HexToMemory {

	/* ���ܣ���ʮ�������ַ�����ʽ����תΪ�ڴ�ֵ��ʽ��ע��pBuffer���ڴ������ɵ����߱�֤��
	 * ���룺szHexText��ʮ�������ַ�����ʽ����: "6566"
	 * �����dataOutput,���У��ڴ�ֵ��ʽBuffer�����ڴ��{0x65, 0x66}
	 * ���أ�����ת���ɹ���buffer����Ч�ֽ���
	 * 
	 * Լ����
		pBuffer���ڴ������ɵ����߱�֤
		pszHexText�д�������һ��Ҫ������Ч��16�����ַ�����תΪһ���ڴ�ֵ����655��ֻ��תΪ{0x65}
		16�����ַ��ķ�ΧΪ[��0��-��9��]��[��A��-��F��], [��a��-��f��]
		��Ҫ���˵��ַ����м�ķ�16�����ַ��󣬼���65#4#3��=> {0x65,0x43} 
	 */
	public static int[] hexToBin(String szHexText)
	{
	    /* ��ʵ�� */
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