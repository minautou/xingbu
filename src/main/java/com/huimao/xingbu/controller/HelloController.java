/**
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huimao.xingbu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HelloController
 *
 * @ClassName: HelloController
 * @Description: HelloController
 * @author: yangwen
 * @since 2021-09-02
 **/
@Controller
public class HelloController {
    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("type", "main");
        return "index";
    }
}
