package cn.itcast.service.impl;

import cn.itcast.pojo.Item;
import cn.itcast.pojo.ItemDesc;
import cn.itcast.service.ItemDescService;
import cn.itcast.service.ItemService;
import cn.itcast.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends BaseServiceImpl<Item> implements ItemService {


    @Autowired
    private ItemDescService itemDescService;

    @Override
    public void saveItem(Item item,String desc) {
        //保存商品
        item.setStatus(1);
        super.save(item);

        //保存商品描述
        ItemDesc itemDesc=new ItemDesc();
        itemDesc.setItemId(item.getId());
        itemDesc.setItemDesc(desc);

        this.itemDescService.save(itemDesc);
    }
}
