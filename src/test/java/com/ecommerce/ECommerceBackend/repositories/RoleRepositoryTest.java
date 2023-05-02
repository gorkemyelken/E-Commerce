package com.ecommerce.ECommerceBackend.repositories;

import com.ecommerce.ECommerceBackend.entities.admin.Role;
import com.ecommerce.ECommerceBackend.repositories.admin.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class RoleRepositoryTest {
    @Autowired
    private RoleRepository repository;

    @Test
    public void testCreateFirstRole(){
        Role roleAdmin = new Role("Admin", "Manage everything");
        Role savedRole = repository.save(roleAdmin);
        assertThat(savedRole.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateRestRoles() {
        Role roleSalesperson = new Role("Salesperson", "Manage product price, "
                + "customers, shipping, orders and sales report");

        Role roleEditor = new Role("Editor", "Manage categories, brands, "
                + "products, articles and menus");

        Role roleShipper = new Role("Shipper", "View products, view orders "
                + "and update order status");

        Role roleAssistant = new Role("Assistant", "Manage questions and reviews");

        repository.saveAll(List.of(roleSalesperson, roleEditor, roleShipper, roleAssistant));
    }
}