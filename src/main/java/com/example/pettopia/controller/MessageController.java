package com.example.pettopia.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
public class MessageController {
@GetMapping("message/messageList")
public String getMethodName() {
    return "message/messageList";
}

}