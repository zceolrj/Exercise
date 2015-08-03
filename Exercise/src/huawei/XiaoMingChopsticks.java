package huawei;


public final class XiaoMingChopsticks
{
    /**
     * С���Ǹ�������ĳ������������������˫���ӣ�n<20��
     *  ���ӵĳ��Ȳ�����ͬ������ȫ�����Ӷ����ڹ���������ûؼң�·�ϲ�С��©��һ��
     *  �����ó�������ҳ���©���Ŀ����Ƕ೤�ġ�
     * 
     * 
     * @param chopsticks  ʣ�µĿ������飬�磺1, 2, 3, 2, 1, 3, 2
     * @return int ©���Ŀ��ӳ��ȣ����������뷵�أ�2��������Ŀ��������쳣ʱ����-1���磺�Ҳ���©���Ŀ��ӣ�
     * 
     */
    public static int checkChopsticks(int[] chopsticks)
    {        
        if(chopsticks == null || (chopsticks.length % 2 == 0))
        {
        	return -1;
        }
    	int missing = 0;
        for(int i=0;i<chopsticks.length;i++)
        {
        	missing ^= chopsticks[i];
        }
        
        int count = 0;
        for(int i=0;i<chopsticks.length;i++)
        {
        	if(chopsticks[i]==missing)
        	{
        		count++;
        	}
        }
        
        if(count%2==0)
        {
        	return -1;
        }
        
    	return missing;
    }
    
}
