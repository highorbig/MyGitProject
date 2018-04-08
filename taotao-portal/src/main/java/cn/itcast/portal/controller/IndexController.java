package cn.itcast.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("index")
public class IndexController {
    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String toIndex(){
        return "index";
    }
}
