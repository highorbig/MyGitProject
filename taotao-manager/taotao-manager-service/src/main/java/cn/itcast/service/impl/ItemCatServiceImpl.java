package cn.itcast.service.impl;

import cn.itcast.mapper.ItemCatMapper;
import cn.itcast.pojo.ItemCat;
import cn.itcast.service.ItemCatService;
import cn.itcast.service.base.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemCatServiceImpl extends BaseServiceImpl<ItemCat> implements ItemCatService {


//    @Autowired
//    private ItemCatMapper itemCatMapper;
//    @Override
//    public List<ItemCat> queryItemCatByPage(Integer page, Integer rows) {
//        //设置分页条件
//        PageHelper.startPage(page,rows);
//        //查询
//        List<ItemCat> itemCatList = this.itemCatMapper.select(null);
//
//        return itemCatList;
//    }
}
