package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.model.RegistrationRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<UserDto> userDtos = userService.getAllUsers();
        model.addAttribute("title", "Users");
        model.addAttribute("users", userDtos);
        model.addAttribute("user", new RegistrationRequest());
        return "users/index";
    }

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users/create")
    public String displayCreateUserForm(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute("user", new RegistrationRequest());
        return "users/create";
    }

    @PostMapping("/users/create")
    public String processCreateUserForm(@ModelAttribute("user") RegistrationRequest newUser, Model model) {
        userService.registerUser(newUser);
        return "redirect:/users";
    }

    @GetMapping("/users/delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Users");
        model.addAttribute("users", userService.getAllUsers());
        return "users/delete";
    }

    @PostMapping("/users/delete")
    public String processDeleteEventsForm(@RequestParam(name = "userIds", required = false) int[] userIds) {
        if (userIds != null) {
            for (int id : userIds) {
                User user = userService.findUserById(id);
                userService.deleteUser(user);
            }
        }
        return "redirect:/users";
    }


    @GetMapping("/users/edit/{id}")
    public String displayEditUserForm(@PathVariable Integer id, Model model) {
        UserDto userDto = userService.getUserById(id);
        model.addAttribute("title", "Edit User");
        model.addAttribute("user", userDto);
        return "users/edit_user";
    }


    @PostMapping("/users/update")
    public String processEditUserForm(@ModelAttribute("user") UserDto updatedUserDto) {
        User updatedUser = userService.mapDtoToUser(updatedUserDto);
        userService.updateUser(updatedUser);
        return "redirect:/users";
    }

}
