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


		//�洢ͼƬ������·��
		String pic_path = "D:\\workspace\\SpringToolSuite4\\class_springmvc\\tempupload\\";
		
		String originalFilename = upfile.getOriginalFilename();
		
		//�µ�ͼƬ����
		String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
		//��ͼƬ
		File newFile = new File(pic_path+newFileName);
		
		try {
			upfile.transferTo(newFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// ���ϴ����ļ��ƶ���ָ���ļ���
		
		String file_url = "/pic/" + newFileName;
		
		return file_url;// ����ͼƬurl��ajax
	}
 
}

