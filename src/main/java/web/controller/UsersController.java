package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(ModelMap modelMap) {
        modelMap.addAttribute("listUsers", userService.getAllUsers());
        return "/index";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model modelMap) {
        User user = new User();
        modelMap.addAttribute("user", user);
        return "new_users";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUsers(user);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") Long id, Model modelMap) {
        User user = userService.getUserById(id);
        modelMap.addAttribute("user", user);
        return "update_user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable (value = "id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

}