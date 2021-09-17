/**
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huimao.xingbu.model;

/**
 * ArticleParam
 *
 * @ClassName: ArticleParam
 * @Description: ArticleParam
 * @author: yangwen
 * @since 2021-09-13
 **/
public class ArticleParam {
    private int start = 0;
    private int limit = 5;

    private String category;
    private String id;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
