package huawei;


public final class Joseph_YueSeFu {
	
	/*
	����: Լɪ������������֪��ԭʼ��Լɪ�������������ģ���n���ˣ����Ϊ1,2,..., n��վ��һȦ��
	ÿ�ε�m�����ᱻ������ֱ��ֻʣ��һ���ˡ�Լɪ��ͨ������m�������������е�һ���ˡ�
	���統n=6,m=5ʱ��5,4,6,2,3���ᱻ���δ�������1�������⡣

	������k�����ˣ���k�����ˣ�������վ��һȦ��ǰk�����Ǻ��ˣ���k�����ǻ��ˣ�
	��д�������һ����С��m��ʹk�����˶������������������κκ��ˡ�

	    
	����: k Ϊ������
	    
	���: 
	     
	����: ��С��m��ʹk�����˶������������������κκ��ˡ�
	     
	*/
	

	public static  int getMinimumM(int K)
	{
	    /*������ʵ�ֹ���*/
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


