package nju.software.xfgl.bean;

import nju.software.xfgl.util.StringUtil;

public class ShortMessage 
{
    private final static String messageHeader = "您好！";
    
    private final static String messageTail = "请您尽快处理，谢谢！";
    
    private StringBuffer messageBody;
    
    private StringBuffer wholeMessage;
    
    public ShortMessage()
    {
    	
    }
    
    public void generateMsgForLFDJ(int lfbh, String zylfzxm)
    {
    	messageBody = new StringBuffer();
    	wholeMessage = new StringBuffer();
    	messageBody.append("编号为").append(lfbh);
    	if(!StringUtil.isNullOrEmpty(zylfzxm))
		{
			messageBody.append("来访者为").append(zylfzxm);
		}
    	messageBody.append("的信访");
		wholeMessage.append(messageHeader).append(messageBody.toString()).append(messageTail);
    }
    
    public String toString()
    {
    	return wholeMessage.toString();
    }
}
