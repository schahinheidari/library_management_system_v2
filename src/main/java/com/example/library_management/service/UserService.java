package com.example.library_management.service;

import com.example.library_management.model.dto.user.UserDto;
import com.example.library_management.model.dto.user.UserSaveDto;
import com.example.library_management.model.dto.user.UserUpdateDto;

import java.util.List;

public interface UserService {
    String addUser(UserSaveDto userSaveDto);
    List<UserDto> getAllUsers();
    String updateUser(UserUpdateDto userUpdateDto);
    String deleteUser(int id);
}
