package nju.software.xfgl.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nju.software.xfgl.bean.DataDic;
import nju.software.xfgl.bean.Pair;
import nju.software.xfgl.bean.TableComment;
import nju.software.xfgl.cache.CacheFactory;
import nju.software.xfgl.cache.CacheKey;
import nju.software.xfgl.common.DataDicParser;
import nju.software.xfgl.model.PubDmb;
import nju.software.xfgl.service.XFGLService;

import org.springframework.beans.factory.InitializingBean;

public class InitDataDicListener implements InitializingBean
{
	private CacheFactory cacheFac = CacheFactory.getInstance();
	
	private XFGLService xfglService;

	@Override
	public void afterPropertiesSet() throws Exception 
	{
		DataDicParser parser = new DataDicParser();
		parser.parseDataDic();
		String configKey = "DATADIC_CONFIG";
		cacheFac.putObject(configKey, parser.getTcMap());
		
		List<TableComment> tables = parser.getTableList();
		for(int i=0;i<tables.size();i++)
		{
			TableComment table = tables.get(i);
			String tableName = table.getTableName();
			Map<String, String> columnMap = table.getColMap();
			DataDic dataDic = new DataDic();
			dataDic.setTableName(tableName);
			for(String colName : columnMap.keySet())
			{
				String comment = columnMap.get(colName);
				Map<String, String> colValsMap = new HashMap<String, String>();
				List<Pair<String, String>> pairList = new ArrayList<Pair<String, String>>();
				if(comment.equals("Y/N"))
				{
					
					colValsMap.put("是", "Y");
					colValsMap.put("否", "N");
					
				}
				else
				{
					String hql = "select new PubDmb(p.dmbh, p.dmms) from PubDmb p where p.lbbh=?";
					//		+ " order by p.lbbh";

				    List<PubDmb> results = xfglService.getDataDic(hql, comment);
				    for(int j=0;j<results.size();j++)
				    {
						PubDmb pubDmb = results.get(j);
						String dmbh = pubDmb.getDmbh();
						String dmms = pubDmb.getDmms();
						colValsMap.put(dmms, dmbh);
						
						Pair<String, String> pair = new Pair<String, String>(dmms, dmbh);
						pairList.add(pair);
				    }
				}
				dataDic.getColumnMap().put(colName, colValsMap);
				dataDic.getColPairMap().put(colName, pairList);
			}
			
			//放入缓存
			String tablekey = tableName.toUpperCase() + CacheKey.DATADIC_SUFFIX;
			cacheFac.putObject(tablekey, dataDic);
		}
		
		getDataFromDataDic();
	}
	
	/**
	 * 读取国家、民族、证件类别等信息
	 */
	private void getDataFromDataDic()
	{
		//涉及到三张表：DSR_GR  DSR_DW  DSR_XP_JG
		String cacheKey;
		DataDic dsrGrDic, dsrDwDic, dsrXpjgDic;
		Map<String, List<Pair<String, String>>> colPairMap;
		List<Pair<String, String>> colValList;
		
		//DSR_GR
		cacheKey = "DSR_GR_DATADIC";
		dsrGrDic = (DataDic)cacheFac.getObject(cacheKey);
		colPairMap = dsrGrDic.getColPairMap();
		//DSR_GR SSGJ国家     MZ民族   ZJLB证件类别
		String[] grCols = {"SSGJ", "MZ", "ZJLB"};
		String[] grKeys = {CacheKey.DSR_GR_SSGJ, CacheKey.DSR_GR_MZ, CacheKey.DSR_GR_ZJLB};
		for(int i=0;i<grCols.length;i++)
		{
			colValList = colPairMap.get(grCols[i]);
			List<String> list = new ArrayList<String>();
			for(int j=0;j<colValList.size();j++)
			{
				list.add(colValList.get(j).getKey());
			}
			cacheFac.putObject(grKeys[i], list);
		}
		
		//DSR_DW
		cacheKey = "DSR_DW_DATADIC";
		dsrDwDic = (DataDic)cacheFac.getObject(cacheKey);
		colPairMap = dsrDwDic.getColPairMap();
		//DSR_DW GYQYGM国有企业规模   DJZLB登记证类别  FRXZ法人性质
		String[] dwCols = {"GYQYGM", "DJZLB", "FRXZ"};
		String[] dwKeys = {CacheKey.DSR_DW_GYQYGM, CacheKey.DSR_DW_DJZLB, CacheKey.DSR_DW_FRXZ};
		for(int i=0;i<dwCols.length;i++)
		{
			colValList = colPairMap.get(dwCols[i]);
			List<String> list = new ArrayList<String>();
			for(int j=0;j<colValList.size();j++)
			{
				list.add(colValList.get(j).getKey());
			}
			cacheFac.putObject(dwKeys[i], list);
		}
		
		//DSR_XP_JG
		cacheKey = "DSR_XP_JG_DATADIC";
		dsrXpjgDic = (DataDic)cacheFac.getObject(cacheKey);
		colPairMap = dsrXpjgDic.getColPairMap();
		//DSR_XP_JG   XZJGXZ行政机关性质    DJZLB登记证类别
		String[] xpjgCols = {"XZJGXZ", "DJZLB"};
		String[] xpjgKeys = {CacheKey.DSR_XP_JG_XZJGXZ, CacheKey.DSR_XP_JG_DJZLB};
		for(int i=0;i<xpjgCols.length;i++)
		{
			colValList = colPairMap.get(xpjgCols[i]);
			List<String> list = new ArrayList<String>();
			for(int j=0;j<colValList.size();j++)
			{
				list.add(colValList.get(j).getKey());
			}
			cacheFac.putObject(xpjgKeys[i], list);
		}
	}

	public XFGLService getXfglService() {
		return xfglService;
	}

	public void setXfglService(XFGLService xfglService) {
		this.xfglService = xfglService;
	}
	   
}
