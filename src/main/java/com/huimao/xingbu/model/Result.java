/**
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huimao.xingbu.model;

/**
 * Result
 *
 * @ClassName: Result
 * @Description: Result
 * @author: yangwen
 * @since 2021-09-13
 **/
public class Result {
    private int code = 200;

    private String error = "";

    private long total = 0;

    private Object body;

    /**
     * return error and error info
     *
     * @param error b
     */
    public Result(String error) {
        this.code = 500;
        this.error = error;
    }

    /**
     * return success and date
     *
     * @param body b
     */
    public Result(Object body) {
        this.body = body;
    }

    /**
     * return success and date and total num
     *
     * @param total t
     * @param body b
     */
    public Result(long total, Object body) {
        this.total = total;
        this.body = body;
    }

    /**
     * Result
     */
    public Result() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}