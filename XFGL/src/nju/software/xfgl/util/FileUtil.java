package nju.software.xfgl.util;

import java.util.Date;

public class FileUtil 
{
    public static String generateFileName(String originalFileName)
    {
    	int splitIndex = originalFileName.lastIndexOf(".");
    	String prefix = originalFileName.substring(0, splitIndex) + "_" + new Date().getTime();
    	String suffix = originalFileName.substring(splitIndex);
    	
    	return prefix + suffix;
    }
}
