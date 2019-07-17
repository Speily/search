package com.speily.server.search.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: SPL
 * @Date: 2019-07-17 14:29
 * @Description: -IK 分词器 控制器
 */
@RestController
@RequestMapping("/ik")
public class IkController {


    /**
     * 词典热更新 - 新增 words
     *
     * @param word 热词
     * @return
     */
    @RequestMapping("/addWords")
    public Object addHotWords(String word){
        return null;
    }

    /**
     * 词典热更新 - 停用指定 words
     *
     * @param word 热词
     * @return
     */
    @RequestMapping("/addWords")
    public Object stopHotWords(String word){
        return null;
    }

}
