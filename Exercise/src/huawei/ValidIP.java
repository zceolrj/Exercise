package huawei;


/**
 * 
 * @param inputStr
 *            输入字符串
 * @param outputStr
 *            输出判断结果
 * 
 * @description： 输入的inputStr是合法的IP，返回YES，否则返回NO 示例 输入：10.138.15.1 返回：YES
 * 
 */
public class ValidIP {
	
	public static final String YES = "YES";
	
	public static final String NO = "NO";
	
	public void checkIP(String inputStr, StringBuffer outputStr) 
	{	
		if(inputStr == null)
		{
			outputStr.append(NO);
			return;
		}
		
		String[] parts = inputStr.split("\\.");
		if(parts == null || parts.length != 4)
		{
			outputStr.append(NO);
			return;
		}
		
		int[] nums = new int[4];
		for(int i=0;i<4;i++)
		{
			String part = parts[i];
			
			if(part == null || part.length()>3)
			{
				outputStr.append(NO);
				return;
			}
			
			try
			{
				nums[i] = Integer.parseInt(part);
			}
			catch(Exception e)
			{
				outputStr.append(NO);
				return;
			}
			
			if(nums[i]<0 || nums[i]>255)
			{
				outputStr.append(NO);
				return;
			}
		}
		
		outputStr.append(YES);
		return;
	}

}
