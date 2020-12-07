package ru.tele2.hack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tele2.hack.domain.entity.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserName(String userName);

    UserEntity findByUserNameAndPassword(String userName, String password);
}
