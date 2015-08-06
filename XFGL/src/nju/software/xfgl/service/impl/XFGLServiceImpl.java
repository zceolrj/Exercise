package nju.software.xfgl.service.impl;

import java.util.List;

import nju.software.xfgl.dao.XFGLDao;
import nju.software.xfgl.model.DsrDw;
import nju.software.xfgl.model.DsrGr;
import nju.software.xfgl.model.DsrJb;
import nju.software.xfgl.model.DsrXpJg;
import nju.software.xfgl.model.LaLasq;
import nju.software.xfgl.model.PubDmb;
import nju.software.xfgl.model.XfglLfdj;
import nju.software.xfgl.service.XFGLService;

public class XFGLServiceImpl implements XFGLService
{
    private XFGLDao xfglDao;
	
	public Integer getMaxLFBH()
	{
		return xfglDao.getMaxLFBH();
	}
    
    @Override
	public void addXFGL_LFDJ(XfglLfdj xfgl_lfdj) 
	{
		xfglDao.addXFGL_LFDJ(xfgl_lfdj);
	}
	
	public int stateSearch(String lfcxbh, String password)
	{
		return xfglDao.stateSearch(lfcxbh, password);
	}
	
	public XfglLfdj validateUser(String username, String password)
	{
		return xfglDao.validateUser(username, password);
	}
	
	public void saveNewDSR_JB(DsrJb dsrJb)
	{
		xfglDao.saveNewDSR_JB(dsrJb);
	}
	
    public void saveNewDSR_GR(DsrGr dsrGr)
    {
    	xfglDao.saveNewDSR_GR(dsrGr);
    }
    
    public void saveNewDSR_DW(DsrDw dsrDw)
    {
    	xfglDao.saveNewDSR_DW(dsrDw);
    }
    
    public void saveNewDSR_XP_JG(DsrXpJg dsrXpJg)
    {
    	xfglDao.saveNewDSR_XP_JG(dsrXpJg);
    }
    
    public Integer getMaxLASQBH()
    {
    	return xfglDao.getMaxLASQBH();
    }
    
    public Integer getMinAJXH()
    {
    	return xfglDao.getMinAJXH();
    }
    
    public Integer getMaxDSRBH()
    {
    	return xfglDao.getMaxDSRBH();
    }
    
    public void saveNewLASQ(LaLasq lasq)
    {
    	xfglDao.saveNewLASQ(lasq);
    }
    
    public LaLasq getLASQByBHMM(String cxbh, String cxmm)
    {
    	return xfglDao.getLASQByBHMM(cxbh, cxmm);
    }
    
    public List<PubDmb> getDataDic(String hql, String comment)
    {
    	return xfglDao.getDataDic(hql, comment);
    }
	

	public void setXfglDao(XFGLDao xfglDao) {
		this.xfglDao = xfglDao;
	}

}
