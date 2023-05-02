package com.ecommerce.ECommerceBackend.repositories.admin;

import com.ecommerce.ECommerceBackend.entities.admin.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
}
