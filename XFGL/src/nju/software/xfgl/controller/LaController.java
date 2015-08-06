package nju.software.xfgl.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import nju.software.xfgl.cache.CacheFactory;
import nju.software.xfgl.cache.CacheKey;
import nju.software.xfgl.common.LaConstants;
import nju.software.xfgl.common.SessionKey;
import nju.software.xfgl.model.DsrDw;
import nju.software.xfgl.model.DsrGr;
import nju.software.xfgl.model.DsrJb;
import nju.software.xfgl.model.DsrXpJg;
import nju.software.xfgl.model.LaLasq;
import nju.software.xfgl.service.XFGLService;
import nju.software.xfgl.util.DataDicUtil;
import nju.software.xfgl.util.DateUtil;
import nju.software.xfgl.util.LaUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/la")
public class LaController 
{
	public static Logger log = Logger.getLogger(LaController.class);
	
	private static Map<String, DsrGr> dsrGrMap = new HashMap<String, DsrGr>();
	
	private static Map<String, DsrDw> dsrDwMap = new HashMap<String, DsrDw>();
	
	private static Map<String, DsrXpJg> dsrXpJgMap = new HashMap<String, DsrXpJg>();
	
	private static Map<String, DsrJb> dsrJbMap = new HashMap<String, DsrJb>();
	
	@Autowired
    HttpServletRequest request;
	
	@Autowired
	private XFGLService spgkService;
	
	private Integer ajxh = 0;
	
	private Integer dsrbh = 0;
	
