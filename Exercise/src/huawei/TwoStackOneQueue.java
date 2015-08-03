package huawei;

import java.util.Stack;

public final class TwoStackOneQueue {

	public static class EnQueueInf
	{
		public int enElem ;
	}
	
	public static class DeQueueInf
	{
		public int deElem ;
	}
	/*
	����������ջS1��S2��ģ��һ�����С�

	��֪ջ���ĸ����㶨�����£�
	Init(ST): ��ʼ��STջ����ʼ����ɺ��ջΪ�գ�û���κ�Ԫ�أ�
	Push(ST,x): Ԫ��x��STջ��
	Pop(ST,x): STջ��Ԫ�س�ջ����������x��
	IsEmpty(ST): ��STջ�Ƿ�Ϊ�ա�

	��ô�������ջ��������ʵ�ָö��е��ĸ����㣺
	InitQueue: ��ʼ�����У���ʼ����ɺ�Ķ���Ϊ�գ�û���κ�Ԫ�أ�
	EnQueue: ����һ��Ԫ������У� 
	DeQueue: ɾ��һ��Ԫ�س����У�
	IsEmptyQueue: �ж����Ƿ�Ϊ�ա�

	�㷨˵����
	ջ���ص��Ǻ���ȳ������е��ص����Ƚ��ȳ������ԣ�������ջS1��S2ģ��һ������ʱ��
	S1������ջ�����Ԫ��ѹջ���Դ�ģ�����Ԫ�ص���ӡ�����Ҫ����ʱ����ջS1��ջ����
	��ѹ��ջS2�У�S1��������ջ��Ԫ�أ���S2�д���ջ����S2��ջ���൱�ڶ��еĳ��ӣ�ʵ
	�����Ƚ��ȳ���

	ʵ��Ҫ��
	1��Ҫ������ջS1��S2�ĳ��ȶ���5��Ҳ����˵���������Դ��10��Ԫ�أ�����10��Ԫ����Ҫ����ʧ�ܡ�
	2��EnQueue��DeQueue��IsEmptyQueue�ķ���ֵ���ϸ���˵�����أ���������������
	3���밴���㷨˵��ʵ�ָ��㷨����Ҫ����������ʽʵ�ֶ��С�
	���ϸ�������Ҫ��ʵ�֣����򽫵�������ִ��ʧ�ܡ�

	�Ƽ�ʵ�ֲ��裺
	1������ʵ��ջ���㷨��Ҳ����ջ���ĸ�������
	2��Ȼ��ο��㷨˵����ͨ��������ջ�Ĳ�����ģ��һ�����С�
	*/
	
	private static Stack<Integer> stack1 = new Stack<Integer>();
	private static Stack<Integer> stack2 = new Stack<Integer>();

	//��ʼ��STջ����ʼ����ɺ��ջΪ�գ�û���κ�Ԫ�أ�
	@SuppressWarnings("rawtypes")
	public static int initSt(Object st)
	{
	    /*�ڴ���Ӵ���*/
		if(st instanceof Stack)
		{
			((Stack) st).clear();
		}
		return 0;
	}

	//Ԫ��x��STջ��
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static int push(Object st, int x)
	{
	    /*�ڴ���Ӵ���*/
		if(st instanceof Stack)
		{
			((Stack)st).push(x);
		}
	    return x;
	}

	//STջ��Ԫ�س�ջ����������x��
	@SuppressWarnings("rawtypes")
	public static int pop(Object st, int  x)
	{
	    /*�ڴ���Ӵ���*/
		if(st instanceof Stack)
		{
			x = (Integer) ((Stack)st).pop();
		}
	    return x;
	}

	//��STջ�Ƿ�Ϊ�ա�
	@SuppressWarnings("rawtypes")
	public static int isEmpty(Object st)
	{
	    /*�ڴ���Ӵ���*/
		if(st instanceof Stack)
		{
			return ((Stack)st).isEmpty()? 0:1;
		}
		return 1;
	}

	//��ʼ�����У���ʼ����ɺ�Ķ���Ϊ�գ�û���κ�Ԫ�أ�
	public static int initQueue()
	{
	    /*�ڴ���Ӵ���*/
		initSt(stack1);
		initSt(stack2);
		return 0;
	}

	//��Ԫ��Elem������У�������гɹ�����0�����򷵻�1��
	public static int enQueue(EnQueueInf  elem)
	{
	    /*�ڴ���Ӵ���*/
		if(stack1.size() < 5)
		{
			push(stack1, elem.enElem);
			return 0;
		}
		else if(stack1.size()==5)
		{
			if(!(isEmpty(stack2)==0))
			{
				return 1;
			}
			else
			{
				while(!(isEmpty(stack1)==0))
				{
					int x = 0;
					x = pop(stack1, x);
					push(stack2, x);
				}
			}
			push(stack1, elem.enElem);
			return 0;
		}
		else
		{
			return 1;
		}
	}

	//�Ӷ�����ȡ��һ��Ԫ�ط���pElem���������гɹ�����0�����򷵻�1��
	public static int deQueue(DeQueueInf  elem)
	{
	    /*�ڴ���Ӵ���*/
		if(!(isEmpty(stack2)==0))
		{
			elem.deElem = pop(stack2, elem.deElem);
			return 0;
		}
		
		if(isEmpty(stack1)==0)
		{
			return 1;
		}
		else
		{
			while(!(isEmpty(stack1)==0))
			{
				int x = 0;
				x = pop(stack1, x);
				push(stack2, x);
			}
			
			elem.deElem = pop(stack2, elem.deElem);
			
			return 0;
		}
	}

	//���ö����Ƿ�Ϊ�գ�����ǿ��򷵻�1��������ǿ��򷵻�0��
	public static int isEmptyQueue()
	{
	    /*�ڴ���Ӵ���*/
		if(isEmpty(stack1)==0 && isEmpty(stack2)==0)
		{
			return 1;
		}
		
		return 0;
	}
}