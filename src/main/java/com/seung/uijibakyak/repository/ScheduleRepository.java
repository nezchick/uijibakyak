package com.seung.uijibakyak.repository;

import com.seung.uijibakyak.entity.ScheduleEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
    List<ScheduleEntity> findAllByDeadlineIsNull(Sort sort);
    List<ScheduleEntity> findAllByDeadlineIsNotNull(Sort sort);
}
