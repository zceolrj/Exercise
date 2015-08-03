package huawei;

/*
输入参数：

		int Month：整数，Redraiment到家的月数。
		int Day：整数，Redraiment到家的日期
输出参数：
		无
返回值：
		int  （返回Redraiment到家后遭遇停电的天数）
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
