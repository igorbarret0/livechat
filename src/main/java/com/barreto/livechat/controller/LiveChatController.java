package com.barreto.livechat.controller;

import com.barreto.livechat.model.ChatMessage;
import com.barreto.livechat.model.ChatOutput;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LiveChatController {

    @MessageMapping("/new-message")
    @SendTo("/topic/livechat")
    public ChatOutput newMessage(ChatMessage chatMessage) {

        return new ChatOutput(
                HtmlUtils.htmlEscape(chatMessage.user() + ": " + chatMessage.message()
        ));
    }

}
