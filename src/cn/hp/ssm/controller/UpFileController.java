package cn.hp.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UpFileController {
 
	@RequestMapping(value = "/upfile.action")
	@ResponseBody
	public String upfile(MultipartFile upfile, HttpSession session) {


		//存储图片的物理路径
		String pic_path = "D:\\workspace\\SpringToolSuite4\\class_springmvc\\tempupload\\";
		
		String originalFilename = upfile.getOriginalFilename();
		
		//新的图片名称
		String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
		//新图片
		File newFile = new File(pic_path+newFileName);
		
		try {
			upfile.transferTo(newFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 将上传的文件移动到指定文件夹
		
		String file_url = "/pic/" + newFileName;
		
		return file_url;// 返回图片url给ajax
	}
 
}

