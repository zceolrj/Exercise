package nju.software.xfgl.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataDic 
{
    private String tableName;
    
    /**
     * <column, <dmms, dmbh>>   方便通过map进行查找
     */
    private Map<String, Map<String, String>> columnMap;
    
    /**
     * 方便显示的时候按照原有顺序
     */
    private Map<String, List<Pair<String, String>>> colPairMap;
    
    public DataDic()
    {
    	tableName = "";
    	columnMap = new HashMap<String, Map<String, String>>();
    	colPairMap = new HashMap<String, List<Pair<String, String>>>();
    }
    
    public DataDic(String tableName)
    {
    	this.tableName = tableName;
    	columnMap = new HashMap<String, Map<String, String>>();
    	colPairMap = new HashMap<String, List<Pair<String, String>>>();
    }

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Map<String, Map<String, String>> getColumnMap() {
		return columnMap;
	}

	public void setColumnMap(Map<String, Map<String, String>> columnMap) {
		this.columnMap = columnMap;
	}

	public Map<String, List<Pair<String, String>>> getColPairMap() {
		return colPairMap;
	}

	public void setColPairMap(Map<String, List<Pair<String, String>>> colPairMap) {
		this.colPairMap = colPairMap;
	}
    
    
}
