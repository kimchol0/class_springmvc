package cn.hp.ssm.mapper;

import java.util.List;

import cn.hp.ssm.po.ItemsCustom;
import cn.hp.ssm.po.ItemsQueryVo;

public interface ItemsMapperCustom {
	
	//��Ʒ��ѯ�б�
		public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;

	
		
}
