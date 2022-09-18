package com.seung.uijibakyak.service;

import com.seung.uijibakyak.dto.ScheduleDto;
import com.seung.uijibakyak.entity.ScheduleEntity;
import com.seung.uijibakyak.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public void createSchedule(ScheduleDto scheduleDto) {

        //일정에 기한 정하기
        String mySchedule = scheduleDto.getSchedule();
        if (mySchedule.contains("   ")) {

            String[] splitSchedule = mySchedule.split("   ");
            String schedule = splitSchedule[0];
            String deadline = splitSchedule[1];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");

            //월일만 입력한 경우
            if(deadline.length() == 4) {
                DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yy");
                String year = LocalDate.now().format(yearFormatter);
                String totalDeadline = year + deadline;
                System.out.println(totalDeadline);
                LocalDate date = LocalDate.parse(totalDeadline, formatter);

                ScheduleEntity scheduleEntity =
                        ScheduleEntity.builder()
                                .schedule(schedule)
                                .userId(scheduleDto.getUserId())
                                .inputTime(LocalDate.now())
                                .deadline(date)
                                .build();

                scheduleRepository.save(scheduleEntity);

                return;

            }

            //년월일을 입력한 경우
            else if (deadline.length() == 6) {

                LocalDate date = LocalDate.parse(deadline, formatter);

                ScheduleEntity scheduleEntity =
                        ScheduleEntity.builder()
                                .schedule(schedule)
                                .userId(scheduleDto.getUserId())
                                .inputTime(LocalDate.now())
                                .deadline(date)
                                .build();

                scheduleRepository.save(scheduleEntity);

                return;

            }

        }

        ScheduleEntity scheduleEntity =
                ScheduleEntity.builder()
                        .schedule(scheduleDto.getSchedule())
                        .userId(scheduleDto.getUserId())
                        .inputTime(LocalDate.now())
                        .deadline(scheduleDto.getDeadline())
                        .build();

        scheduleRepository.save(scheduleEntity);
    }

    public List<ScheduleEntity> loadSchedule() {

        return scheduleRepository.findAllByDeadlineIsNotNull(Sort.by(Sort.Direction.ASC,"deadline"));

    }

    public List<ScheduleEntity> loadScheduleNoDate() {

        return scheduleRepository.findAllByDeadlineIsNull(Sort.by(Sort.Direction.ASC,"inputTime"));

    }

    public void completeSchedule(Long id) {

    }

}
