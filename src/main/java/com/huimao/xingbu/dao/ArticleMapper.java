package com.huimao.xingbu.dao;

import com.huimao.xingbu.model.Article;
import com.huimao.xingbu.model.ArticleParam;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    List<Object> getArticle(ArticleParam articleParam);

    Article getArticleDetail(ArticleParam articleParam);

    void insertArticle(Article article);

}
