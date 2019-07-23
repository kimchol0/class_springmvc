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
			
			//锟斤拷锟斤拷ModelAndView
			ModelAndView modelAndView =  new ModelAndView();
			//锟洁当 锟斤拷request锟斤拷setAttribut锟斤拷锟斤拷jsp页锟斤拷锟斤拷通锟斤拷itemsList取锟斤拷锟斤拷
			modelAndView.addObject("itemsList", itemsList);
				
			//指锟斤拷锟斤拷图
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
		
		//上传图片
		if(items_pic !=null && orgFileName !=null && orgFileName.length()>0) {
			//物理文件路径
			String pic_path="D:\\workspace\\SpringToolSuite4\\class_springmvc\\tempupload\\";
			//新文件名
			String newFileName = UUID.randomUUID().toString()+orgFileName.substring(orgFileName.lastIndexOf("."));
			//新图片文件
			File newFile = new File(pic_path+newFileName);
			//写入磁盘文件
			items_pic.transferTo(newFile);
			//set方法添加属性
			itemsCustom.setPic(newFileName);
		
		}
		
		itemsService.updateItems(id, itemsCustom);
		return "redirect:/items/queryItems.action";
		
	}
	
}
