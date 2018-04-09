package cn.itcast.service.impl;

import cn.itcast.common.TaoResult;
import cn.itcast.pojo.Content;
import cn.itcast.service.ContentService;
import cn.itcast.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl extends BaseServiceImpl<Content> implements ContentService {
    @Override
    public TaoResult<Content> queryContentByPage(Integer page, Integer rows, Long categoryId) {
            Content param = new Content();
            param.setCategoryId(categoryId);

            TaoResult<Content> taoUIResult = super.queryListByPage(param, page, rows, "updated DESC");

            return taoUIResult;
        }

    }

