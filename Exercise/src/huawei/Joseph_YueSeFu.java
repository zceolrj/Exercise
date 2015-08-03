package huawei;


public final class Joseph_YueSeFu {
	
	/*
	功能: 约瑟夫问题众所周知，原始的约瑟夫问题是这样的：有n个人，编号为1,2,..., n，站成一圈，
	每次第m个将会被处决，直到只剩下一个人。约瑟夫通过给出m来决定赦免其中的一个人。
	例如当n=6,m=5时，5,4,6,2,3将会被依次处决，而1将会幸免。

	假如有k个好人，和k个坏人，所有人站成一圈，前k个人是好人，后k个人是坏人，
	编写程序计算一个最小的m，使k个坏人都被处决，而不处决任何好人。

	    
	输入: k 为正整数
	    
	输出: 
	     
	返回: 最小的m，使k个坏人都被处决，而不处决任何好人。
	     
	*/
	

	public static  int getMinimumM(int K)
	{
	    /*在这里实现功能*/
		int result = 1;
		int index = K + 1;
		while(index <=Integer.MAX_VALUE)
		{
			boolean found = true;
			for(int i=0;i<K;i++)
			{
				int curIndex = getIndex(result, 2*K - i, i);
				if(curIndex < K)
				{
					found = false;
					break;
				}
			}
			if(found)
			{
				break;
			}
			result++;
		}
		return result;
		
//		if(K<=0 || K>Integer.MAX_VALUE/2)
//		{
//			return -1;
//		}
//		int index = K + 1;
//		while(index <= Integer.MAX_VALUE - K)
//		{
//			if(valid(K, index))
//			{
//				return index;
//			}
//			if((index / K) % 2 == 1)
//			{
//				index++;
//			}
//			else
//			{
//				index += K;
//			}
//			
//		}
//		
//		return -1;
	}

//	public static boolean valid(int K, int m)
//	{
//		if(K<0 || m<0)
//		{
//			return false;
//		}
//		
//		int[] arr = new int[2*K];
//		
//		int curIndex = 0;
//		for(int i=0;i<K;i++)
//		{
//			int j=0;
//			while(j<m)
//			{
//				if(arr[curIndex] != -1)
//				{
//					j++;
//					if(j==m)
//					{
//						arr[curIndex] = -1;
//						if(curIndex >= 0 && curIndex <K)
//						{
//							return false;
//						}
//					}
//				}
//				curIndex = (curIndex + 1)%(2*K);
//			}
//		}
//		
//		return true;
//	}
	
	public static int getIndex(int m, int n, int order)
	{
		int tempN = n;
		int index = (m-1)%n;
		while((order--)>0)
		{
			tempN++;
			index = (index + m % tempN) % tempN;
		}
		return index;
	}
}


