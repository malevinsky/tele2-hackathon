package ru.tele2.hack.domain.model.request;

import ru.tele2.hack.domain.dto.RecordDTO;
import ru.tele2.hack.domain.dto.TaskDTO;

public class CreateTaskRequest {
    private TaskDTO task;
    private RecordDTO records;

    public CreateTaskRequest(TaskDTO task, RecordDTO records) {
        this.task = task;
        this.records = records;
    }

    public TaskDTO getTask() {
        return task;
    }

    public RecordDTO getRecords() {
        return records;
    }
}
