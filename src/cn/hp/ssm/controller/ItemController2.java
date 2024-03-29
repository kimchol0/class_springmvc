package cn.hp.ssm.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.hp.ssm.po.ItemsCustom;
import cn.hp.ssm.service.ItemsService;

@org.springframework.stereotype.Controller
@RequestMapping("/items")
public class ItemController2 {
	
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/queryItems")
	public ModelAndView querytItems() throws Exception {
		
			List<ItemsCustom> itemsList = itemsService.findItemsList(null);
			
			//����ModelAndView
			ModelAndView modelAndView =  new ModelAndView();
			//�൱ ��request��setAttribut����jspҳ����ͨ��itemsListȡ����
			modelAndView.addObject("itemsList", itemsList);
				
			//ָ����ͼ
			modelAndView.setViewName("items/itemsList");

			return modelAndView;
		
	}
	
	
	@RequestMapping(value = "/editItems",method = {RequestMethod.GET,RequestMethod.POST})
	public String editItems(Model model,Integer id)throws Exception{
		
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		
		model.addAttribute("itemsCustom",itemsCustom);
		
		return "items/editItems";
		
	}
	
	@RequestMapping("/editItemsSubmit")
	public String editItemSubmit(Integer id,ItemsCustom itemsCustom,MultipartFile items_pic) throws Exception{
		
		String orgFileName = items_pic.getOriginalFilename();
		System.out.println("====orgFilename"+orgFileName);
		
		//�ϴ�ͼƬ
		if(items_pic !=null && orgFileName !=null && orgFileName.length()>0) {
			//�����ļ�·��
			String pic_path="D:\\workspace\\SpringToolSuite4\\class_springmvc\\tempupload\\";
			//���ļ���
			String newFileName = UUID.randomUUID().toString()+orgFileName.substring(orgFileName.lastIndexOf("."));
			//��ͼƬ�ļ�
			File newFile = new File(pic_path+newFileName);
			//д������ļ�
			items_pic.transferTo(newFile);
			//set������������
			itemsCustom.setPic(newFileName);
		
		}
		
		itemsService.updateItems(id, itemsCustom);
		return "redirect:/items/queryItems.action";
		
	}
	
}
