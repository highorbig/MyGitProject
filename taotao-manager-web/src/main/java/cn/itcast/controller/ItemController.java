package cn.itcast.controller;

import cn.itcast.common.TaoResult;
import cn.itcast.pojo.Item;
import cn.itcast.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void saveItem(Item item , String desc){
        this.itemService.saveItem(item,desc);
    }

    // url:'/rest/item',method:'get',pageSize:30,
    /**
     * 分页查询item
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public TaoResult<Item> queryItemList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                         @RequestParam(value = "rows", defaultValue = "30") Integer rows) {

        TaoResult<Item> easyUIResult = this.itemService.queryItemList(page, rows);

        return easyUIResult;
    }

}
