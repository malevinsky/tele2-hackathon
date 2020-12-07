package ru.tele2.hack.domain.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ru.tele2.hack.domain.enums.TariffComponentType;

@Entity
@Table(name = "tariff_component")
public class TariffComponentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "component_type", nullable = false, updatable = false)
    private TariffComponentType tariffComponentType;

    @Column(name = "key_words")
    private String keyWords;

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
        TariffComponentEntity that = (TariffComponentEntity) o;
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
}
