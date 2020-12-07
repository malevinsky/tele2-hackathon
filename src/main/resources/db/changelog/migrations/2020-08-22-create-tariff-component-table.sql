-- auto-generated definition

--changeset msa:create_tariff_component_table
CREATE TABLE IF NOT EXISTS tariff_component
(
    id               BIGSERIAL                NOT NULL PRIMARY KEY,
    title            VARCHAR(500)             NOT NULL,
    price            INT                      NOT NULL,
    description      TEXT,
    component_type   VARCHAR(256)             NOT NULL,
    key_words        VARCHAR(500)             NOT NULL
);