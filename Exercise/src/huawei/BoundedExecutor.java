package huawei;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ʵ��һ���н��̳߳أ�ȷ�������ύ�������ܱ�ִ֤�С�
 * 
 */
public class BoundedExecutor extends ThreadPoolExecutor
{   
    private static final int CORESIZE = 10;
    private static final int MAXSIZE = 15;
    private static final int ALIVETIME = 30;
    private static final int QUEUESIZE = 5;
    
    public BoundedExecutor()
    {
    	super(CORESIZE, MAXSIZE, ALIVETIME, TimeUnit.SECONDS, 
                new ArrayBlockingQueue<Runnable>(QUEUESIZE));
    	
    	/* add by me */
    	RejectedExecutionHandler handler = new RejectedExecution();
        this.setRejectedExecutionHandler(handler);
    }
    
    //��ʾ����Ҫ�Զ���ܾ�����
    public static class RejectedExecution implements RejectedExecutionHandler
    {
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor)
        {
        	/* add by me */
        	synchronized(executor)
        	{
	        	if(!executor.isShutdown())
	        	{
	        		while(executor.getActiveCount() >= QUEUESIZE)
		        	{
		        		try
		        		{
							Thread.sleep(1000);
						} 
		        		catch (InterruptedException e) 
		        		{
							e.printStackTrace();
						}
		        	}
		        	
		        	executor.execute(r);
	        	}
        	}
        }        
    }
}
