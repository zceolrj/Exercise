package nju.software.xfgl.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import nju.software.xfgl.common.SessionKey;
import nju.software.xfgl.model.XfglLfdj;
import nju.software.xfgl.service.XFGLService;
import nju.software.xfgl.util.XFGLUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lfdj")
public class XFGL_LFDJController
{	
	@Autowired
    HttpServletRequest request;
	
	@Autowired
	private XFGLService xfgl_spgkService;
	
	@RequestMapping("/index")
	public ModelAndView showLFDJ()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("lfdj");
		return mav;
	}
	
	@RequestMapping("/lfztcx")
	public ModelAndView showLFZTCX()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("lfztcx");
		return mav;
	}
	
    @RequestMapping("/add")
	public ModelAndView saveXinFang(
    		@RequestParam("username")String username,
    		@RequestParam("password")String password,
    		@RequestParam("confirmPassword")String confirmPassword,
    		@RequestParam("address")String address,
    		@RequestParam("postcode")String postcode,
    		@RequestParam("tel")String tel,
    		@RequestParam("mobilephone")String mobilephone,
    		@RequestParam("relationship")String relationship,
    		@RequestParam("email")String email,
    		@RequestParam("identity")String identity,
    		@RequestParam("case")String caseInfo,
    		@RequestParam("otherInfo")String otherInfo,
    		@RequestParam(value="feedback", required = false)String feedback,
    		@RequestParam("kaptcha")String kaptcha)
    {
    	ModelAndView mav = new ModelAndView();
    	
    	XfglLfdj xfgl = new XfglLfdj();
    	int bh = xfgl_spgkService.getMaxLFBH() + 1;
    	xfgl.setBh(bh);//编号
    	xfgl.setDjr(null);//登记人
    	Date currentDate = new Date();
    	xfgl.setDjrq(currentDate);//登记时间
    	xfgl.setZylfzxm(null);//主要来访者姓名
    	xfgl.setSfzhm(null);//身份证号码
    	xfgl.setXb(null);//性别
    	xfgl.setNl(null);//年龄
    	xfgl.setDh(tel);//电话
    	xfgl.setZz(address);//住址
    	xfgl.setGzdw(null);//工作单位
    	xfgl.setDsrxm(username);//当事人姓名
    	xfgl.setYdsrgx(relationship);//与当事人关系
    	
    	//生成查询编号
    	String lfcxbh = XFGLUtil.generateLFCXBH(bh);
    	xfgl.setLfcxbh(lfcxbh);
    	xfgl.setJgcxmm(password);//结果查询密码
    	xfgl.setYzbm(postcode);//邮政编码
    	xfgl.setMobilephone(mobilephone);//手机号码
    	xfgl.setDzyj(email);//电子邮件
    	xfgl.setXfrsf(identity);//信访人身份
    	xfgl.setFyqk(caseInfo);//反映情况
    	xfgl.setQtnr(otherInfo);//其它内容
    	
    	String attSessionKey = SessionKey.getSessionKey("LFDJ", SessionKey.UPLOAD_SUFFIX);
    	String attachmentPath = (String) request.getSession().getAttribute(attSessionKey);
    	xfgl.setAttachment(attachmentPath); //设置附件
    	xfgl.setFkfs(feedback);//反馈方式
    	xfgl.setSymbol(0);
    	
    	xfgl_spgkService.addXFGL_LFDJ(xfgl);
    	
    	mav.setViewName("lfdjjg");
    	mav.addObject("xfgl", xfgl);
    	mav.addObject("lfcxbh", lfcxbh);
    	
    	return mav;
    }
    
    @RequestMapping("/stateSearch")
    public ModelAndView stateSearch(
    		@RequestParam("lfcxbh")String lfcxbh,
    		@RequestParam("password")String password)
    {
    	int symbol = xfgl_spgkService.stateSearch(lfcxbh, password);
    	//int symbol = -1; //added for test
    	String state = "";
    	if(symbol==-1)
    	{
    		state = "";
    	}
    	else if(symbol==0)
    	{
    		state = "您的信访记录还没有被处理，请耐心等待";
    	}
    	else if(symbol==1)
    	{
    		state = "您的信访记录正在处理中，请耐心等待结果";
    	}
    	else if(symbol==2)
    	{
    		state = "您的信访记录已经被处理了";
    	}
    	
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("lfztcxjg");
    	mav.addObject("state", state);
    	mav.addObject("symbol", symbol);
    	return mav;
    }
    
}
