package huawei;

import java.util.Arrays;

/*
 功能:判断yuanzi 的马是否会赢？yuanzi 的马赢了，返回 YES. 否则返回 NO

 输入参数：
 int num: 赛马的数量；   (1<= num <=1000)
 int[] speedYz: yuanzi 的马的速度；
 int[] speedOp: 对手的马的速度；

 返回值：
 String型，yuanzi 的马赢了，返回 YES. 否则返回 NO；
 */

public class YuanZiSaiMa 
{
	public String isYuanziWin(int num, int[] speedYz, int[] speedOp) 
	{
		if(num < 1 || num > 1000 || speedYz == null || speedOp == null)
		{
			return "NO";
		}
		
		Arrays.sort(speedYz);
		Arrays.sort(speedOp);
		
		int yzStart = num / 2 - (num % 2==0? 1 : 0);
		int opStart = 0;
		while(yzStart < speedYz.length)
		{
			if(speedYz[yzStart] <= speedOp[opStart])
			{
				return "NO";
			}
			yzStart++;
			opStart++;
		}
		
		return "YES";
	}
}
