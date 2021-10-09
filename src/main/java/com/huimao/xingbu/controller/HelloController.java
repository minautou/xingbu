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

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        model.addAttribute("category", "index");
        model.addAttribute("pageNumber", articleParam.getStart() / articleParam.getLimit() + 1);
        model.addAttribute("pageSize", articleParam.getLimit());

        articleService.AddNormalArticle(model);
        return "index";
    }

    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest request){
        ArticleParam articleParam = new ArticleParam();
        int pageSize = 5;
        if (request.getParameter("pageSize") != null) {
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
            articleParam.setLimit(pageSize);
        }
        int pageNumber = 1;
        if (request.getParameter("pageNumber") != null) {
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
            int start =  articleParam.getLimit() * pageNumber - articleParam.getLimit();
            articleParam.setStart(start);
        }

        articleService.AddNormalArticle(model);
        Result articleList = articleService.getArticle(articleParam);
        model.addAttribute("articleList", articleList);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("pageSize", pageSize);
        return "index";
    }
}
