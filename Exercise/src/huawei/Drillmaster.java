package huawei;

import java.util.Arrays;

/**
 * 1. boolean canConstructCircle
 * 2. dfs2
 * 3. getMin
 */
public class Drillmaster 
{
	/*
	 *  for (int i=1;i<=n;i++)
     *  {
     * 	    if ( ( l[l[i]]!=i && r[l[i]]!=i ) || ( l[r[i]]!=i && r[r[i]]!=i ) )
     *      {
     *          printf("-1\n");
     *      }
     *  }
	 */
	public static boolean canConstructCircle(int[] left, int[] right)
	{
		int len = left.length;
		for(int i=0;i<len;i++)
		{
			boolean flag1 = (left[left[i] - 1] - 1) != i;
			boolean flag2 = (right[left[i] - 1] - 1) != i;
			boolean flag3 = (left[right[i] - 1] -1) != i;
			boolean flag4 = (right[right[i] - 1] - 1) != i;
			if((flag1 && flag2) || (flag3 && flag4))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static void dfs2(int[] left, int[] right)
	{
		int len = left.length;
		int[] result = new int[len];
		boolean[] flag = new boolean[len];
		
		result[0] = 1;
		flag[0] = true;
		
		for(int i=1;i<len;i++)
		{
			int l = left[result[i-1] - 1];
			int r = right[result[i-1] - 1];
			boolean bl = flag[l-1];
			boolean br = flag[r-1];
			
			if(!bl)
			{
				result[i] = l;
				flag[l-1] = true;
			}
			else if(!br)
			{
				result[i] = r;
				flag[r-1] = true;
			}
		}
		
		for(int i=0;i<len;i++)
		{
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}
	
	public static void dfs(int[] left, int[] right, int[] result, boolean[] flag, int index, int len)
	{
		int l = left[result[index-1]-1];
		int r = right[result[index-1]-1];
		boolean bl = flag[l-1];
		boolean br = flag[r-1];
		
		if(!bl)
		{
			result[index++] = l;
			flag[l-1] = true;
			dfs(left, right, result, flag, index, len);
		}
		else if(!br)
		{
			result[index++] = r;
			flag[r-1] = true;
			dfs(left, right, result, flag, index, len);
		}
	}
	
	public static int getMin(int[] seq)
	{
		int len = seq.length;
		int[] a = new int[len];
		for(int i=0;i<len;i++)
		{
			a[i] = seq[i] - i - 1;
			if(a[i] < 0)
			{
				a[i] += len;
			}
		}
		
		int[] count = new int[len];
		for(int i=0;i<len;i++)
		{
			count[a[i]]++;
		}
		
		int max = 0;
		for(int i=0;i<len;i++)
		{
			if(count[i] > max)
			{
				max = count[i];
			}
		}
		
		int[] b = new int[len];
		for(int i=0;i<len;i++)
		{
			b[i] = seq[i] - (len - i);
			if(b[i] < 0)
			{
				b[i] += len;
			}
		}
		
		Arrays.fill(count, 0);
		for(int i=0;i<len;i++)
		{
			count[b[i]]++;
		}
		for(int i=0;i<len;i++)
		{
			if(count[i] > max)
			{
				max = count[i];
			}
		}
		
		return len - max;
	}
	
	public static void main(String[] args) 
	{
		int[] left1 = {3, 4, 1, 1};
		int[] right1 = {4, 3, 2, 2};
		int[] result1 = new int[4];
		boolean[] flag1 = new boolean[4];
		int len1 = 4;
		result1[0] = 1;
		flag1[0] = true;
		dfs(left1, right1, result1, flag1, 1, len1);
		
		for(int i=0;i<4;i++)
		{
			System.out.print(result1[i] + " ");
		}
		System.out.println();
		int min1 = getMin(result1);
		System.out.println(min1);
		
		dfs2(left1, right1);
		
		int len2 = 10;
		int[] left2 = {8, 8, 6, 10, 3, 4, 5, 2, 1, 9};
		int[] right2 = {9, 7, 5, 6, 7, 3, 2, 1, 10, 4};
		int[] result2 = new int[10];
		boolean[] flag2 = new boolean[10];
		result2[0] = 1;
		flag2[0] = true;
		dfs(left2, right2, result2, flag2, 1, len2);
		for(int i=0;i<10;i++)
		{
			System.out.print(result2[i] + " ");
		}
		System.out.println();
		int min2 = getMin(result2);
		System.out.println(min2);
		
		dfs2(left2, right2);
		
		boolean can1 = canConstructCircle(left1, right1);
		boolean can2 = canConstructCircle(left2, right2);
		
		if(can1)
		{
			System.out.println("can1");
		}
		
		if(can2)
		{
			System.out.println("can2");
		}
		
		int[] left3 = {3, 4, 1, 2};
		int[] right3 = {4, 3, 2, 2};
		
		boolean can3 = canConstructCircle(left3, right3);
		if(!can3)
		{
			System.out.println("can3 not");
		}
	}

}
