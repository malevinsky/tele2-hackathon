-- auto-generated definition

--changeset msa:add_tariff_table
CREATE TABLE IF NOT EXISTS tariff
(
    id               BIGSERIAL                NOT NULL PRIMARY KEY,
    title            VARCHAR(500)             NOT NULL,
    description      TEXT
);