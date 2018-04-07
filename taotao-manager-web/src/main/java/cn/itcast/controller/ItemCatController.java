package cn.itcast.controller;

import cn.itcast.pojo.ItemCat;
import cn.itcast.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;


    @RequestMapping("query/{pages}")
    @ResponseBody
    public List<ItemCat> queryItemCatByPage(@PathVariable("pages") Integer page, @RequestParam(value="rows",defaultValue = "5")Integer rows){
        List<ItemCat> list = this.itemCatService.queryByPage(page, rows);
        return list;
    }

    /**
     * 根据parentId查找类目
     * @param parentId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ItemCat> queryItemCatByParentId(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        List<ItemCat> list=itemCatService.queryItemCatByParentId(parentId);
        return list;
    }
}
