/**
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huimao.xingbu.service;

import com.huimao.xingbu.controller.ArticleController;
import com.huimao.xingbu.dao.ArticleMapper;
import com.huimao.xingbu.model.Article;
import com.huimao.xingbu.model.ArticleParam;
import com.huimao.xingbu.model.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * ArticleService
 *
 * @ClassName: ArticleService
 * @Description: ArticleService
 * @author: yangwen
 * @since 2021-09-10
 **/
@Service
public class ArticleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);

    @Resource
    private ArticleMapper articleMapper;

    public Result getArticle(ArticleParam articleParam) {
        List<Object> objects = articleMapper.getArticle(articleParam);
        List<Article> articleList = (List<Article>) objects.get(0);
        long total = ((List<Long>) objects.get(1)).get(0);
        Result result = new Result(total, articleList);
        return result;
    }

    public void AddNormalArticle(Model model) {
        ArticleParam articleParamSingle = new ArticleParam();
        Result articleListOrderPraise = getArticleOrderPraise(articleParamSingle);
        List<Article> articlesOrderPraise = (List<Article>) articleListOrderPraise.getBody();
        List<Article> articlesHot = articlesOrderPraise.stream().sorted(Comparator.comparing(Article::getPraiseNum)).collect(
            Collectors.toList());
        model.addAttribute("articleHotList", articlesHot.subList(0, 8));
        Result articleListSingle = getArticle(articleParamSingle);
        List<Article> articles = (List<Article>) articleListSingle.getBody();
        model.addAttribute("articleNewList", articles.subList(0, 4));
    }

    public Result getArticleOrderPraise(ArticleParam articleParam) {
        List<Object> objects = articleMapper.getArticleOrderPraise(articleParam);
        List<Article> articleList = (List<Article>) objects.get(0);
        long total = ((List<Long>) objects.get(1)).get(0);
        Result result = new Result(total, articleList);
        return result;
    }

    public Article getArticleDetail(ArticleParam articleParam) {
        Article article = articleMapper.getArticleDetail(articleParam);
        return article;
    }

    public void insertArticle(Article article) {
        articleMapper.insertArticle(article);
    }

}
