package cn.hp.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.hp.ssm.mapper.ItemsMapper;
import cn.hp.ssm.mapper.ItemsMapperCustom;
import cn.hp.ssm.po.Items;
import cn.hp.ssm.po.ItemsCustom;
import cn.hp.ssm.po.ItemsQueryVo;
import cn.hp.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsmapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		
		return itemsMapperCustom.findItemsList(itemsQueryVo);
		
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		
		Items items = itemsmapper.selectByPrimaryKey(id);
		
		ItemsCustom itemsCustom = new ItemsCustom();
		
		BeanUtils.copyProperties(items , itemsCustom);
		
		return itemsCustom;
		
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		
		itemsCustom.setId(id);
		
		itemsmapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
		
		
	}

}
