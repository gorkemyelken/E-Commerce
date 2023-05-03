package com.ecommerce.ECommerceBackend.repositories;

import com.ecommerce.ECommerceBackend.entities.admin.Role;
import com.ecommerce.ECommerceBackend.entities.admin.User;
import com.ecommerce.ECommerceBackend.repositories.admin.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUserWithOneRole(){
        Role roleAdmin = entityManager.find(Role.class , 1);
        User user1 = new User("gorkemyelken@gmail.com", "12345", "Görkem", "Yelken");
        user1.addRole(roleAdmin);

        User savedUser = repository.save(user1);

        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateUserWithTwoRole(){
        User user2 = new User("user2@gmail.com", "12345", "UserFirstName2", "UserLastName2");
        Role roleEditor = new Role(3);
        Role roleAssistant = new Role(5);

        user2.addRole(roleEditor);
        user2.addRole(roleAssistant);

        User savedUser = repository.save(user2);

        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAllUsers() {
        Iterable<User> listUsers = repository.findAll();
        listUsers.forEach(System.out::println);
    }

    @Test
    public void testGetUserById() {
        User userById = repository.findById(1).get();
        System.out.println(userById);
        assertThat(userById).isNotNull();
    }

    @Test
    public void testUpdateUserDetails() {
        User userUpdateUserDetails = repository.findById(1).get();
        userUpdateUserDetails.setEnabled(true);
        userUpdateUserDetails.setEmail("gorkemyelkenn@gmail.com");

        repository.save(userUpdateUserDetails);
    }

    @Test
    public void testUpdateUserRoles() {
        User userUpdateUserRoles = repository.findById(2).get();
        Role roleEditor = new Role(3);
        Role roleSalesperson = new Role(2);

        userUpdateUserRoles.getRoles().remove(roleEditor);
        userUpdateUserRoles.addRole(roleSalesperson);

        repository.save(userUpdateUserRoles);
    }

    @Test
    public void testDeleteUser() {
        Integer deleteUser = 2;
        repository.deleteById(deleteUser);

    }

    @Test
    public void testGetUserByEmail(){
        String email = "gorkemyelkenn@gmail.com";
        User user = repository.getUserByEmail(email);

        assertThat(user).isNotNull();
    }
}