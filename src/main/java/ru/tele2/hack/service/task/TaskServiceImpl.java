package ru.tele2.hack.service.task;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.tele2.hack.client.recognition.TextRecognitionClient;
import ru.tele2.hack.converter.TaskConverter;
import ru.tele2.hack.domain.dto.CreateTaskDTO;
import ru.tele2.hack.domain.dto.TaskDTO;
import ru.tele2.hack.domain.entity.TaskEntity;
import ru.tele2.hack.repository.TaskEntityRepository;

@Service
public class TaskServiceImpl implements TaskService {

    private final static Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);

    private final TaskEntityRepository taskEntityRepository;
    private final TextRecognitionClient textRecognitionClient;

    public TaskServiceImpl(TaskEntityRepository taskEntityRepository,
            TextRecognitionClient textRecognitionClient) {
        this.taskEntityRepository = taskEntityRepository;
        this.textRecognitionClient = textRecognitionClient;
    }

    public TaskEntity createTask(CreateTaskDTO task) {
        TaskEntity taskEntity = TaskConverter.convert(task);

        String filePath = getAudionDescription(taskEntity.getDescription());
        taskEntity.setAudioPath(filePath);

        return taskEntityRepository.save(taskEntity);
    }

    public void updateTask(TaskDTO task) {

    }

    public List<TaskDTO> getTasks() {
        return taskEntityRepository.findAll().stream()
                .map(TaskConverter::convert)
                .collect(Collectors.toList());
    }

    public Optional<TaskEntity> getTask(Long id) {
        return taskEntityRepository.findById(id);
    }

    private String getAudionDescription(String text) {

        if (StringUtils.isBlank(text)) {
            return "";
        }

        try {
            log.info("Input text: {}", text);

            String escapedSpecChar = text;
            escapedSpecChar = escapedSpecChar.replace("&nbsp", " ");
            escapedSpecChar = escapedSpecChar.replace(";", " ");
            escapedSpecChar = escapedSpecChar.replace("&ltp", " ");
            escapedSpecChar = escapedSpecChar.replace("&ltp&gt", " ");
            escapedSpecChar = escapedSpecChar.replace("&quot", " ");
            escapedSpecChar = escapedSpecChar.replace("&ampnbsp", " ");
            escapedSpecChar = escapedSpecChar.replace("/p&gt", " ");
            escapedSpecChar = escapedSpecChar.replace("&ampnbsp&lt", " ");
            escapedSpecChar = escapedSpecChar.replace("&lt/p&gt", " ");
            escapedSpecChar = escapedSpecChar.replace("&gt", " ");
            escapedSpecChar = escapedSpecChar.replace("&nbsp;", " ");
            escapedSpecChar = escapedSpecChar.replace("<p>", " ");
            escapedSpecChar = escapedSpecChar.replace("</p>", " ");

            log.info("Output text: {}", escapedSpecChar);

            return textRecognitionClient.recognitionText(escapedSpecChar);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "";
    }
}
