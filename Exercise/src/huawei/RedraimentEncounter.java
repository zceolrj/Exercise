package huawei;

/*
���������

		int Month��������Redraiment���ҵ�������
		int Day��������Redraiment���ҵ�����
���������
		��
����ֵ��
		int  ������Redraiment���Һ�����ͣ���������
*/
public class RedraimentEncounter
{
    public static int[] status = new int[63];
    
    public static int baseInternal = 2;
    
    static{
    	status[1] = 1;
    	int index = 1;
    	while(index < status.length)
    	{
    		index += baseInternal;
    		if(index<63)
    		{
    			status[index] = 1;
    			baseInternal++;
    		}
    	}
    }
	
	public int getDayNum(int month, int day)
    {
        int startDay = 1;
        if(month<7)
        {
        	startDay = 1;
        }
        else if(month==7)
        {
        	startDay = day;
        }
        else if(month==8)
        {
        	startDay = day + 31;
        }
        else
        {
        	return 0;
        }
        
        int total = 0;
        for(int i=startDay;i<63;i++)
        {
        	if(status[i]==1)
        	{
        		total++;
        	}
        }
        
        return total;
    }
}
