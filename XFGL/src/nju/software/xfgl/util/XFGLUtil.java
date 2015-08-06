package nju.software.xfgl.util;

import java.util.Date;

public class XFGLUtil 
{
	public static String generateLFCXBH(int lfdjId)
    {
    	StringBuffer cxbh = new StringBuffer();
    	Date date = new Date();
    	String dateStr = DateUtil.getStringByDate(date, "yyyyMMdd");
    	cxbh.append(dateStr).append(lfdjId);
    	return cxbh.toString();
    }
}
