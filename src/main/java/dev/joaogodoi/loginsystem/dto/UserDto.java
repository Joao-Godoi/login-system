package dev.joaogodoi.loginsystem.dto;

import dev.joaogodoi.loginsystem.model.Role;

import java.util.Set;

public record UserDto(String id, String username, String email, Set<Role> roles) {
}