package huawei;

import java.util.Arrays;

/*
 ����:�ж�yuanzi �����Ƿ��Ӯ��yuanzi ����Ӯ�ˣ����� YES. ���򷵻� NO

 ���������
 int num: �����������   (1<= num <=1000)
 int[] speedYz: yuanzi ������ٶȣ�
 int[] speedOp: ���ֵ�����ٶȣ�

 ����ֵ��
 String�ͣ�yuanzi ����Ӯ�ˣ����� YES. ���򷵻� NO��
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
