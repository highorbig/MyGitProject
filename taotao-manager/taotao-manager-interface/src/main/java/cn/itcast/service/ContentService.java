package cn.itcast.service;

import cn.itcast.base.BaseService;
import cn.itcast.common.TaoResult;
import cn.itcast.pojo.Content;

public interface ContentService extends BaseService<Content> {
    /**
     * 分页查询
     * @param page
     * @param rows
     * @param categoryId
     * @return
     */
    TaoResult<Content> queryContentByPage(Integer page, Integer rows, Long categoryId);
}
