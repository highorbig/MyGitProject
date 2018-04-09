package cn.itcast.service;

import cn.itcast.base.BaseService;
import cn.itcast.pojo.Item;

public interface ItemService extends BaseService<Item> {

    /**
     * 保存商品
     * @param item
     */
    public void saveItem(Item item , String desc);

    /**
     * 分类查询商品
     * @param page
     * @param rows
     * @return
     */
    cn.itcast.common.TaoResult<Item> queryItemList(Integer page, Integer rows);
}
