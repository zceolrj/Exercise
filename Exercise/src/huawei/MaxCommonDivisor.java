package huawei;

public final class MaxCommonDivisor {
	
    // ���ܣ���ȡ�������������Լ��
    // ���룺��������
    // ���أ����Լ��
    public static long getMaxDivisor(long lFirstInput, long lSecondInput)
    {
    	if(lFirstInput<=0 || lSecondInput<=0)
		{
			return 0;
		}
		
		if(lFirstInput < lSecondInput)
		{
			long temp = lFirstInput;
			lFirstInput = lSecondInput;
			lSecondInput = temp;
		}
		
		while(lFirstInput%lSecondInput != 0)
		{
			long temp = lFirstInput%lSecondInput;
			lFirstInput = lSecondInput;
			lSecondInput = temp;
		}
		
		return lSecondInput;
    }
    
    // ���ܣ���ȡ������������С������
    // ���룺��������
    // ���أ���С������
    public static long getMinMultiple(long lFirstInput, long lSecondInput)
    {
        long result = lFirstInput * lSecondInput / getMaxDivisor(lFirstInput, lSecondInput);
        return result;
    }

}