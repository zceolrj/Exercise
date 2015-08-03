package huawei;

public final class BinaryTreeHeightWidth {

	public static class BiNode {

		public char data;
		public BiNode left;
		public BiNode right;

		public BiNode(char data) {
			this.data = data;
		
		}
	}

	public static class BiNodeInfo {
		public int width = 0;
		public int height = 0;
	}

	/*
	 * Description 给定一个二叉树，获取该二叉树的宽度深度。
	 * Input Param: head  需要获取深度的二叉树头结点 
	 * Return Value: width 宽度 height 高度 
	 */
	public static BiNodeInfo getBiNodeInfo(BiNode head) {
		/* 在这里实现功能 */
		BiNodeInfo bni = new BiNodeInfo();
		bni.width = getWidth(head);
		bni.height = getHeight(head);
		return bni;
	}
	
	public static int getWidth(BiNode node)
	{
		if(node==null)
		{
			return 0;
		}
		
		if(node.left==null && node.right==null)
		{
			return 1;
		}
		
		int width = getWidth(node.left) + getWidth(node.right);
		
		return width;
	}
	
	public static int getHeight(BiNode node)
	{
		if(node==null)
		{
			return 0;
		}
		
		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);
		
		return 1 + Math.max(leftHeight, rightHeight);
	}
}