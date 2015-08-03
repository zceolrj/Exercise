package huawei.weightMouse;

public final class Demo {

	/*根据重量排序后，输出帽子颜色
	 * 举例：	5只小白鼠，重量分别为15 30 5 9 30，帽子颜色依次为CL_RED, CL_BLUE, CL_BLUE, CL_YELLOW, CL_GRAY，
	 * 则排序后的输出的帽子颜色序列应该为CL_BLUE, CL_YELLOW, CL_RED, CL_BLUE, CL_GRAY。
		如果没有小白鼠，输出null。
	输入参数：小白鼠数组	
		
	*/
	public static MOUSE_COLOR[] sortMouse(Mouse[] mouse )
	{
		if(mouse == null)
		{
			return null;
		}
		
		int len = mouse.length;
		boolean swaped = false;
		for(int i=0;i<len;i++)
		{
			for(int j=0;j<len - 1 - i;j++)
			{
				if(mouse[j].compareTo(mouse[j+1]) > 0)
				{
					swaped = true;
					Mouse temp = mouse[j];
					mouse[j] = mouse[j+1];
					mouse[j+1] = temp;
				}
			}
			
			if(!swaped)
			{
				break;
			}
		}
		
		MOUSE_COLOR[] colors = new MOUSE_COLOR[len];
		for(int i=0;i<len;i++)
		{
			colors[i] = mouse[i].color;
		}
		
		return colors;
	}
	
	
}


