package com.ecommerce.ECommerceBackend.controller.admin;

import com.ecommerce.ECommerceBackend.entities.admin.Role;
import com.ecommerce.ECommerceBackend.entities.admin.User;
import com.ecommerce.ECommerceBackend.services.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listAll(Model model) {
        List<User> listUsers = userService.listAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

    @GetMapping("/users/new")
    public String newUser(Model model) {
        List<Role> listRoles = userService.listRoles();
        User user = new User();
        user.setEnabled(true);
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes redirectAttributes){
        System.out.println(user);
        userService.save(user);
        redirectAttributes.addFlashAttribute("message","The user has been saved successfully.");
        return "redirect:/users";
    }
}
