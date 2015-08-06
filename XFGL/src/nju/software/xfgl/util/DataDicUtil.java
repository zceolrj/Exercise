package nju.software.xfgl.util;

import java.util.Map;

import nju.software.xfgl.bean.DataDic;
import nju.software.xfgl.cache.CacheFactory;
import nju.software.xfgl.cache.CacheKey;

public class DataDicUtil 
{
    private static CacheFactory cacheFac = CacheFactory.getInstance();
    
    /**
     * 获取DMBH
     * 
     * @param tableName 表名
     * @param columnName 列名
     * @param columnValue 列值,即DMMS
     * @return DMBH
     */
    public static String getDMBH(String tableName, String columnName, String columnValue)
    {
    	String tableKey = tableName.toUpperCase() + CacheKey.DATADIC_SUFFIX;
    	DataDic dataDic = (DataDic)cacheFac.getObject(tableKey);
    	if(dataDic==null)
    	{
    		return columnName;
    	}
    	Map<String, Map<String, String>> columnMap = dataDic.getColumnMap();
    	if(columnMap==null)
    	{
    		return columnName;
    	}
    	Map<String, String> colValMap = columnMap.get(columnName);
    	if(colValMap==null || !colValMap.containsKey(columnValue))
    	{
    		return columnName;
    	}
    	return colValMap.get(columnValue);
    }
}
