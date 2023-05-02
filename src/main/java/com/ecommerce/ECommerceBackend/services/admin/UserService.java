package com.ecommerce.ECommerceBackend.services.admin;

import com.ecommerce.ECommerceBackend.entities.admin.User;
import com.ecommerce.ECommerceBackend.repositories.admin.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAll() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

}
