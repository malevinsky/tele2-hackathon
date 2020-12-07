package ru.tele2.hack.service.record;

import java.util.List;

import ru.tele2.hack.domain.dto.CreateTaskRecordDTO;
import ru.tele2.hack.domain.dto.RecordDTO;

public interface TaskRecordService {

    void createTaskRecord(CreateTaskRecordDTO dto);

    void createTaskRecords(List<CreateTaskRecordDTO> dtos);

    List<RecordDTO> getRecordsByTaskId(Long taskId);
}
