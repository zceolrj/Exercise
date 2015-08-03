package huawei;


public final class XiaoMingChopsticks
{
    /**
     * 小明是个马大哈，某天他到超市买了若干双筷子（n<20）
     *  筷子的长度不尽相同，他把全部筷子都放在购物袋里面拿回家，路上不小心漏了一根
     *  请你用程序帮他找出是漏掉的筷子是多长的。
     * 
     * 
     * @param chopsticks  剩下的筷子数组，如：1, 2, 3, 2, 1, 3, 2
     * @return int 漏掉的筷子长度，如上述输入返回：2（当输入的筷子数据异常时返回-1，如：找不到漏掉的筷子）
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
