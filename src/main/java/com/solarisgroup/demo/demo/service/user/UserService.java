package com.solarisgroup.demo.demo.service.user;

import com.solarisgroup.demo.demo.entity.User;
import com.solarisgroup.demo.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto createUser(UserDto request) {
        var user = userRepository.save(User.builder()
                .uid(UUID.randomUUID().toString())
                .name(request.name())
                .login(request.login())
                .password(request.password())
                .build());
        return map(user);
    }

    private UserDto map(User user) {
        return new UserDto(user.getUid(), user.getName(), user.getLogin(), null);
    }
}
