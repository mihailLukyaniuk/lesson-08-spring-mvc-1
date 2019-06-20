package com.godeltech.mastery.springmvc.controller;


import com.godeltech.mastery.springmvc.entity.User;
import com.godeltech.mastery.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setProductService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", userService.getUsers());
        System.out.println("Returning users:");
        return "users";
    }

    @RequestMapping(value = "user/editUser/{id}", method = RequestMethod.POST)
    public String showEditedUser(@PathVariable Integer id, User user, Model model) {
        userService.editUser(user, id);
        model.addAttribute("user", userService.getUser(id));
        System.out.println("Editing user and going to his page:");
        return "redirect:/user/{id}";
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        System.out.println("Show one user:");
        return "userShow";
    }

    @RequestMapping(value = "user/edit/{id}", method = RequestMethod.GET)
    public String getEditUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        System.out.println("Going to the users edit page:");
        return "userEdit";
    }

    @RequestMapping(value = "user/new", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        System.out.println("Going to the users create page:");
        return "userCreate";
    }

    @RequestMapping("user/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.removeUser(id);
        System.out.println("Deleting user and going to the users list:");
        return "redirect:/users/";
    }

    @RequestMapping(value = "users", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Name wrong");
            return "redirect:/user/new";
        }
        userService.addUser(user);
        System.out.println("Adding new User:");
        return "redirect:/user/" + user.getId();
    }
}