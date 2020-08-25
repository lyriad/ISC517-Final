package com.isc517final.microservices.users.Repositories;

import java.util.List;
import com.isc517final.microservices.users.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    User findByName(String name);

    User findByEmail(String email);

    User findByRole(String role);

    @Query("SELECT u FROM User u WHERE u.role = 'EMPLOYEE' OR u.role = 'ADMIN'")
    List<User> getAllEmployees();

    @Query("SELECT u FROM User u WHERE u.role = 'CLIENT'")
    List<User> getAllClients();

    @Query("SELECT COUNT(1) FROM User u WHERE u.email = :email")
    int existsByEmail(@Param("email") String email);
}