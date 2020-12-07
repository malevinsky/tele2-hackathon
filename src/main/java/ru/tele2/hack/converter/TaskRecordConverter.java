package ru.tele2.hack.converter;

import ru.tele2.hack.domain.dto.CreateTaskRecordDTO;
import ru.tele2.hack.domain.dto.RecordDTO;
import ru.tele2.hack.domain.entity.Records;
import ru.tele2.hack.domain.entity.TaskRecordEntity;

public class TaskRecordConverter {

    public static TaskRecordEntity convert(CreateTaskRecordDTO dto) {
        TaskRecordEntity entity = new TaskRecordEntity();
        entity.setTaskId(dto.getTaskId());
        entity.setRecordId(dto.getRecordId());

        return entity;
    }

    public static RecordDTO convert(Records records) {
        return new RecordDTO(records.getId(), records.getText(), getFileName(records.getAudioFile()));
    }

    private static String getFileName(String path) {
        String[] arr = path.split("/");
        return arr[arr.length - 1];
    }
}
