package cn.itcast.controller;

import cn.itcast.pojo.ContentCategory;
import cn.itcast.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("content/category")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    /**
     * 根据parentId查询内容分类
     * @param parentId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ContentCategory> queryContentCategoryByParentId(@RequestParam(value = "id",defaultValue = "0")Long parentId){
        List<ContentCategory>list=this.contentCategoryService.queryContentCategoryByParntId(parentId);
        return list;
    }
}
