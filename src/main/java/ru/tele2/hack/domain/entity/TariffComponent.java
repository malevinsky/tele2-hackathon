package ru.tele2.hack.domain.entity;

import java.util.Objects;

import ru.tele2.hack.domain.enums.TariffComponentType;

public class TariffComponent {

    private Long id;
    private String title;
    private Integer price;
    private String description;
    private TariffComponentType tariffComponentType;
    private String keyWords;

    public TariffComponent(Long id, String title, Integer price, String description,
            TariffComponentType tariffComponentType, String keyWords)
    {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.tariffComponentType = tariffComponentType;
        this.keyWords = keyWords;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TariffComponentType getTariffComponentType() {
        return tariffComponentType;
    }

    public void setTariffComponentType(TariffComponentType tariffComponentType) {
        this.tariffComponentType = tariffComponentType;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TariffComponent that = (TariffComponent) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(price, that.price) &&
                Objects.equals(description, that.description) &&
                tariffComponentType == that.tariffComponentType &&
                Objects.equals(keyWords, that.keyWords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, description, tariffComponentType, keyWords);
    }

    @Override
    public String toString() {
        return "TariffComponent{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", tariffComponentType=" + tariffComponentType +
                ", keyWords='" + keyWords + '\'' +
                '}';
    }
}
