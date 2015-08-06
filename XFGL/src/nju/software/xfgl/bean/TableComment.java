package nju.software.xfgl.bean;

import java.util.HashMap;
import java.util.Map;

public class TableComment 
{
    private String tableName;
    
    /**
     * <columnName, comment>   eg. <DJZLB, FBS0002-TM>
     */
    private Map<String, String> colMap;
    
    public TableComment()
    {
    	colMap = new HashMap<String, String>();
    }
    
    public TableComment(String tableName)
    {
    	this.tableName = tableName;
    	colMap = new HashMap<String, String>();
    }

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Map<String, String> getColMap() {
		return colMap;
	}

	public void setColMap(Map<String, String> colMap) {
		this.colMap = colMap;
	}
    
    
}
