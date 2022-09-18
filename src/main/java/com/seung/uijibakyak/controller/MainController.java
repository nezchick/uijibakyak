package com.seung.uijibakyak.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ScheduleController scheduleController;

    @GetMapping("/")
    public String index(Model model) {

        scheduleController.loadSchedule(model);

        return "index";
    }

    @GetMapping("/member/register")
    public String registerPage() {

        return "member/register";
    }

    @GetMapping("/member/login")
    public String loginPage() {

        return "member/login";
    }

}
