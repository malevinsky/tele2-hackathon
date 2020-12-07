package ru.tele2.hack.controller;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.tele2.hack.domain.entity.TariffComponent;
import ru.tele2.hack.domain.enums.TariffComponentType;
import ru.tele2.hack.domain.model.request.ComponentRequest;
import ru.tele2.hack.service.tariff.component.TariffComponentService;

@RestController
public class TariffComponentMatcherController {

    private final static Logger log = LoggerFactory.getLogger(TariffComponentService.class);

    private final ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

    private TariffComponentService tariffComponentService;

    public TariffComponentMatcherController(TariffComponentService tariffComponentService) {
        this.tariffComponentService = tariffComponentService;
    }

    @RequestMapping(path = "/match", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity match(@RequestBody ComponentRequest request)
            throws JsonProcessingException, UnsupportedEncodingException
    {
        log.info("Inbound text {} and type {}", request.getText(), request.getType());

        Optional<TariffComponent> componentOptional =
                tariffComponentService.find(request.getText(), TariffComponentType.valueOf(request.getType()));

        if (componentOptional.isPresent()) {
            TariffComponent component = componentOptional.get();

            log.info("Found component {}", component.getTitle());

            return ResponseEntity.status(HttpStatus.OK).body(toJsonString(component).getBytes("UTF-8"));
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(("Tariff component not found text=" + request.getText() + " type=" + request.getType()).getBytes("UTF-8"));
    }

    private String toJsonString(TariffComponent component) throws JsonProcessingException {
        return objectWriter.writeValueAsString(component);
    }
}
