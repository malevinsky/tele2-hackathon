package ru.tele2.hack.service.user;

import org.springframework.stereotype.Service;
import ru.tele2.hack.domain.entity.UserEntity;
import ru.tele2.hack.repository.UserEntityRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserEntityRepository userEntityRepository;

    public UserServiceImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userEntityRepository.save(userEntity);
    }

    @Override
    public UserEntity getUserById(long userId) {
        return userEntityRepository.getOne(userId);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userEntityRepository.findAll();
    }
}
