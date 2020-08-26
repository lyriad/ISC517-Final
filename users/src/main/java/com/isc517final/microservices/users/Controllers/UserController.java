package com.isc517final.microservices.users.Controllers;

import java.util.List;
import java.util.UUID;
import com.isc517final.microservices.users.Services.UserService;
import com.isc517final.microservices.users.Utils.JWTUtils;
import com.isc517final.microservices.users.Utils.Parser;
import com.isc517final.microservices.users.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private Parser parser;

    @Autowired
    private JWTUtils jwtUtils;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {

        if (!service.existsByEmail(email)) {
            System.out.println(String.format("Attempt login but user not found with email: %s", email));
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already taken!");
        }
                
        User user = service.findByEmail(email);

        if (!parser.comparePassword(password, user.getPassword())) {
            System.out.println(String.format("Attempt login with email: %s and password: %s", email, password));
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad credentials!");
        }

        return jwtUtils.createJWT(UUID.randomUUID().toString(), "ISC517 Final", "Access Token", email);
    }

    @GetMapping("/users")
    public List<User> all() {
        return service.all();
    }

    @GetMapping("/users/employees")
    public List<User> employees() {
        return service.getAllEmployees();
    }

    @GetMapping("/users/clients")
    public List<User> clients() {
        return service.getAllClients();
    }

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        
        if (service.existsByEmail(user.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already taken!");
        }

        String hashPassword = parser.getHashedPassword(user.getPassword());
        user.setPassword(hashPassword);

        return service.createOrUpdate(user);
    }

    @GetMapping("/users/{id}")
    public User find(@PathVariable(value="id") long id) {

        return service.findById(id);
    }

    @GetMapping("/users/email/{email}")
    public User findByEmail(@PathVariable(value="email") String email) {

        return service.findByEmail(email);
    }

    @PutMapping("/users/{id}")
    public User update(@PathVariable(value="id") long id, @RequestBody User user) {

        if (!service.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User doesn\'t exist!");
        }

        user.setId(id);
        return service.createOrUpdate(user);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable(value="id") long id) {

        if (!service.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User doesn\'t exist!");
        }

        service.delete(id);
    }
}
