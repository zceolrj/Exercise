package huawei;

import java.util.ArrayList;
import java.util.List;


public final class StringSplit {
	
	private static String[] arr = {"", "0", "00", "000", "0000", "00000", "000000", "0000000"};

    /**
     * ���������ַ���(�������ΪN,�ַ�������С��100)��
     * �밴����Ϊ8���ÿ���ַ�����������µ��ַ������飬
     * ���Ȳ���8���������ַ������ں��油����0�����ַ���������
     */
    public static String[] splitString(String[] input)
    {
        List<String> list = new ArrayList<String>();
        if(input != null)
        {
        	for(String str : input)
        	{
        		String[] strArr = getStrArr(str);
        		if(strArr != null)
        		{
        			for(String s : strArr)
        			{
        				list.add(s);
        			}
        		}
        	}
        }
    	String[] strArr = new String[list.size()];
        
    	return list.toArray(strArr);
    }
    
    public static String[] getStrArr(String str)
    {
    	if(str == null || str.length() == 0)
    	{
    		return null;
    	}
    	
    	int len = str.length();
    	int blockSize = len / 8;
    	if(len % 8 != 0)
    	{
    		blockSize += 1;
    	}
    	
    	String[] strArr = new String[blockSize];
    	int i;
    	for(i=0;i<blockSize - 1;i++)
    	{
    		String s = str.substring(i*8, i*8 + 8);
    		strArr[i] = s;
    	}
    	strArr[i] = formatStr(str.substring((blockSize-1)*8));
    	
    	return strArr;
    }

	public static String formatStr(String str)
	{
		if(str == null || str.length() == 0)
		{
			return null;
		}
		
		int minus = 8 - str.length();
		str = str + arr[minus];
		
		return str;
	}
}


