package huawei;

import java.util.Arrays;
import java.util.Comparator;

public final class IntArrayAndComparator {
	
    // ���ܣ������������飬����Ԫ�ذ�����������������
    // ���룺pIntegerArray ��Ҫ�������������
    //       sortFlg 0:���� 1������
    // ���أ�û���ظ����ֵ�����
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