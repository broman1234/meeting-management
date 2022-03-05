package com.mman.meeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author 莫曼
 * @version 1.0
 */
@Controller
public class NotificationController {
    @GetMapping("/notifications")
    public String notifications() {
        return "notifications";
    }
}
