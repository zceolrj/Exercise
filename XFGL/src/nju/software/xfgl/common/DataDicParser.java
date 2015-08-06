package nju.software.xfgl.common;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nju.software.xfgl.bean.TableComment;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DataDicParser 
{
	private final static String XMLPATH = "nju/software/xfgl/xml/DataDic.xml";
	
	private List<TableComment> tableList;
    
    /**
     * <String, TableComment> = <tableName, TableComment>
     */
    private Map<String, TableComment> tcMap;
    
    public DataDicParser()
    {
    	tableList = new ArrayList<TableComment>();
    	tcMap = new HashMap<String, TableComment>();
    }
    
    @SuppressWarnings("unchecked")
	public void parseDataDic()
    {
    	InputStream in = DataDicParser.class.getClassLoader().getResourceAsStream(XMLPATH);
    	SAXReader reader = new SAXReader();
    	try 
    	{
			Document document = reader.read(in);
			Element database = document.getRootElement();
			List<Element> tables = database.elements("table");
			for(int i=0;i<tables.size();i++)
			{
				Element table = tables.get(i);
				Element tableName = table.element("table-name");
				List<Element> properties = table.elements("property");
				
				TableComment tableComment = new TableComment();
				tableComment.setTableName(tableName.getText());
				for(int j=0;j<properties.size();j++)
				{
					Element property = properties.get(j);
					Element name = property.element("name");
					Element comment = property.element("comment");
					tableComment.getColMap().put(name.getText(), comment.getText());
				}
				tableList.add(tableComment);
				tcMap.put(tableName.getText(), tableComment);
			}
		} 
    	catch (DocumentException e) 
    	{
			e.printStackTrace();
		}
    }

	public List<TableComment> getTableList() {
		return tableList;
	}

	public void setTableList(List<TableComment> tableList) {
		this.tableList = tableList;
	}

	public Map<String, TableComment> getTcMap() {
		return tcMap;
	}

	public void setTcMap(Map<String, TableComment> tcMap) {
		this.tcMap = tcMap;
	}   
}
