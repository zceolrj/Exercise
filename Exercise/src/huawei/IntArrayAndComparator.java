package huawei;

import java.util.Arrays;
import java.util.Comparator;

public final class IntArrayAndComparator {
	
    // 功能：输入整型数组，对其元素按照升序或降序进行排序
    // 输入：pIntegerArray 需要排序的整型数组
    //       sortFlg 0:升序 1：降序
    // 返回：没有重复数字的整型
    public static void sortArray(Integer[] pIntegerArray, int sortFlg)
    {
        if(pIntegerArray == null || (sortFlg != 0 && sortFlg != 1))
        {
        	// parameters invalid
        	return;
        }
        
        Comparator<Integer> comp = null;
        if(sortFlg == 0)
        {
        	comp = new Comparator<Integer>(){
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1.compareTo(o2);
				}
        	};
        }
        else if(sortFlg == 1)
        {
        	comp = new Comparator<Integer>(){
				@Override
				public int compare(Integer o1, Integer o2) {
					return -o1.compareTo(o2);
				}
        	};
        }
        
//        int len = pIntegerArray.length;
//        boolean swaped = false;
//        for(int i=0;i<len;i++)
//        {
//        	for(int j=0;j<len-1-i;j++)
//        	{
//        		if(comp.compare(pIntegerArray[j], pIntegerArray[j+1])>0)
//        		{
//        			swaped = true;
//        			
//        			Integer temp = pIntegerArray[j];
//        			pIntegerArray[j] = pIntegerArray[j+1];
//        			pIntegerArray[j+1] = temp;
//        		}
//        	}
//        	
//        	if(!swaped)
//        	{
//        		break;
//        	}
//        }
        
        Arrays.sort(pIntegerArray, comp);
    }

}