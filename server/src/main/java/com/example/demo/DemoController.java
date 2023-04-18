package com.example.demo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class DemoController {

    @MessageMapping("/message")
    @SendTo("/topic/callback")
    public Message stompMessage(Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Message("Returned by server, " + HtmlUtils.htmlEscape(message.getContent()) + " 💙");
    }
}