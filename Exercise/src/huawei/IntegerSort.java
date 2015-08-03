package huawei;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public final class IntegerSort {
	/*****************************************************************************
	Description : 实现整数排序，即先将从A输入的整型数序列进行排序，剔除重复整型数，输出得到的升序序列B；
	Input       : array_A                 输入参数，输入待排序整型数序列A
	Return      : 排序后的整型数序列
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


