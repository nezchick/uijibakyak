package com.seung.uijibakyak.controller;

import com.seung.uijibakyak.dto.ScheduleDto;
import com.seung.uijibakyak.entity.ScheduleEntity;
import com.seung.uijibakyak.repository.ScheduleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class MainController {

    private final ScheduleRepository scheduleRepository;

    public MainController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @PostMapping("/create/schedule")
    public String createSchedule(ScheduleDto scheduleDto) {

        ScheduleEntity scheduleEntity =
                ScheduleEntity.builder()
                .schedule(scheduleDto.getSchedule())
                        .userId(scheduleDto.getUserId())
                        .inputTime(LocalDate.now())
                        .deadline(scheduleDto.getDeadline())
                        .build();

        scheduleRepository.save(scheduleEntity);


        return "index";
    }





}
