package cn.itcast.controller;

import cn.itcast.pojo.ItemCat;
import cn.itcast.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;


    @RequestMapping("query/{pages}")
    @ResponseBody
    public List<ItemCat> queryItemCatByPage(@PathVariable("pages") Integer page, @RequestParam("rows")Integer rows){
        List<ItemCat> list = this.itemCatService.queryItemCatByPage(page, rows);
        return list;
    }
}
