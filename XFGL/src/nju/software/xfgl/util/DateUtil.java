package nju.software.xfgl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil 
{
    private static String dateFormat = "yyyy-MM-dd";
    
    public static Date getDateByString(String dateStr)
    {
    	if(StringUtil.isNullOrEmpty(dateStr))
    	{
    		return null;
    	}
    	SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    	Date date = null;
    	try 
    	{
			date = sdf.parse(dateStr);
		} 
    	catch (ParseException e) 
    	{
			e.printStackTrace();
		}
    	return date;
    }
    
    public static String getStringByDate(Date date)
    {
    	if(date==null)
    	{
    		return null;
    	}
    	SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    	return sdf.format(date);
    }
    
    public static String getStringByDate(Date date, String format)
    {
    	if(date==null)
    	{
    		return null;
    	}
    	SimpleDateFormat sdf = new SimpleDateFormat(format);
    	return sdf.format(date);
    }
}
