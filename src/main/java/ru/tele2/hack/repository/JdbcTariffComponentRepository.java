package ru.tele2.hack.repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.tele2.hack.domain.entity.TariffComponent;
import ru.tele2.hack.domain.enums.TariffComponentType;

@Repository
public class JdbcTariffComponentRepository {

    private final String FIND_TARIFF_COMPONENT_BY_TYPE = "SELECT id, title, price, description, component_type, key_words"
            + " FROM tariff_component WHERE component_type = :type";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public JdbcTariffComponentRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TariffComponent> findTariffComponentsByType(TariffComponentType type) {
        return jdbcTemplate.query(
                FIND_TARIFF_COMPONENT_BY_TYPE,
                new MapSqlParameterSource()
                        .addValue("type", type.name()),
                (rs, rowNum) -> new TariffComponent(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        TariffComponentType.valueOf(rs.getString("component_type")),
                        rs.getString("key_words")
                )
        );
    }
}
