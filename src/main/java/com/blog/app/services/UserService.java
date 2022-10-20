package com.blog.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.app.payloads.UserDto;

@Service
public interface UserService {

    public UserDto createUser(UserDto userDto);

    public UserDto updateUser(UserDto userDto, Integer userId);

    public UserDto getUserById(Integer userId);

    public List<UserDto> getAllUsers();

    public void deleteUserById(Integer userId);


}
