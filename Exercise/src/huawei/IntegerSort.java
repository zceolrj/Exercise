package huawei;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public final class IntegerSort {
	/*****************************************************************************
	Description : ʵ���������򣬼��Ƚ���A��������������н��������޳��ظ�������������õ�����������B��
	Input       : array_A                 ����������������������������A
	Return      : ����������������
	*****************************************************************************/
	public static int[] sort(int []array_A)
	{
	    if(array_A == null || array_A.length < 1)
	    {
	    	return null;
	    }
		
		Set<Integer> set = new TreeSet<Integer>();
	    for(int i=0;i<array_A.length;i++)
	    {
	    	set.add(array_A[i]);
	    }
	    
	    int lenB = set.size();
	    int[] array_B = new int[lenB];
	    int indexB = 0;
	    Iterator<Integer> iter = set.iterator();
	    while(iter.hasNext())
	    {
	    	array_B[indexB++] = iter.next();
	    }
	    
		return array_B;
	}

}


