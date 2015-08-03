package huawei;


public final class NFactorialZeroNum {
	
	/*
	功能:
	    
	输入: 
	    
	输出:	计算n!中有多少个0
	     
	返回: 
	     
	*/
	public static   int getZeroCount(int n)
	{
		/*在这里实现功能*/
		int count = 0;
		while(n>=5)
		{
			int num = getNumOf5(n);
			if(num>0)
			{
				count += num;
				n -= 5;
			}
			else
			{
				n--;
			}
		}
		return count;
	}
	
	public static int getNumOf5(int num)
	{
		if(num<5)
		{
			return 0;
		}
		
		int count = 0;
		while(num%5==0)
		{
			count++;
			num /=5;
		}
		
		return count;
	}
	
}


