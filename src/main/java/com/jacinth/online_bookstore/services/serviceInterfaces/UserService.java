package com.jacinth.online_bookstore.services.serviceInterfaces;

import com.jacinth.online_bookstore.dtos.RegisterUserDto;
import com.jacinth.online_bookstore.entities.User;
import org.springframework.security.core.Authentication;


import java.util.List;
import java.util.Optional;

public interface UserService {

    String saveUser(RegisterUserDto request);

    User retrieveACustomerBy(String email);

    boolean isUserAdmin(String email, Authentication authentication);

    List<User> retrieveAllCustomers();

    Optional<User> findById(Long userId);
}
