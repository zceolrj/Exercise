package huawei;

import java.util.ArrayList;
import java.util.List;


public final class ArrayStringReSplit {
	/*
	����:���дһ������������Ϊһ���ַ������飬
	�밴ָ������iInputLenth��������е�ÿ���ַ�����������µ��ַ��������С����Ȳ���iInputLenth���������ַ������ں��油����0��
	���ַ����������������ַ������ʾ����������������ء�
	����:
	    String inputStrArray     �ַ�������ָ�� �ַ����������Ϊ50,�ַ����������255
	    int iInputLenth   ָ���ķָ�� iInputLenth>=1 && <=32 
	     
	����:�ַ�������ָ��     

	ʾ�� ������8���
	���룺 abc 
	       12345789 
	���أ� abc00000
	       12345678
	       90000000

	*/

	public static String[] convertStringArray(String[] inputStrArray, int iInputLenth)
	{
	    if(inputStrArray == null || inputStrArray.length > 50)
	    {
	    	return null;
	    }
	    
	    if(iInputLenth < 1 || iInputLenth > 32)
	    {
	    	return null;
	    }
	    
	    List<String> list = new ArrayList<String>();
	    for(String str : inputStrArray)
	    {
	    	String[] strArr = getStrArr(str, iInputLenth);
	    	if(strArr != null)
    		{
    			for(String s : strArr)
    			{
    				list.add(s);
    			}
    		}
	    }
	    String[] strArr = new String[list.size()];
	    
		return list.toArray(strArr);
	}

	public static String[] getStrArr(String str, int splitLen)
	{
		if(str == null || str.length() == 0 || str.length() > 255)
		{
			return null;
		}
		
		int len = str.length();
		
		int blockSize = len / splitLen;
		if(len % splitLen != 0)
		{
			blockSize += 1;
		}
		
		String[] strArr = new String[blockSize];
		int i;
		for(i=0;i<blockSize - 1;i++)
		{
			String s = str.substring(i*splitLen, i*splitLen + splitLen);
			strArr[i] = s;
		}
		strArr[i] = formatStr(str.substring((blockSize-1)*splitLen), splitLen);
		
		return strArr;
	}
	
	public static String formatStr(String str, int splitLen)
	{
		if(str == null || str.length() == 0)
		{
			return null;
		}
		
		int minus = splitLen - str.length();
		StringBuffer sb = new StringBuffer(str);
		while(minus > 0)
		{
			sb.append("0");
			minus--;
		}
		
		return sb.toString();
	}



}