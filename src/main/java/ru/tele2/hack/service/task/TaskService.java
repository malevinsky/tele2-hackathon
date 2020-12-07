package ru.tele2.hack.service.task;

import java.util.List;
import java.util.Optional;

import ru.tele2.hack.domain.dto.CreateTaskDTO;
import ru.tele2.hack.domain.dto.TaskDTO;
import ru.tele2.hack.domain.entity.TaskEntity;

public interface TaskService {

  TaskEntity createTask(CreateTaskDTO task);

  void updateTask(TaskDTO task);

  List<TaskDTO> getTasks();

  Optional<TaskEntity> getTask(Long id);
}