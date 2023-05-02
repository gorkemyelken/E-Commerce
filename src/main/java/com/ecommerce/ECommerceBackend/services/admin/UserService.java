package com.ecommerce.ECommerceBackend.services.admin;

import com.ecommerce.ECommerceBackend.entities.admin.Role;
import com.ecommerce.ECommerceBackend.entities.admin.User;
import com.ecommerce.ECommerceBackend.repositories.admin.RoleRepository;
import com.ecommerce.ECommerceBackend.repositories.admin.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }

    public List<Role> listRoles(){
        return (List<Role>) roleRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
