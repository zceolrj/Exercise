package nju.software.xfgl.dao.impl;

import java.util.List;

import nju.software.xfgl.dao.XFGLDao;
import nju.software.xfgl.model.DsrDw;
import nju.software.xfgl.model.DsrGr;
import nju.software.xfgl.model.DsrJb;
import nju.software.xfgl.model.DsrXpJg;
import nju.software.xfgl.model.LaLasq;
import nju.software.xfgl.model.PubDmb;
import nju.software.xfgl.model.XfglLfdj;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class XFGLDaoImpl implements XFGLDao
{
    private SessionFactory sessionFactory;
    
    HibernateTemplate hibernatetemplate;
    
    private HibernateTemplate getHibernateTemplate()
    {
    	if(hibernatetemplate==null)
    	{
    		hibernatetemplate = new HibernateTemplate(sessionFactory);
    	}
    	return hibernatetemplate;
    }
    
    @SuppressWarnings("unchecked")
	public Integer getMaxLFBH()
    {
    	String hql = "select max(x.bh) from XfglLfdj x";
		List<Integer> list = getHibernateTemplate().find(hql);
		if(list!=null && !list.isEmpty() && list.get(0)!=null)
		{
			return list.get(0);
		}
		return new Integer(0);
    }
    
    public void addXFGL_LFDJ(XfglLfdj xfgl_lfdj)
    {
    	getHibernateTemplate().save(xfgl_lfdj);
    }
    
    @SuppressWarnings("unchecked")
	public int stateSearch(String lfcxbh, String password)
    {
    	String hql = "select symbol from XfglLfdj x where x.lfcxbh=? and x.jgcxmm=?";
    	List<Integer> list = (List<Integer>)getHibernateTemplate().find(hql, new Object[]{lfcxbh, password});
    	if(list!=null && !list.isEmpty())
    	{
    		return list.get(0);
    	}
    	return -1;
    }
    
    @SuppressWarnings("unchecked")
	public XfglLfdj validateUser(String username, String password)
    {
    	String hql = "from XfglLfdj x where x.dsrxm=? and x.jgcxmm=?";
    	List<XfglLfdj> list = (List<XfglLfdj>)getHibernateTemplate().find(hql, new Object[]{username, password});
    	if(list!=null && !list.isEmpty())
    	{
    		return list.get(0);
    	}
    	return null;
    }
    
    public void saveNewDSR_JB(DsrJb dsrJb)
    {
    	getHibernateTemplate().save(dsrJb);
    }
    
    public void saveNewDSR_GR(DsrGr dsrGr)
    {
    	getHibernateTemplate().save(dsrGr);
    }
    
    public void saveNewDSR_DW(DsrDw dsrDw)
    {
    	getHibernateTemplate().save(dsrDw);
    }
    
    public void saveNewDSR_XP_JG(DsrXpJg dsrXpJg)
    {
    	getHibernateTemplate().save(dsrXpJg);
    }
    
    @SuppressWarnings("unchecked")
	public Integer getMaxLASQBH()
    {
    	String hql = "select max(l.lasqbh) from LaLasq l";
    	List<Integer> list = getHibernateTemplate().find(hql);
    	if(list!=null && list.size()>0 && list.get(0)!=null)
    	{
    		return list.get(0);
    	}
    	return new Integer(0);
    }
    
    @SuppressWarnings("unchecked")
	public Integer getMinAJXH()
    {
    	String hql = "select min(d.ajxh) from DsrJb d";
    	List<Integer> list = getHibernateTemplate().find(hql);
    	if(list!=null && !list.isEmpty() && list.get(0)!=null)
    	{
    		return list.get(0);
    	}
    	
    	return new Integer(-1);
    }
    
    @SuppressWarnings("unchecked")
	public Integer getMaxDSRBH()
    {
    	String hql = "select max(d.dsrbh) from DsrJb d";
    	List<Integer> list = getHibernateTemplate().find(hql);
    	if(list!=null && list.size()>0 && list.get(0)!=null)
    	{
    		return list.get(0);
    	}
    	
    	return new Integer(20);
    }
    
    public void saveNewLASQ(LaLasq lasq)
    {
    	getHibernateTemplate().save(lasq);
    }
	
	@SuppressWarnings("unchecked")
	public LaLasq getLASQByBHMM(String cxbh, String cxmm)
	{
		String hql = "from LaLasq l where l.cxbh=? and l.lacxmm=?";
		List<LaLasq> list = getHibernateTemplate().find(hql, new Object[]{cxbh, cxmm});
		if(list!=null && !list.isEmpty())
		{
			return list.get(0);
		}
		return null;
	}
    
	@SuppressWarnings("unchecked")
	public List<PubDmb> getDataDic(String hql, String comment)
	{
		return getHibernateTemplate().find(hql, new Object[]{comment});
	}
    
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
