/**
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huimao.xingbu.controller;

import com.alibaba.fastjson.JSONObject;
import com.huimao.xingbu.model.Article;
import com.huimao.xingbu.service.ArticleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * ArticleController
 *
 * @ClassName: ArticleController
 * @Description: ArticleController
 * @author: yangwen
 * @since 2021-09-10
 **/
@RestController
@RequestMapping(value = "/article")
@Api(tags = "Article", description = "网络")
public class ArticleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/getArticle")
    @ApiOperation(value = "操作接口")
    public List<Article> getArticle(HttpServletRequest request) {
        LOGGER.info("getArticle:{}", request.getMethod());
        List<Article> vms = articleService.getArticle();
        return vms;
    }
}
