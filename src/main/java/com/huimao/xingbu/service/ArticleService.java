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

import java.util.List;

import javax.annotation.Resource;

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

}
