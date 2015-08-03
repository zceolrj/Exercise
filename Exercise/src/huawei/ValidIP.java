package huawei;


/**
 * 
 * @param inputStr
 *            �����ַ���
 * @param outputStr
 *            ����жϽ��
 * 
 * @description�� �����inputStr�ǺϷ���IP������YES�����򷵻�NO ʾ�� ���룺10.138.15.1 ���أ�YES
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
