package cn.itcast.service.impl;

import cn.itcast.pojo.ContentCategory;
import cn.itcast.service.ContentCategoryService;
import cn.itcast.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentCategoryServiceImpl extends BaseServiceImpl<ContentCategory> implements ContentCategoryService {
    @Override
    public List<ContentCategory> queryContentCategoryByParntId(Long parentId) {
        //设置查询条件
        ContentCategory contentCategory=new ContentCategory();
        contentCategory.setParentId(parentId);

        //查询
        List<ContentCategory> list = super.queryListByWhere(contentCategory);

        return list;
    }
}
