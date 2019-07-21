package cn.hp.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.hp.ssm.mapper.ItemsMapperCustom;
import cn.hp.ssm.po.ItemsCustom;
import cn.hp.ssm.po.ItemsQueryVo;
import cn.hp.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		
		return itemsMapperCustom.findItemsList(itemsQueryVo);
		
	}

}
