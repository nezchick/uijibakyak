package com.seung.uijibakyak.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ScheduleDto {
    private String schedule;
    //아이디
    private String userId;
    //입력시간
    private LocalDate inputTime;
    //일정기한
    private LocalDate deadline;

}
