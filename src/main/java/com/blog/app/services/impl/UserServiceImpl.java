package com.blog.app.services.impl;

import com.blog.app.entities.User;
import com.blog.app.exceptions.ResourceNotFoundException;
import com.blog.app.payloads.UserDto;
import com.blog.app.repositories.UserRepository;
import com.blog.app.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDto createUser(UserDto userDto) {

        User user = dtoToEntity(userDto);

        User savedUser = userRepository.save(user);

        UserDto savedUserDto = entityToDto(savedUser);

        return savedUserDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {


        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));


        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updatedUser = userRepository.save(user);

        UserDto userDto1 = entityToDto(updatedUser);

        return userDto1;

    }


    @Override
    public UserDto getUserById(Integer userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

        UserDto userDto = entityToDto(user);

        return userDto;
    }


    @Override
    public List<UserDto> getAllUsers() {

        List<User> userList = userRepository.findAll();

        List<UserDto> collect = userList.stream().map(user -> entityToDto(user)).collect(Collectors.toList());

        return collect;
    }

    @Override
    public void deleteUserById(Integer userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

        userRepository.delete(user);

    }

    private User dtoToEntity(UserDto userDto) {

        User user = modelMapper.map(userDto, User.class);

        return user;

    }

    private UserDto entityToDto(User user) {

        UserDto userDto = modelMapper.map(user, UserDto.class);

        return userDto;

    }

}
