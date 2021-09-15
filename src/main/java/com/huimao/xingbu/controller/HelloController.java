/**
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huimao.xingbu.controller;

import com.huimao.xingbu.model.Article;
import com.huimao.xingbu.model.ArticleParam;
import com.huimao.xingbu.model.Result;
import com.huimao.xingbu.service.ArticleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * HelloController
 *
 * @ClassName: HelloController
 * @Description: HelloController
 * @author: yangwen
 * @since 2021-09-02
 **/
@Controller
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/")
    public String hello(Model model){
        ArticleParam articleParam = new ArticleParam();
        Result articleList = articleService.getArticle(articleParam);
        model.addAttribute("articleList", articleList);
        model.addAttribute("type", "main");
        return "index";
    }

    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest request){
        ArticleParam articleParam = new ArticleParam();
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        int start =  pageSize * pageNumber - pageSize;
        articleParam.setLimit(pageSize);
        articleParam.setStart(start);
        Result articleList = articleService.getArticle(articleParam);
        model.addAttribute("articleList", articleList);
        model.addAttribute("type", "main");
        return "index";
    }
}
