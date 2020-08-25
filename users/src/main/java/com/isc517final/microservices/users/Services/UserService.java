package com.isc517final.microservices.users.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.transaction.Transactional;
import com.isc517final.microservices.users.Models.User;
import com.isc517final.microservices.users.Repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> all() {
        return repository.findAll();
    }

    public User findById(long id) {
        return repository.findById(id);
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public List<User> getAllEmployees() {
        return repository.getAllEmployees();
    }

    public List<User> getAllClients() {
        return repository.getAllClients();
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email) == 1;
    }

    @Transactional
    public User createOrUpdate(User user) {
        return repository.save(user);
    }

    @Transactional
    public void delete(long id) {
        repository.deleteById(id);
    }
}