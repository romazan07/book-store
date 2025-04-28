package com.bookstore.service.impl;

import com.bookstore.dto.user.UserRegistrationRequestDto;
import com.bookstore.dto.user.UserResponseDto;
import com.bookstore.exception.RegistrationException;
import com.bookstore.mapper.UserMapper;
import com.bookstore.model.User;
import com.bookstore.repository.UserRepository;
import com.bookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto userRegistrationRequestDto)
            throws RegistrationException {
        String email = userRegistrationRequestDto.getEmail();
        if (userRepository.existsByEmail(email)) {
            throw new RegistrationException("The user with the email: " + email
                    + " already exists");
        }
        User userMapperModel = userMapper.toModel(userRegistrationRequestDto);
        return userMapper.toDto(userRepository.save(userMapperModel));
    }
}
