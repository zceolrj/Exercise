package huawei;

public final class NStairMethod {
	
	/* ���ܣ�
	 * ���룺n
	 * �����
	 * ���أ�N��¥�ݵ��߷�
	 */
	public static long  stairs(int n)
	{
		/*��������ɴ���*/
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


