package ru.tele2.hack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tele2.hack.domain.entity.TariffComponentEntity;

public interface TariffComponentEntityRepository extends JpaRepository<TariffComponentEntity, Long> {
}
