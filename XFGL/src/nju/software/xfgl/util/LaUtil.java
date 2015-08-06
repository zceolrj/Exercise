package nju.software.xfgl.util;

import java.util.Date;

public class LaUtil 
{
    public static String generateLACXBH(int lasqId)
    {
    	StringBuffer cxbh = new StringBuffer();
    	Date date = new Date();
    	String dateStr = DateUtil.getStringByDate(date, "yyyyMMdd");
    	cxbh.append(dateStr).append(lasqId);
    	return cxbh.toString();
    }
    
}
