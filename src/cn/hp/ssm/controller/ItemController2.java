package cn.hp.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import cn.hp.ssm.po.Items;
import cn.hp.ssm.po.ItemsCustom;
import cn.hp.ssm.service.ItemsService;

@org.springframework.stereotype.Controller
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

}
