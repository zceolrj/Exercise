package nju.software.xfgl.common;

public class SessionKey 
{
    public final static String LFDJ_MODULE = "LFDJ";
    
    public final static String LA_MODULE = "LA";
	
	public final static String UPLOAD_SUFFIX = "UPLOAD_PATH";
    
    public final static String KAPTCHA_SUFFIX = "KAPTCHA";
	
	/**
     * 获取session key
     * 
     * @param module 哪个模块   eg. lfdj(来访登记)  la(立案)
     * @param function  什么功能   eg. KAPTCHA_SUFFIX(验证码)  UPLOAD_SUFFIX(文件上传)
     * @return
     */
    public static String getSessionKey(String module, String function)
    {
    	String sessionKey = getKeyPrefix(module) + "-" + function;
    	return sessionKey;
    }
    
    public static String getKeyPrefix(String module)
    {
    	if(module.equalsIgnoreCase(LFDJ_MODULE))
    	{
    		return LFDJ_MODULE;
    	}
    	else if(module.equalsIgnoreCase(LA_MODULE))
    	{
    		return LA_MODULE;
    	}
    	return null;
    }
    
    public static String getKeySuffix(String function)
    {
    	if(function.equalsIgnoreCase(KAPTCHA_SUFFIX))
    	{
    		return KAPTCHA_SUFFIX;
    	}
    	else if(function.equalsIgnoreCase(UPLOAD_SUFFIX))
    	{
    		return UPLOAD_SUFFIX;
    	}
    	return null;
    }
}
