package com.mdh.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author mdh-home
 * @date 2026/4/15 - 22:14
 **/
@RestController
public class ChatController {

    // 对话模型，调用阿里云百炼平台
    @Resource
    private ChatModel chatModel;

    @GetMapping(value = "/hello/word")
    public String hello() {
        return "helloWord";
    }

    @GetMapping(value = "/hello/doChat")
    public String doChat(@RequestParam(name = "msg", defaultValue = "你是谁") String msg) {
       return chatModel.call(msg);
    }

    @GetMapping(value = "/hello/doStreamChat")
    public Flux<String> doStreamChat(@RequestParam(name = "msg", defaultValue = "你是谁") String msg) {
        return chatModel.stream(msg);
    }
}
