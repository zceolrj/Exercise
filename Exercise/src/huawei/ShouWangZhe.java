package huawei;

/*
功能:判断守望者是否能够逃出荒岛
    
输入参数：
	 	int uiMagic：整型，守望者的初始魔法值
		int uiDistance:整型，守望者所在的初始位置与岛出口之间的距离。
		int uiSec：整型，岛沉没需要的时间，单位为秒
	 	StringBuilder pRstOut：保证传入的是空的StringBuilder对象，要求把结果加入，输出守望者能否逃出荒岛，若能逃出输出“Yes”，不能输出“No”，注意大小写。
返回值：
		若守望者能逃出荒岛，输出逃出荒岛所用的最短时间，
									不能逃出则输出守望者能逃出的最大距离。
*/

public class ShouWangZhe 
{
	public int helpWatcherEscape(int uiMagic, int uiDistance, int uiSec, StringBuilder pRstOut)
	{
		int s1 = uiDistance;
		int t1 = uiSec;
		if(pRstOut == null)
		{
			pRstOut = new StringBuilder();
		}
		
		while(uiMagic >= 10 && uiSec > 0 && uiDistance > 0)
		{
			if(uiDistance > 17)
			{
				uiDistance -= 60;
				uiMagic -= 10;
				uiSec--;
			}
			else
			{
				pRstOut.append("Yes");
				return (t1 - uiSec + 1);
			}
		}
		
		while(uiSec > 0 && uiDistance > 0)
		{
			if((uiMagic == 0 || uiMagic == 1) && uiSec >= 7 && uiDistance > 102)
			{
				uiSec -= 7;
				uiDistance -= 120;
			}
			else if(uiMagic >= 2 && uiMagic <= 5 && uiSec >= 3 && uiDistance > 34)
			{
				uiMagic = uiMagic + 4 * 2 - 10;
				uiSec -= 3;
				uiDistance -= 60;
			}
			else if(uiMagic >= 6 && uiSec >= 2 && uiDistance > 17)
			{
				uiMagic = uiMagic + 4 * 1 - 10;
				uiSec -= 2;
				uiDistance -= 60;
			}
			else
			{
				uiDistance -= 17;
				uiSec--;
			}
		}
		
		if(uiDistance <= 0)
		{
			pRstOut.append("Yes");
			return (t1 - uiSec);
		}
		else
		{
			pRstOut.append("No");
			return (s1 - uiDistance);
		}
	}

}
