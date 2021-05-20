package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.Hello;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;
@CrossOrigin("*")
@Controller
public class GreetingController {
        @MessageMapping("/hello")
        @SendTo("/topic/hi")
    public User greeting(Hello message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new User("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}