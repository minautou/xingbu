/**
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huimao.xingbu.model;

import java.sql.Timestamp;

/**
 * Article
 *
 * @ClassName: Article
 * @Description: Article
 * @author: yangwen
 * @since 2021-09-10
 **/
public class Article implements Comparable<Article> {
    private String id;
    private String title;
    private String content;
    private String detail;
    private String status;
    private String author;
    private String category;
    private int praiseNum;
    private int negativeNum;
    private int collectNum;
    private int commentNum;
    private int shareNum;
    private Timestamp createTime;
    private Timestamp modifyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(int praiseNum) {
        this.praiseNum = praiseNum;
    }

    public int getNegativeNum() {
        return negativeNum;
    }

    public void setNegativeNum(int negativeNum) {
        this.negativeNum = negativeNum;
    }

    public int getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(int collectNum) {
        this.collectNum = collectNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getShareNum() {
        return shareNum;
    }

    public void setShareNum(int shareNum) {
        this.shareNum = shareNum;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public int compareTo(Article article) {
        if (this.praiseNum > article.getPraiseNum()) {
            return 1;
        } else {
            return 0;
        }
    }
}
