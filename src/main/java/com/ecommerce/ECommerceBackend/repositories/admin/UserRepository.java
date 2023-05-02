package com.ecommerce.ECommerceBackend.repositories.admin;

import com.ecommerce.ECommerceBackend.entities.admin.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
