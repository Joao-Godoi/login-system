package dev.joaogodoi.loginsystem.service;

import dev.joaogodoi.loginsystem.dto.UserDto;
import dev.joaogodoi.loginsystem.dto.UserRegistrationDto;

import java.util.List;

public interface UserService {
    void registerNewUser(UserRegistrationDto dto);
    List<UserDto> getAllUsers();
}