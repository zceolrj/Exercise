package huawei.weightMouse;

public class Mouse implements Comparable<Mouse>{
	public int weight;
	public MOUSE_COLOR color;	
	public Mouse()
	{
		
	}
	public Mouse(int weight,MOUSE_COLOR color)
	{
		this.weight =weight;
		this.color = color;
	}
	
	@Override
	public int compareTo(Mouse o) 
	{
		if(this.weight < o.weight)
		{
			return -1;
		}
		else if(this.weight > o.weight)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	
}
