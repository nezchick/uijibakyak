package com.seung.uijibakyak.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "complete_schedule")
public class CompleteScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //일정
    private String schedule;
    //아이디
    private String userId;
    //완료 시점
    private LocalDate completeDate;
}
