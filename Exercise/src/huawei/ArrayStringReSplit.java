package huawei;

import java.util.ArrayList;
import java.util.List;


public final class ArrayStringReSplit {
	/*
	功能:请编写一个函数，输入为一个字符串数组，
	请按指定长度iInputLenth拆分数组中的每个字符串，输出到新的字符串数组中。长度不是iInputLenth整数倍的字符串请在后面补数字0。
	空字符串不处理，遇到空字符串则表示数组结束，函数返回。
	输入:
	    String inputStrArray     字符串数组指针 字符串个数最大为50,字符串长度最大255
	    int iInputLenth   指定的分割长度 iInputLenth>=1 && <=32 
	     
	返回:字符串数组指针     

	示例 按长度8拆分
	输入： abc 
	       12345789 
	返回： abc00000
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