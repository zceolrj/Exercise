package huawei;

/*
����:�ж��������Ƿ��ܹ��ӳ��ĵ�
    
���������
	 	int uiMagic�����ͣ������ߵĳ�ʼħ��ֵ
		int uiDistance:���ͣ����������ڵĳ�ʼλ���뵺����֮��ľ��롣
		int uiSec�����ͣ�����û��Ҫ��ʱ�䣬��λΪ��
	 	StringBuilder pRstOut����֤������ǿյ�StringBuilder����Ҫ��ѽ�����룬����������ܷ��ӳ��ĵ��������ӳ������Yes�������������No����ע���Сд��
����ֵ��
		�����������ӳ��ĵ�������ӳ��ĵ����õ����ʱ�䣬
									�����ӳ���������������ӳ��������롣
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
