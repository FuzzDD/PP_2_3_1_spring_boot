package org.example.PP_2_3_1_spring_boot.controller;

import org.example.PP_2_3_1_spring_boot.model.User;
import org.example.PP_2_3_1_spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    private final UserService userDao;
    @Autowired
    public UserController(UserService userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userDao.getUsersList());
        return "index";
    }
    @GetMapping("addUser")
    public String addUser(Model model) {
    model.addAttribute("user", new User());
    return "new";
    }
   @PostMapping("create")
    public  String create(@ModelAttribute("user") User user) {
    userDao.add(user);
    return "redirect:/";
    }
    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
    model.addAttribute("user", userDao.show(id));
    return "edit";
    }
    @PatchMapping("edit/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userDao.update(id, user);
        return "redirect:/";
    }
    @PostMapping("del")
    public String delete(@RequestParam("id") int id) {
       userDao.delete(id);
        return "redirect:/";
    }
}
