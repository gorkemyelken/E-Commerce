package com.ecommerce.ECommerceBackend.repositories;

import com.ecommerce.ECommerceBackend.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
}
