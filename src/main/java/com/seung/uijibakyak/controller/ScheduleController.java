package com.seung.uijibakyak.controller;


import com.seung.uijibakyak.dto.ScheduleDto;
import com.seung.uijibakyak.entity.ScheduleEntity;
import com.seung.uijibakyak.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedule")
    public void createSchedule(ScheduleDto scheduleDto, HttpServletResponse response) throws IOException {
        scheduleService.createSchedule(scheduleDto);

        response.sendRedirect("/");
    }

    @GetMapping("/schedule")
    public void loadSchedule(Model model) {
        List<ScheduleEntity> scheduleList = scheduleService.loadSchedule();
        List<ScheduleEntity> scheduleListNoDate = scheduleService.loadScheduleNoDate();
        model.addAttribute("scheduleList", scheduleList);
        model.addAttribute("scheduleListNoDate", scheduleListNoDate);
    }


}
