/**
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huimao.xingbu.controller;

import com.huimao.xingbu.model.Article;
import com.huimao.xingbu.model.ArticleParam;
import com.huimao.xingbu.model.Result;
import com.huimao.xingbu.service.ArticleService;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

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

    @RequestMapping("/contribution")
    public String contribution(Model model, HttpServletRequest request){
        ArticleParam articleParam = new ArticleParam();
        articleParam.setCategory("contribution");
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
        return "menu/contribution";
    }

    @RequestMapping(value = "/addArticle")
    public String addArticle(Model model, HttpServletRequest request) {
        String content = request.getParameter("content");
        String txtTitle = request.getParameter("txtTitle");
        String articlecategory = request.getParameter("articlecategory");
        Article article = new Article();
        article.setId(UUID.randomUUID().toString());
        article.setTitle(txtTitle);
        String contentText = content.replaceAll("</?[^>]+>", ""); //剔出<html>的标签
        contentText = contentText.replaceAll("<a>\\s*|\t|\r|\n</a>", "");
        contentText = contentText.replaceAll("&nbsp;", "");
        article.setContent(contentText);
        article.setDetail(content);
        article.setStatus("using");
        article.setAuthor("user0924");
        article.setCategory(articlecategory);
        article.setCreateTime(new Timestamp(new Date().getTime()));
        article.setModifyTime(new Timestamp(new Date().getTime()));
        articleService.insertArticle(article);

        ArticleParam articleParam = new ArticleParam();
        Result articleList = articleService.getArticle(articleParam);
        model.addAttribute("articleList", articleList);
        model.addAttribute("pageNumber", 1);
        model.addAttribute("pageSize", articleParam.getLimit());
        return "index";
    }

}
