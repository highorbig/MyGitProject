package cn.itcast.controller;

import cn.itcast.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("content")
public class ContentController {

    @Autowired
    private ContentService contentService;
}
