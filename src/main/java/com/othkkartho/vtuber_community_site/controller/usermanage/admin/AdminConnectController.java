package com.othkkartho.vtuber_community_site.controller.usermanage.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminConnectController {
    @GetMapping(value = "/admin")
    public String home() {
        return "/admin/home";
    }

    @GetMapping(value = "/config")
    public String config() {
        return "/admin/config";
    }
}
