package com.othkkartho.vtuber_community_site.controller.usermanage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String home() {
        return "/home";
    }
}
