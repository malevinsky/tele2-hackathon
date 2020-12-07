package ru.tele2.hack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tele2.hack.domain.entity.TaskRecordEntity;

public interface TaskRecordEntityRepository extends JpaRepository<TaskRecordEntity, Long> {
}