	@RequestMapping("/index")
	public ModelAndView showLaIndex()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("laIndex");
		return mav;
	}
	
	@RequestMapping("/overview")
	public ModelAndView showLaOverview()
	{
		List<String> noticeList = new ArrayList<String>();
		noticeList.add(LaConstants.LA_NOTICE1);
		noticeList.add(LaConstants.LA_NOTICE2);
		noticeList.add(LaConstants.LA_NOTICE3);
		noticeList.add(LaConstants.LA_NOTICE4);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("noticeList", noticeList);
		mav.setViewName("laOverview");
		return mav;
	}
	
	@RequestMapping("/notice")
	public ModelAndView showLaNotice()
	{
		List<String> mssajList = new ArrayList<String>();
		mssajList.add(LaConstants.MSSAJ_CONTENT1);
		mssajList.add(LaConstants.MSSAJ_CONTENT2);
		mssajList.add(LaConstants.MSSAJ_CONTENT3);
		mssajList.add(LaConstants.MSSAJ_CONTENT4);
		mssajList.add(LaConstants.MSSAJ_CONTENT4_1);
		mssajList.add(LaConstants.MSSAJ_CONTENT4_2);
		mssajList.add(LaConstants.MSSAJ_CONTENT4_3);
		mssajList.add(LaConstants.MSSAJ_CONTENT5);
		
		List<String> xzspList = new ArrayList<String>();
		xzspList.add(LaConstants.XZSP_CONTENT1);
		xzspList.add(LaConstants.XZSP_CONTENT2);
		xzspList.add(LaConstants.XZSP_CONTENT3);
		xzspList.add(LaConstants.XZSP_CONTENT4);
		xzspList.add(LaConstants.XZSP_CONTENT5);
		xzspList.add(LaConstants.XZSP_CONTENT6);
		
		List<String> zxajList = new ArrayList<String>();
		zxajList.add(LaConstants.ZXAJ_CONTENT1);
		zxajList.add(LaConstants.ZXAJ_CONTENT2);
		zxajList.add(LaConstants.ZXAJ_CONTENT3);
		zxajList.add(LaConstants.ZXAJ_CONTENT4);
		zxajList.add(LaConstants.ZXAJ_CONTENT5);
		zxajList.add(LaConstants.ZXAJ_CONTENT6);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("mssajList", mssajList);
		mav.addObject("xzspList", xzspList);
		mav.addObject("zxajList", zxajList);
		mav.setViewName("laNotes");
		//mav.setViewName("laNotice");
		
		return mav;
	}
	
	@RequestMapping("/search")
	public ModelAndView showLaSearch()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("laSearch");
		return mav;
	}
	
	@RequestMapping("/ylacx")
	public ModelAndView ylacx(
			@RequestParam("cxbh")String cxbh,
			@RequestParam("cxmm")String cxmm)
	{
		ModelAndView mav = new ModelAndView();
		
		LaLasq lasq = spgkService.getLASQByBHMM(cxbh, cxmm);
		if(lasq==null)
		{
			mav.setViewName("laCxFail");
		}
		else
		{
			String sqrq = DateUtil.getStringByDate(lasq.getLasqrq());//申请日期
			int symbol = lasq.getSymbol();
			String shzt = "";
			if(symbol==0)
			{
				shzt = "未审核";
			}
			else if(symbol==1)
			{
				shzt = "正在审核中";
			}
			else if(symbol==2)
			{
				shzt = "已审核";
			}
			mav.addObject("lasq", lasq);
			mav.addObject("sqrq", sqrq);
			mav.addObject("shzt", shzt);
			mav.setViewName("laCxjg");
		}
		
		return mav;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/zxyla")
	public ModelAndView zxyla()
	{
		CacheFactory cacheFactory = CacheFactory.getInstance();
		List<String> countryList = (List<String>)cacheFactory.getObject(CacheKey.DSR_GR_SSGJ);
		List<String> raceList = (List<String>)cacheFactory.getObject(CacheKey.DSR_GR_MZ);
		List<String> zjlbList = (List<String>)cacheFactory.getObject(CacheKey.DSR_GR_ZJLB);
		List<String> qygmList = (List<String>)cacheFactory.getObject(CacheKey.DSR_DW_GYQYGM);
		List<String> frdjzlbList = (List<String>)cacheFactory.getObject(CacheKey.DSR_DW_DJZLB);
		List<String> syzxzList = (List<String>)cacheFactory.getObject(CacheKey.DSR_DW_FRXZ);
		List<String> jgxzList = (List<String>)cacheFactory.getObject(CacheKey.DSR_XP_JG_XZJGXZ);
		List<String> xzjgdjzlbList = (List<String>)cacheFactory.getObject(CacheKey.DSR_XP_JG_DJZLB);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("laPreapply");
		mav.addObject("countryList", countryList);
		mav.addObject("raceList", raceList);
		mav.addObject("zjlbList", zjlbList);
		mav.addObject("qygmList", qygmList);
		mav.addObject("frdjzlbList", frdjzlbList);
		mav.addObject("syzxzList", syzxzList);
		mav.addObject("jgxzList", jgxzList);
		mav.addObject("xzjgdjzlbList", xzjgdjzlbList);
		return mav;
	}
	
	@RequestMapping(value="/tjzrr", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addZrr(
    		@RequestParam("id")String id,
    		@RequestParam("ssdw")String ssdw,
    		@RequestParam("dsrlb")String dsrlb,
    		@RequestParam("xm")String xm,
    		@RequestParam("xb")String xb,
    		@RequestParam("csrq")String csrq,
    		@RequestParam("gj")String gj,
    		@RequestParam("mz")String mz,
    		@RequestParam("yb")String yb,
    		@RequestParam("dh")String dh,
    		@RequestParam("zwzy")String zwzy,
    		@RequestParam("zjlx")String zjlx,
    		@RequestParam("zjhm")String zjhm,
    		@RequestParam("gzdw")String gzdw,
    		@RequestParam("jzd")String jzd,
    		@RequestParam("zzd")String zzd)
    {
		DsrJb dsrJb;
		DsrGr dsrGr;
		
		if(dsrJbMap.get(id)!=null && dsrGrMap.get(id)!=null)
		{
			dsrJb = dsrJbMap.get(id);
			dsrGr = dsrGrMap.get(id);
		}
		else
		{
		    dsrJb = new DsrJb();
		    dsrGr = new DsrGr();
		    if(ajxh==0)
		    {
		    	ajxh = spgkService.getMinAJXH() - 1;
		    }
		    if(dsrbh==0)
		    {
		    	dsrbh = spgkService.getMaxDSRBH() + 1;
		    }
		    else
		    {
		    	dsrbh += 1;
		    }
			
			dsrJb.setAjxh(ajxh);
			dsrJb.setDsrbh(dsrbh);
			dsrJb.setDsrssdw(ssdw);
			dsrJb.setDsrlb(dsrlb);
			dsrJb.setDsrjc(xm);
			dsrJb.setSymbol(0);//设置标志位，表示外网
			dsrJbMap.put(id, dsrJb);
			
			dsrGr.setAjxh(ajxh);
			dsrGr.setDsrbh(dsrbh);
		}
		
		dsrGr.setXm(xm);
		dsrGr.setXb(xb);
		Date bornDate = DateUtil.getDateByString(csrq);
		dsrGr.setCsnyr(bornDate);//出生日期
		dsrGr.setSsgj(gj);//国家
		dsrGr.setMz(mz);
		dsrGr.setYb(yb);
		dsrGr.setDh(dh);
		dsrGr.setZwzy(zwzy);
		dsrGr.setZjlb(zjlx);
		dsrGr.setSfzhm(zjhm);
		dsrGr.setGzdw(gzdw);
        dsrGr.setDz(jzd);		
		dsrGr.setZzd(zzd);
		dsrGr.setSymbol(0);
		if(dsrGrMap.get(id)==null)
		{
		    dsrGrMap.put(id, dsrGr);
		}
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("result", "success");
		return modelMap;
    }
	
	@RequestMapping(value="/tjfr", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addFr(
    		@RequestParam("id")String id,
    		@RequestParam("ssdw")String ssdw,
    		@RequestParam("dsrlb")String dsrlb,
    		@RequestParam("dwqc")String dwqc,
    		@RequestParam("syzxz")String syzxz,
    		@RequestParam("dh")String dh,
    		@RequestParam("yb")String yb,
    		@RequestParam("dz")String dz,
    		@RequestParam("fddbr")String fddbr,
    		@RequestParam("zw")String zw,
    		@RequestParam("qygm")String qygm,
    		@RequestParam("lxdh")String lxdh,
    		@RequestParam("djzlb")String djzlb,
    		@RequestParam("djzh")String djzh
    		)
    {
		DsrJb dsrJb;
		DsrDw dsrDw;
		if(dsrJbMap.get(id)!=null && dsrDwMap.get(id)!=null)
		{
			dsrJb = dsrJbMap.get(id);
			dsrDw = dsrDwMap.get(id);
		}
		else
		{
			dsrJb = new DsrJb();
			dsrDw = new DsrDw();
			if(ajxh==0)
			{
				ajxh = spgkService.getMinAJXH() - 1;
			}
			if(dsrbh==0)
			{
				dsrbh = spgkService.getMaxDSRBH() + 1;
			}
			else
			{
				dsrbh += 1;
			}
			
			dsrJb.setAjxh(ajxh);
			dsrJb.setDsrbh(dsrbh);
			dsrJb.setDsrssdw(ssdw);
			dsrJb.setDsrlb(dsrlb);
			dsrJb.setDsrjc(dwqc);
			dsrJb.setSymbol(0);
			dsrJbMap.put(id, dsrJb);
			
			dsrDw.setAjxh(ajxh);
			dsrDw.setDsrbh(dsrbh);
		}
		
		dsrDw.setDwmc(dwqc);//单位全称
		dsrDw.setFrxz(syzxz);//所有制性质
		dsrDw.setDh(dh);//电话
		dsrDw.setYb(yb);//邮编
		dsrDw.setDz(dz);//地址
		dsrDw.setFddbrxm(fddbr);//法定代表人
		dsrDw.setZw(zw);//职务
		dsrDw.setGyqygm(qygm);//企业规模
		dsrDw.setLxdh(lxdh);//联系电话
		dsrDw.setDjzh(djzh);//登记证号
		dsrDw.setDjzlb(djzlb);//登记证类别
		dsrDw.setSymbol(0);
		if(dsrDwMap.get(id)==null)
		{
		    dsrDwMap.put(id, dsrDw);
		}
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("result", "success");
		return modelMap;
    }
	
	@RequestMapping(value="/tjffrqtzz", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addFfrqtzz(
    		@RequestParam("id")String id,
    		@RequestParam("ssdw")String ssdw,
    		@RequestParam("dsrlb")String dsrlb,
    		@RequestParam("jgmc")String jgmc,
    		@RequestParam("jgxz")String jgxz,
    		@RequestParam("dbrxm")String dbrxm,
    		@RequestParam("yb")String yb,
    		@RequestParam("lxdh")String lxdh,
    		@RequestParam("dz")String dz,
    		@RequestParam("sjpc")String sjpc,
    		@RequestParam("sffy")String sffy,
    		@RequestParam("djzlb")String djzlb,
    		@RequestParam("djzh")String djzh)
    {
		DsrJb dsrJb;
		DsrXpJg dsrXpJg;
		if(dsrJbMap.get(id)!=null && dsrXpJgMap.get(id)!=null)
		{
			dsrJb = dsrJbMap.get(id);
			dsrXpJg = dsrXpJgMap.get(id);
		}
		else
		{
			dsrJb = new DsrJb();
			dsrXpJg = new DsrXpJg();
			if(ajxh==0)
			{
				ajxh = spgkService.getMinAJXH() - 1;
			}
			if(dsrbh==0)
			{
				dsrbh = spgkService.getMaxDSRBH() + 1;
			}
			else
			{
				dsrbh += 1;
			}
			
			dsrJb.setAjxh(ajxh);
			dsrJb.setDsrbh(dsrbh);
			dsrJb.setDsrssdw(ssdw);
			dsrJb.setDsrlb(dsrlb);
			dsrJb.setDsrjc(jgmc);
			dsrJb.setSymbol(0);
			dsrJbMap.put(id, dsrJb);
			
			dsrXpJg.setAjxh(ajxh);
			dsrXpJg.setDsrbh(dsrbh);
		}
		dsrXpJg.setJgmc(jgmc);
		dsrXpJg.setXzjgxz(jgxz);//机关性质
		dsrXpJg.setFddbrxm(dbrxm);
		dsrXpJg.setYb(yb);
		dsrXpJg.setDh(lxdh);
		dsrXpJg.setDz(dz);
		dsrXpJg.setSfpc(sjpc);
		dsrXpJg.setSffy(sffy);
		dsrXpJg.setDjzlb(djzlb);
		dsrXpJg.setDjzh(djzh);
		dsrXpJg.setSymbol(0);
		if(dsrXpJgMap.get(id)==null)
		{
			dsrXpJgMap.put(id, dsrXpJg);
		}
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("result", "success");
		return modelMap;
    }
	
	@RequestMapping(value="/editZrr", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> editZrr(
			@RequestParam("id")String id)
	{
		DsrGr dsrGr = dsrGrMap.get(id);
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("result", dsrGr);
		String csrq = DateUtil.getStringByDate(dsrGr.getCsnyr());
		modelMap.put("csrq", csrq);//出生日期
		return modelMap;
	}
	
	@RequestMapping(value="/editFr", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> editFr(
			@RequestParam("id")String id)
	{
		DsrDw dsrDw = dsrDwMap.get(id);
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("result", dsrDw);
		return modelMap;
	}
	
	@RequestMapping(value="/editFfrqtzz", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> editFrrqtzz(
			@RequestParam("id")String id)
	{
		DsrXpJg dsrXpJg = dsrXpJgMap.get(id);
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("result", dsrXpJg);
		return modelMap;
	}
	
	
	
	@RequestMapping(value="/deleteZrr", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteZrr(
    		@RequestParam("id")String id)
    {
		dsrJbMap.remove(id);
		dsrGrMap.remove(id);
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("result", "success");
		return modelMap;
    }
	
	@RequestMapping(value="/deleteFr", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteFr(
    		@RequestParam("id")String id)
    {
		dsrJbMap.remove(id);
		dsrDwMap.remove(id);
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("result", "success");
		return modelMap;
    }
	
	@RequestMapping(value="/deleteFfrqtzz", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteFfrqtzz(
    		@RequestParam("id")String id)
    {
		dsrJbMap.remove(id);
		dsrXpJgMap.remove(id);
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("result", "success");
		return modelMap;
    }
	
	@RequestMapping("/applyLa")
	public ModelAndView applyLa(
			@RequestParam("aqsm")String aqsm,
			@RequestParam("lacxmm")String lacxmm,
			@RequestParam("zcqrmm")String zcqrmm,
			@RequestParam(value="dzyj", required = false)String dzyj,
			@RequestParam("lxdh")String lxdh)
	{
		StringBuffer zrrbh = new StringBuffer();
		StringBuffer frbh = new StringBuffer();
		StringBuffer xzjgbh = new StringBuffer();
		String zrrbhStr;
		String frbhStr;
		String xzjgbhStr;
		StringBuffer pair;
		//最终保存自然人、法人、非法人其它组织
		for(String key : dsrJbMap.keySet())
		{
			DsrJb dsrJb = dsrJbMap.get(key);
			// SSDW  DSRLB需要进行数据字典的转换
			String ssdw = dsrJb.getDsrssdw();
			if(ssdw.equalsIgnoreCase("yg"))
			{
				ssdw = "原告";
			}
			else if(ssdw.equalsIgnoreCase("bg"))
			{
				ssdw = "被告";
			}
			ssdw = DataDicUtil.getDMBH("DSR_JB", "DSRSSDW", ssdw);
			dsrJb.setDsrssdw(ssdw);
			
			String dsrlb = dsrJb.getDsrlb();
			if(dsrlb.equalsIgnoreCase("zrr") || dsrlb.equalsIgnoreCase("gr"))
			{
				dsrlb = "个人";
			}
			else if(dsrlb.equalsIgnoreCase("fr"))
			{
				dsrlb = "法人";
			}
			else if(dsrlb.equalsIgnoreCase("xzjg") || dsrlb.equalsIgnoreCase("ffrqtzz"))
			{
				dsrlb = "行政机关";
			}
			dsrlb = DataDicUtil.getDMBH("DSR_JB", "DSRLB", dsrlb);
			dsrJb.setDsrlb(dsrlb);
			
			spgkService.saveNewDSR_JB(dsrJb);
		}
		
		for(String key : dsrGrMap.keySet())
		{
			DsrGr dsrGr = dsrGrMap.get(key);
			// XB  SSGJ  MZ  ZJLB 需要进行数据字段的转换
			String xb = dsrGr.getXb();
			xb = DataDicUtil.getDMBH("DSR_GR", "XB", xb);
			dsrGr.setXb(xb);
			
			String ssgj = dsrGr.getSsgj();
			ssgj = DataDicUtil.getDMBH("DSR_GR", "SSGJ", ssgj);
			dsrGr.setSsgj(ssgj);
			
			String mz = dsrGr.getMz();
			mz = DataDicUtil.getDMBH("DSR_GR", "MZ", mz);
			dsrGr.setMz(mz);
			
			String zjlb = dsrGr.getZjlb();
			zjlb = DataDicUtil.getDMBH("DSR_GR", "ZJLB", zjlb);
			dsrGr.setZjlb(zjlb);
			
			spgkService.saveNewDSR_GR(dsrGr);
			pair = new StringBuffer();
			pair.append("(").append(dsrGr.getAjxh()).append(",").append(dsrGr.getDsrbh()).append(")");
			zrrbh.append(pair.toString()).append("|");
		}
		//去掉最后一个"|"
		zrrbhStr = zrrbh.toString();
		if(zrrbhStr!=null && zrrbhStr.length()>0)
		{
			zrrbhStr = zrrbhStr.substring(0, zrrbhStr.length()-1);
		}
		
		for(String key : dsrDwMap.keySet())
		{
			DsrDw dsrDw = dsrDwMap.get(key);
			// FRXZ  GYQYGM  DJZLB 需要进行数据字典的转换
			String frxz = dsrDw.getFrxz();
			frxz = DataDicUtil.getDMBH("DSR_DW", "FRXZ", frxz);
			dsrDw.setFrxz(frxz);
			
			String gyqygm = dsrDw.getGyqygm();
			gyqygm = DataDicUtil.getDMBH("DSR_DW", "GYQYGM", gyqygm);
			dsrDw.setGyqygm(gyqygm);
			
			String djzlb = dsrDw.getDjzlb();
			djzlb = DataDicUtil.getDMBH("DSR_DW", "DJZLB", djzlb);
			dsrDw.setDjzlb(djzlb);
			
			spgkService.saveNewDSR_DW(dsrDw);
			pair = new StringBuffer();
			pair.append("(").append(dsrDw.getAjxh()).append(",").append(dsrDw.getDsrbh()).append(")");
			frbh.append(pair.toString()).append("|");
		}
		//去掉最后一个"|"
		frbhStr = frbh.toString();
		if(frbhStr!=null && frbhStr.length()>0)
		{
			frbhStr = frbhStr.substring(0, frbhStr.length()-1);
		}
		
		for(String key : dsrXpJgMap.keySet())
		{
		    DsrXpJg dsrXpJg = dsrXpJgMap.get(key);
		    // XZJGXZ DJZLB SFFY SFPC 需要进行数据字典的转换
		    String xzjgxz = dsrXpJg.getXzjgxz();
		    xzjgxz = DataDicUtil.getDMBH("DSR_XP_JG", "XZJGXZ", xzjgxz);
		    dsrXpJg.setXzjgxz(xzjgxz);
		    
		    String djzlb = dsrXpJg.getDjzlb();
		    djzlb = DataDicUtil.getDMBH("DSR_XP_JG", "DJZLB", djzlb);
		    dsrXpJg.setDjzlb(djzlb);
		    
		    String sffy = dsrXpJg.getSffy();
		    sffy = DataDicUtil.getDMBH("DSR_XP_JG", "SFFY", sffy);
		    dsrXpJg.setSffy(sffy);
		    
		    String sfpc = dsrXpJg.getSfpc();
		    sfpc = DataDicUtil.getDMBH("DSR_XP_JG", "SFPC", sfpc);
		    dsrXpJg.setSfpc(sfpc);
		    
		    spgkService.saveNewDSR_XP_JG(dsrXpJg);
		    pair = new StringBuffer();
		    pair.append("(").append(dsrXpJg.getAjxh()).append(",").append(dsrXpJg.getDsrbh()).append(")");
		    xzjgbh.append(pair.toString()).append("|");
		}
		//去掉最后一个"|"
		xzjgbhStr = xzjgbh.toString();
		if(xzjgbhStr!=null && xzjgbhStr.length()>0)
		{
			xzjgbhStr = xzjgbhStr.substring(0, xzjgbhStr.length()-1);
		}
		
		Date lasqrq = new Date();
		
		Integer lasqbh = spgkService.getMaxLASQBH() + 1;
		LaLasq lasq = new LaLasq();
		lasq.setLasqbh(lasqbh);    //立案申请编号
		lasq.setZrrbh(zrrbhStr);   //自然人编号集合
		lasq.setFrbh(frbhStr);     //法人编号集合
		lasq.setXzjgbh(xzjgbhStr); //行政机关编号集合
		lasq.setLasqrq(lasqrq);    //立案申请日期
		lasq.setAqsm(aqsm);        //案情说明
		lasq.setLacxmm(lacxmm);    //立案查询密码
		lasq.setDzyj(dzyj);        //电子邮件
		lasq.setLxdh(lxdh);        //联系电话
		String materialSessionKey = SessionKey.getSessionKey(SessionKey.LA_MODULE, SessionKey.UPLOAD_SUFFIX);
		String materialPath = (String) request.getSession().getAttribute(materialSessionKey);
		lasq.setCl(materialPath);  //材料
		
		//生成查询编号
		String cxbh = LaUtil.generateLACXBH(lasqbh);
		lasq.setCxbh(cxbh);        //查询编号
		lasq.setSymbol(0);         //内外网
		
		spgkService.saveNewLASQ(lasq);
		
		//清空map，处理浏览器后退事件
		dsrJbMap.clear();
		dsrGrMap.clear();
		dsrDwMap.clear();
		dsrXpJgMap.clear();
		
		
		//生成立案编号
		ModelAndView mav = new ModelAndView();
		mav.setViewName("laSuccess");
		mav.addObject("cxbh", cxbh);
		return mav;
	}
}
