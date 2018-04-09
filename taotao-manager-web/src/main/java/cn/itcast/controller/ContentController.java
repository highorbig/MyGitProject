package cn.itcast.controller;

import cn.itcast.common.TaoResult;
import cn.itcast.pojo.Content;
import cn.itcast.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    // type: "POST",
// url: "/rest/content",
// data: $("#contentAddForm").serialize(),
    /**
     * 新增
     *
     * @param content
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void SaveContent(Content content) {
        // 调用服务保存
        this.contentService.save(content);

    }
    //method:'get',pageSize:20,url:'/rest/content',queryParams:{categoryId:0}
    /**
     * 分页查询内容
     *
     * @param page
     * @param rows
     * @param categoryId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public TaoResult<Content> queryContentByPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                 @RequestParam(value = "rows", defaultValue = "20") Integer rows, Long categoryId) {

        TaoResult<Content> taoUIResult = this.contentService.queryContentByPage(page, rows, categoryId);

        return taoUIResult;

    }

}
