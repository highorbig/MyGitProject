package cn.itcast.service;

import cn.itcast.base.BaseService;
import cn.itcast.pojo.Item;

public interface ItemService extends BaseService<Item> {

    /**
     * 保存商品
     * @param item
     */
    public void saveItem(Item item , String desc);
}
