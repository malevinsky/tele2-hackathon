package ru.tele2.hack.client.recognition.request;

public class TextRecognitionRequest {
    private String text;

    public TextRecognitionRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
