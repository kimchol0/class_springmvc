package cn.hp.ssm.service;

import java.util.List;

import cn.hp.ssm.po.ItemsCustom;
import cn.hp.ssm.po.ItemsQueryVo;

public interface ItemsService {
	
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	//根据id查询商品信息
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	//修改商品信息
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
	
}
