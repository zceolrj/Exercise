package huawei;

public final class GaoCiFangShuDeWeiShu {
	/*
	����: ���M��N�η��������λ��(M��N������10)
	���������
	    int M��M > 10
	    int N��N > 10
	����ֵ��
	    M��N�η��������λ��
	*/

	public static int getLast3DigitsOfMN(int M, int N)
	{
	    /*������ʵ�ֹ���*/
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


