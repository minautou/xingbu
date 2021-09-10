package com.huimao.xingbu.dao;

import com.huimao.xingbu.model.Article;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    List<Article> getArticle();
}
