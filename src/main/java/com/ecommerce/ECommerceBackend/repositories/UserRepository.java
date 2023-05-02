package com.ecommerce.ECommerceBackend.repositories;

import com.ecommerce.ECommerceBackend.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
