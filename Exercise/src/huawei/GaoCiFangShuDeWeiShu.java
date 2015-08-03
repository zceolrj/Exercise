package huawei;

public final class GaoCiFangShuDeWeiShu {
	/*
	功能: 求解M的N次方的最后三位数(M，N均大于10)
	输入参数：
	    int M：M > 10
	    int N：N > 10
	返回值：
	    M的N次方的最后三位数
	*/

	public static int getLast3DigitsOfMN(int M, int N)
	{
	    /*在这里实现功能*/
		if(M <= 10 || N <= 10)
		{
			return 0;
		}
		
		int result = 1;
		for(int i=0;i<N;i++)
		{
			result = result * M % 1000;
		}
		
	    return result;
	}

}


