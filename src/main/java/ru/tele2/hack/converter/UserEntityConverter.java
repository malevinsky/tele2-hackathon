package ru.tele2.hack.converter;

import ru.tele2.hack.domain.entity.UserEntity;
import ru.tele2.hack.domain.model.request.RegistrationRequest;

public class UserEntityConverter {

    public static UserEntity convert(RegistrationRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(request.getUserName());
        userEntity.setFirstName(request.getFirstName());
        userEntity.setLastName(request.getLastName());
        userEntity.setPassword(request.getPassword());
        userEntity.setEmail(request.getEmail());

        return userEntity;
    }
}
