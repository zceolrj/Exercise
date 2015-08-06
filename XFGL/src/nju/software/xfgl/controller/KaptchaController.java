package nju.software.xfgl.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Producer;

@Controller
@RequestMapping("/kaptcha")
public class KaptchaController
{
    @Autowired
    private Producer captchaProducer = null;
    
    @RequestMapping("/image")
    public ModelAndView getKaptchaImage(
    		@RequestParam("src")String src,
    		HttpServletRequest request, HttpServletResponse response) throws IOException
    {
    	HttpSession session = request.getSession();
		response.setDateHeader("Expires", 0);  
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
        response.setHeader("Pragma", "no-cache");  
        response.setContentType("image/jpeg");
		
		String capText = captchaProducer.createText();
		session.setAttribute(getSessionKey(src), capText);
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		try
		{
			out.flush();
		}
		finally
		{
			out.close();
		}
		
		return null;
    }
    
    @RequestMapping(value="/verify", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> verifyCode(@RequestParam("code")String code,
    		@RequestParam("src")String src,
    		HttpServletRequest request)
    {
    	HttpSession session = request.getSession();
    	String validCode = (String)session.getAttribute(getSessionKey(src));
    	Map<String, Object> modelMap = new HashMap<String, Object>();
    	if(code.equals(validCode))
    	{
    		modelMap.put("result", "right");
    	}
    	else
    	{
    		modelMap.put("result", "wrong");
    	}
    	return modelMap;
    }
    
    private String getSessionKey(String str)
    {
    	return str+"Kaptcha";
    }
}
