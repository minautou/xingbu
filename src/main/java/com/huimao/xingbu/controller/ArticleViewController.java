/**
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huimao.xingbu.controller;

import com.huimao.xingbu.model.Article;
import com.huimao.xingbu.model.ArticleParam;
import com.huimao.xingbu.model.Result;
import com.huimao.xingbu.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * ArticleViewController
 *
 * @ClassName: ArticleViewController
 * @Description: ArticleViewController
 * @author: yangwen
 * @since 2021-09-17
 **/
@Controller
@RequestMapping(value = "/articleView")
public class ArticleViewController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/fortune-telling")
    public String fortuneTelling(Model model, HttpServletRequest request){
        ArticleParam articleParam = new ArticleParam();
        articleParam.setCategory("fortunetelling");
        if (request.getParameter("pageSize") != null) {
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            articleParam.setLimit(pageSize);
        }
        int pageNumber = 1;
        if (request.getParameter("pageNumber") != null) {
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
            int start =  articleParam.getLimit() * pageNumber - articleParam.getLimit();
            articleParam.setStart(start);
        }
        Result articleList = articleService.getArticle(articleParam);
        model.addAttribute("articleList", articleList);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("pageSize", articleParam.getLimit());
        return "menu/fortunetelling";
    }

    @RequestMapping(value = "/detail/{category}/{id}")
    public String fortuneTellingDetail(Model model, @PathVariable(value = "id") String id, @PathVariable(value = "category") String category){
        ArticleParam articleParam = new ArticleParam();
        articleParam.setCategory(category);
        articleParam.setId(id);
        Article article = articleService.getArticleDetail(articleParam);
        model.addAttribute("article", article);
        return "detail";
    }

    @RequestMapping("/fengshui")
    public String fengshui(Model model, HttpServletRequest request){
        ArticleParam articleParam = new ArticleParam();
        articleParam.setCategory("fengshui");
        if (request.getParameter("pageSize") != null) {
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            articleParam.setLimit(pageSize);
        }
        int pageNumber = 1;
        if (request.getParameter("pageNumber") != null) {
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
            int start =  articleParam.getLimit() * pageNumber - articleParam.getLimit();
            articleParam.setStart(start);
        }
        Result articleList = articleService.getArticle(articleParam);
        model.addAttribute("articleList", articleList);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("pageSize", articleParam.getLimit());
        return "menu/fengshui";
    }

    @RequestMapping("/culture")
    public String culture(Model model, HttpServletRequest request){
        ArticleParam articleParam = new ArticleParam();
        articleParam.setCategory("culture");
        if (request.getParameter("pageSize") != null) {
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            articleParam.setLimit(pageSize);
        }
        int pageNumber = 1;
        if (request.getParameter("pageNumber") != null) {
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
            int start =  articleParam.getLimit() * pageNumber - articleParam.getLimit();
            articleParam.setStart(start);
        }
        Result articleList = articleService.getArticle(articleParam);
        model.addAttribute("articleList", articleList);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("pageSize", articleParam.getLimit());
        return "menu/culture";
    }

    @RequestMapping("/column")
    public String column(Model model, HttpServletRequest request){
        ArticleParam articleParam = new ArticleParam();
        articleParam.setCategory("column");
        if (request.getParameter("pageSize") != null) {
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            articleParam.setLimit(pageSize);
        }
        int pageNumber = 1;
        if (request.getParameter("pageNumber") != null) {
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
            int start =  articleParam.getLimit() * pageNumber - articleParam.getLimit();
            articleParam.setStart(start);
        }
        Result articleList = articleService.getArticle(articleParam);
        model.addAttribute("articleList", articleList);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("pageSize", articleParam.getLimit());
        return "menu/column";
    }

    @RequestMapping("/classification")
    public String classification(Model model, HttpServletRequest request){
        ArticleParam articleParam = new ArticleParam();
        articleParam.setCategory("classification");
        if (request.getParameter("pageSize") != null) {
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            articleParam.setLimit(pageSize);
        }
        int pageNumber = 1;
        if (request.getParameter("pageNumber") != null) {
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
            int start =  articleParam.getLimit() * pageNumber - articleParam.getLimit();
            articleParam.setStart(start);
        }
        Result articleList = articleService.getArticle(articleParam);
        model.addAttribute("articleList", articleList);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("pageSize", articleParam.getLimit());
        return "menu/classification";
    }

}
