package nju.software.xfgl.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import nju.software.xfgl.common.SessionKey;
import nju.software.xfgl.util.FileUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController
{
	private static String[] attachmentFormat = { 
		"rar", "zip", "7z", "doc", "docx", "pdf", 
		"jpg", "jpeg", "png", "bmp", "gif", 
		"tiff", "svg", "psd", "dxf", "ai", "ufo"};
	
	private static String FILE_SPLIT_CHAR = "\\";
	
	private static String XFGL_ATTACHMENT = "/XFGL_Attachment";
	
	private static String LA_MATERIAL = "/LA_Material";

	private static List<String> formatList = Arrays.asList(attachmentFormat);
	
	@Autowired
	private HttpServletRequest request;

	@RequestMapping("/attachment")
	@ResponseBody
	public void uploadAttachment(
			@RequestParam("attachment")CommonsMultipartFile file, 
			HttpServletResponse response) 
	{
		String originalFilename = file.getOriginalFilename();//从原始文件得到原始文件名
		String uploadResult;//上传的结果  success or fail
		String serverSavePath = request.getSession().getServletContext().getRealPath(XFGL_ATTACHMENT);
		File dir = new File(serverSavePath);
		if(!dir.exists())
		{
			dir.mkdirs();
		}
		
		String serverWholePath = "";//  服务端存储路径+文件名
		String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
		
		if (formatList.contains(suffix)) //判断上传的附件格式是否正确
		{
			serverWholePath = serverSavePath + FILE_SPLIT_CHAR 
					+ FileUtil.generateFileName(originalFilename);
			System.out.println(serverWholePath);
			File uploadedFile = new File(serverWholePath);
			try 
			{
				if(!uploadedFile.exists())
				{
					uploadedFile.createNewFile();
				}
				file.getFileItem().write(uploadedFile);
				uploadResult = "success";
				
			} 
			catch (Exception e) 
			{
				uploadResult = "fail";
				e.printStackTrace();
			}
		} 
		else 
		{
			uploadResult = "errorFormat";
		}
		
		String sessionKey = SessionKey.getSessionKey(SessionKey.LFDJ_MODULE, SessionKey.UPLOAD_SUFFIX);
		request.getSession().setAttribute(sessionKey, serverWholePath);
		
		JSONObject object = new JSONObject();
		object.put("uploadResult", uploadResult);
		object.put("originalFilename", originalFilename);
    	
		try 
		{
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(JSONObject.fromObject(object).toString());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
    
	@RequestMapping(value="/deleteFile", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteFile(
    		@RequestParam("src")String src)
    {
    	String sessionKey = SessionKey.getSessionKey(src, SessionKey.UPLOAD_SUFFIX);
    	String serverWholePath = (String)request.getSession().getAttribute(sessionKey);
		File uploadedFile = new File(serverWholePath);
    	uploadedFile.delete();
    	
    	request.getSession().removeAttribute(sessionKey);
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	return map;
    }
	
	@RequestMapping("/material")
	@ResponseBody
	public void uploadMaterial(
			@RequestParam("material")CommonsMultipartFile file, HttpServletResponse response) 
	{
		String originalFilename = file.getOriginalFilename();//从原始文件得到原始文件名
		String uploadResult;//上传的结果  success or fail
		String serverSavePath = request.getSession().getServletContext().getRealPath(LA_MATERIAL);
		//判断文件夹是否存在，弱不存在则新建之
		File dir = new File(serverSavePath);
		if(!dir.exists())
		{
			dir.mkdirs();
		}
		String serverWholePath = "";//  服务端存储路径+文件名
		String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
		
		if (formatList.contains(suffix)) //判断上传的附件格式是否正确
		{
			serverWholePath = serverSavePath + FILE_SPLIT_CHAR 
					+ FileUtil.generateFileName(originalFilename);
			File uploadedFile = new File(serverWholePath);
			try 
			{
				if(!uploadedFile.exists())
				{
					uploadedFile.createNewFile();
				}
				file.getFileItem().write(uploadedFile);
				uploadResult = "success";
				
			} 
			catch (Exception e) 
			{
				uploadResult = "fail";
				e.printStackTrace();
			}
		} 
		else 
		{
			uploadResult = "errorFormat";
		}
		String sessionKey = SessionKey.getSessionKey(SessionKey.LA_MODULE, SessionKey.UPLOAD_SUFFIX);
		request.getSession().setAttribute(sessionKey, serverWholePath);
		
		JSONObject object = new JSONObject();
		object.put("uploadResult", uploadResult);
		object.put("originalFilename", originalFilename);
    	
		try 
		{
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(JSONObject.fromObject(object).toString());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
