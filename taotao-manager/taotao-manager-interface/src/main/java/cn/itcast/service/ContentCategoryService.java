package cn.itcast.service;

import cn.itcast.base.BaseService;
import cn.itcast.pojo.ContentCategory;

import java.util.List;

public interface ContentCategoryService extends BaseService<ContentCategory>{
    /**
     * 根据parentId查找内容分类
     * @param parentId
     * @return
     */
    List<ContentCategory> queryContentCategoryByParntId(Long parentId);
}
