package nju.software.xfgl.service;

import java.util.List;

import nju.software.xfgl.model.DsrDw;
import nju.software.xfgl.model.DsrGr;
import nju.software.xfgl.model.DsrJb;
import nju.software.xfgl.model.DsrXpJg;
import nju.software.xfgl.model.LaLasq;
import nju.software.xfgl.model.PubDmb;
import nju.software.xfgl.model.XfglLfdj;


public interface XFGLService
{
    Integer getMaxLFBH();
	
	void addXFGL_LFDJ(XfglLfdj xfgl_lfdj);
    
    int stateSearch(String lfcxbh, String password);
    
    XfglLfdj validateUser(String username, String password);
    
    void saveNewDSR_JB(DsrJb dsrJb);
    
    void saveNewDSR_GR(DsrGr dsrGr);
    
    void saveNewDSR_DW(DsrDw dsrDw);
    
    void saveNewDSR_XP_JG(DsrXpJg dsrXpJg);
    
    Integer getMaxLASQBH();
    
    Integer getMinAJXH();
    
    Integer getMaxDSRBH();
    
    void saveNewLASQ(LaLasq lasq);
    
    LaLasq getLASQByBHMM(String cxbh, String cxmm);
    
    List<PubDmb> getDataDic(String hql, String comment);
}
