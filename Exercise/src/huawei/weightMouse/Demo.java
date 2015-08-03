package huawei.weightMouse;

public final class Demo {

	/*����������������ñ����ɫ
	 * ������	5ֻС���������ֱ�Ϊ15 30 5 9 30��ñ����ɫ����ΪCL_RED, CL_BLUE, CL_BLUE, CL_YELLOW, CL_GRAY��
	 * �������������ñ����ɫ����Ӧ��ΪCL_BLUE, CL_YELLOW, CL_RED, CL_BLUE, CL_GRAY��
		���û��С�������null��
	���������С��������	
		
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


