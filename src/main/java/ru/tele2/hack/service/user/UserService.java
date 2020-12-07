package ru.tele2.hack.service.user;

import ru.tele2.hack.domain.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity createUser(UserEntity userEntity);

    UserEntity getUserById(long userId);

    List<UserEntity> getAllUsers();
}
