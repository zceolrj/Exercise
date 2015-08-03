package huawei;

public final class NStairMethod {
	
	/* 功能：
	 * 输入：n
	 * 输出：
	 * 返回：N阶楼梯的走法
	 */
	public static long  stairs(int n)
	{
		/*在这里完成代码*/
		if(n<=0)
		{
			return 0;
		}
		
		if(n==1)
		{
			return 1;
		}
		if(n==2)
		{
			return 2;
		}
		
	    return stairs(n-1)+stairs(n-2);
	}
	

}


