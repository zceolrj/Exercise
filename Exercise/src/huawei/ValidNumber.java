package huawei;

/**
 * 
 * @param String s �����ַ���
 * 
 * @description�� 
 *     �ж��ַ����Ƿ�����Ч���֣��Ƿ���0�����Ƿ���-1
 *    
 * @example:
 *     123.456 ����Ч���֣�����0
 *     123a ������Ч���֣�����-1
 * 
 */
public class ValidNumber
{
	public int NumType(String s)
	{
		try
		{
			Double.parseDouble(s);
		}
		catch(Exception e)
		{
			return -1;
		}
		return 0;
	}
	
}
