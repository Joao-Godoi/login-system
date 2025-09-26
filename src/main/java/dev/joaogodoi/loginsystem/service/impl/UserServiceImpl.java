package dev.joaogodoi.loginsystem.service.impl;

import dev.joaogodoi.loginsystem.dto.UserDto;
import dev.joaogodoi.loginsystem.dto.UserRegistrationDto;
import dev.joaogodoi.loginsystem.model.Role;
import dev.joaogodoi.loginsystem.model.User;
import dev.joaogodoi.loginsystem.repository.UserRepository;
import dev.joaogodoi.loginsystem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void registerNewUser(UserRegistrationDto dto) {
        if (userRepository.existsByUsername(dto.getUsername())) throw new IllegalArgumentException("username taken");
        if (userRepository.existsByEmail(dto.getEmail())) throw new IllegalArgumentException("email taken");
        if (!dto.getPassword().equals(dto.getConfirmPassword()))
            throw new IllegalArgumentException("password mismatch");
        User u = new User();
        u.setUsername(dto.getUsername());
        u.setEmail(dto.getEmail());
        u.setPassword(passwordEncoder.encode(dto.getPassword()));
        u.setRoles(Set.of(Role.ROLE_USER));
        userRepository.save(u);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getRoles()))
                .toList();
    }
}