package huawei;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class SinglePlankBridge 
{
	public static int minHit(String filePath)
	{
		if(filePath == null)
		{
			return 0;
		}
		
		File f = new File(filePath);
		BufferedReader br = null;
		try 
		{
			br = new BufferedReader(new FileReader(f));
			
			String line = br.readLine();
			int L = Integer.parseInt(line);
			
			line = br.readLine();
			String[] parts = line.split(" ");
			int S = Integer.parseInt(parts[0]);
			int T = Integer.parseInt(parts[1]);
			int M = Integer.parseInt(parts[2]);
			
			line = br.readLine();
			parts = line.split(" ");
			int[] stone = new int[M];
			for(int i=0;i<M;i++)
			{
				stone[i] = Integer.parseInt(parts[i]);
			}
			
			int min = 0;
			if(S==T)
			{
				for(int i=0;i<M;i++)
				{
					if(stone[i] % S == 0)
					{
						min++;
					}
				}
				
				return min;
			}
			
			Arrays.sort(stone);
			
			if(stone[0] > 90)
			{
				int k = stone[0] - 90;
				for(int i=0;i<M;i++)
				{
					stone[i] -= k;
				}
				L -= k;
			}
			
			for(int i=1;i<M;i++)
			{
				int k = stone[i] - stone[i-1];
				if(k > 90)
				{
					for(int j=i;j<M;j++)
					{
						stone[i] -= k;
					}
					L -= k;
				}
			}
			
			int[] bridge = new int[L + T + 1];
			int[] num = new int[L + T + 1];
			for(int i=0;i<M;i++)
			{
				bridge[stone[i]] = 1;
			}
			
			Arrays.fill(num, -1);
			num[0] = 0;
			for(int i=S;i<L + T;i++)
			{
				min = 101;
				for(int j=i-T;j<=i-S;j++)
				{
					if(j>=0 && num[j] != -1 && num[j] < min)
					{
						min = num[j];
					}
				}
				
				if(min != 101)
				{
					num[i] = min + bridge[i];
				}
			}
			
			min = 101;
			for(int i=L;i<L + T;i++)
			{
				if(i>= 0 && num[i] != -1 && num[i] < min)
				{
					min = num[i];
				}
			}
			
			return min;
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(br != null)
			{
				try 
				{
					br.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) 
	{
		String filePath = "file/test.txt";
		int result = minHit(filePath);
		
		System.out.println(result);
	}

}
