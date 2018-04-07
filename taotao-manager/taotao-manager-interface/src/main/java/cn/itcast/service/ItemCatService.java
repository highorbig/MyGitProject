package cn.itcast.service;

import cn.itcast.pojo.ItemCat;

import java.util.List;

public interface ItemCatService {

    /**
     * 分页查询商品类目
     * @param page
     * @param rows
     * @return
     */
    List<ItemCat> queryByPage(Integer page , Integer rows);

    /**
     * 根据parentId查找商品类目
     * @param parentId
     * @return
     */
    List<ItemCat> queryItemCatByParentId(Long parentId);
}
