package com.example.library_management.controller;

import com.example.library_management.model.dto.user.UserDto;
import com.example.library_management.model.dto.user.UserSaveDto;
import com.example.library_management.model.dto.user.UserUpdateDto;
import com.example.library_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserSaveDto userSaveDto){
        String userName = userService.addUser(userSaveDto);
        return "Added Successfully";
    }

    @GetMapping(path = "/getAllUser")
    public List<UserDto> getAllUsers(){
        List<UserDto> userList = userService.getAllUsers();
        return userList;
    }

    @PutMapping(path = "/update")
    public String updateUser(@RequestBody UserUpdateDto userUpdateDto){
        String userName = userService.updateUser(userUpdateDto);
        return "Updated Successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") int id){
        String userName = userService.deleteUser(id);
        return "Deleted Successfully";
    }
}
