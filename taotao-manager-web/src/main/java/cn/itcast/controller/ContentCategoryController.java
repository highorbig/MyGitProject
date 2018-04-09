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

    // // 新增节点，发起Ajax的post请求
// url:/rest/content/category/add?parentId=${新增节点父id}&name=${节点的名称}
// $.post("/rest/content/category/add",{parentId:node.parentId,name:node.text},function(data){
    /**
     * 新增
     *
     * @param contentCategory
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ContentCategory saveContentCategory(ContentCategory contentCategory) {
        // 调用服务保存
        ContentCategory result = this.contentCategoryService.saveContentCategory(contentCategory);
        return result;
    }

// url： /rest/content/category/update?id=${节点的id}&name=${节点的名称}
// $.ajax({
// type: "POST",
// url: "/rest/content/category/update",
// data: {id:node.id,name:node.text},
// success: function(msg){

    /**
     * 更新
     *
     * @param contentCategory
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public String updateContentCategoryById(ContentCategory contentCategory) {
        // 调用服务更新
        this.contentCategoryService.updateByIdSelective(contentCategory);

        return "200";

    }

// url：/rest/content/category/delete?parentId=${节点的父id}&id=${节点的id}
// $.ajax({
// type: "POST",
// url: "/rest/content/category/delete",
    /**
     * 删除
     * @param parentId
     * @param id
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteContentCategoryById(Long parentId, Long id) {
        // 调用服务删除
        this.contentCategoryService.deleteContentCategoryById(parentId, id);
        return "200";

    }

}
