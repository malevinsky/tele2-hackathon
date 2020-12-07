package ru.tele2.hack.service.tariff.component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.tele2.hack.domain.entity.TariffComponent;
import ru.tele2.hack.domain.enums.TariffComponentType;
import ru.tele2.hack.repository.JdbcTariffComponentRepository;

@Service
public class TariffComponentService {

    private final static Logger log = LoggerFactory.getLogger(TariffComponentService.class);

    private JdbcTariffComponentRepository repository;

    public TariffComponentService(JdbcTariffComponentRepository repository) {
        this.repository = repository;
    }

    public Optional<TariffComponent> find(String rawStr, TariffComponentType type) {

        if (StringUtils.isBlank(rawStr)) {
            log.error("Input string empty or null {}", rawStr);
            return Optional.empty();
        }

        List<TariffComponent> components = repository.findTariffComponentsByType(type);

        return components.stream()
                .map(component -> {
                    long count = findMatching(component, rawStr).size();

                    return new MutablePair<TariffComponent, Long>(component, count);
                })
                .filter(pair -> pair.right > 0)
                .max(Comparator.comparingLong(MutablePair::getRight))
                .map(MutablePair::getLeft);
    }

    private List<String> findMatching(TariffComponent component, String rawStr) {
        return getKeyWords(component.getKeyWords()).stream()
                .filter(word -> existsInText(word, rawStr.toLowerCase()))
                .collect(Collectors.toList());
    }

    private List<String> getKeyWords(String keyWords) {
        String kWords = Optional.ofNullable(keyWords)
                .orElse("");

        return Arrays.asList(kWords.split(","));
    }

    private boolean existsInText(String word, String text) {
        return text.contains(word);
    }

}
