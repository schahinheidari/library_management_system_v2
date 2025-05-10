package com.example.library_management.service;

import com.example.library_management.model.dto.user.UserDto;
import com.example.library_management.model.dto.user.UserSaveDto;
import com.example.library_management.model.dto.user.UserUpdateDto;
import com.example.library_management.model.entity.User;
import com.example.library_management.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService {
    
    @Autowired
    private UserDao userDao;
    @Override
    public String addUser(UserSaveDto userSaveDto) {
        User user = new User(
                userSaveDto.getName(),
                userSaveDto.getEmail()
        );
        userDao.save(user);
        return user.getName();
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> getUsers = userDao.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : getUsers) {
            UserDto userDto = new UserDto(
                    user.getId(),
                    user.getName(),
                    user.getEmail()
            );
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    @Override
    public String updateUser(UserUpdateDto userUpdateDto) {
        if(userDao.existsById(userUpdateDto.getId())){
            User user = userDao.findById(userUpdateDto.getId()).get();
            user.setName(userUpdateDto.getName());
            user.setEmail(userUpdateDto.getEmail());
            userDao.save(user);
            return user.getName();
        }
        else {
            System.out.println("User does not exist");
        }
        return null;
    }

    @Override
    public String deleteUser(int id) {
        if (userDao.existsById(id)) {
            userDao.deleteById(id);
        } else {
            System.out.println("User ID does not exist");
        }
        return null;
    }
}
