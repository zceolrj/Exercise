package huawei;

public final class MaxCommonDivisor {
	
    // 功能：获取两个整数的最大公约数
    // 输入：两个整数
    // 返回：最大公约数
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
    
    // 功能：获取两个整数的最小公倍数
    // 输入：两个整数
    // 返回：最小公倍数
    public static long getMinMultiple(long lFirstInput, long lSecondInput)
    {
        long result = lFirstInput * lSecondInput / getMaxDivisor(lFirstInput, lSecondInput);
        return result;
    }

}