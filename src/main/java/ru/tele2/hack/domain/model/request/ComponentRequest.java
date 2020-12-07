package ru.tele2.hack.domain.model.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ComponentRequest {
    private String text;
    private  String type;

    @JsonCreator
    public ComponentRequest(@JsonProperty("text") String text,
            @JsonProperty("type") String type) {
        this.text = text;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
