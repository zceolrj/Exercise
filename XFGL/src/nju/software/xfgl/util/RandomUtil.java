package nju.software.xfgl.util;

import java.util.Random;

public class RandomUtil 
{
    private static Random random = new Random();
    
    public static int getNegativeRandomNum(int scope)
    {
    	return -random.nextInt(scope);
    }
}
