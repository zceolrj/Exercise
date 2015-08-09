package huawei;

import java.util.Stack;

public class MiddlefixToSuffix 
{
	public static String midToSufix(String midfix)
	{
		Stack<Character> stack = new Stack<Character>();
		char[] charArr = midfix.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<charArr.length;i++)
		{
			char c = charArr[i];
			if(c=='(')
			{
				stack.push('(');
			}
			else if(c==')')
			{
				while(!stack.isEmpty() && stack.peek()!= '(')
				{
					sb.append(stack.pop());
				}
				if(!stack.isEmpty() && stack.peek()=='(')
				{
					stack.pop();
				}
			}
			else if(isOperator(c))
			{
				if(stack.isEmpty())
				{
					stack.push(c);
				}
				else
				{
					while(!stack.isEmpty() && comp(stack.peek(), c) >= 0)
					{
						sb.append(stack.pop());
					}
					stack.push(c);
				}
			}
			else
			{
				sb.append(c);
			}
		}
		
		while(!stack.isEmpty())
		{
			sb.append(stack.pop());
		}
		
		return sb.toString();
	}
	
	public static boolean isOperator(char c)
	{
		if(c=='+' || c=='-' || c=='*' || c=='/')
		{
			return true;
		}
		return false;
	}
	
	public static int comp(char c1, char c2)
	{
		if(c1=='+' || c1=='-')
		{
			if(c2=='+' || c2=='-')
			{
				return 0;
			}
			else
			{
				return -1;
			}
		}
		
		if(c1=='*' || c1=='/')
		{
			if(c2=='+' || c2=='-')
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) 
	{
		String mid = "a+b*c+(d*e+f)*g";
		String res = midToSufix(mid);
		
		System.out.println(res);
	}

}
