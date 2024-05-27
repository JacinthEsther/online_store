package com.jacinth.online_bookstore.services.interfaceImpl;


import com.jacinth.online_bookstore.dtos.AuthenticationResponse;
import com.jacinth.online_bookstore.dtos.LoginDto;
import com.jacinth.online_bookstore.entities.User;
import com.jacinth.online_bookstore.exceptions.ResourceNotFoundException;
import com.jacinth.online_bookstore.repositories.UserRepository;
import com.jacinth.online_bookstore.security.JwtService;
import com.jacinth.online_bookstore.security.config.SecureUser;
import com.jacinth.online_bookstore.services.serviceInterfaces.AuthService;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Override
    public AuthenticationResponse login(LoginDto loginDto)  {
        Optional<User> savedUser = userRepository.findByEmail(loginDto.getEmail().toLowerCase());
        if (savedUser.isPresent()){

                try {
                    Authentication authentication = authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(loginDto.getEmail().toLowerCase(), loginDto.getPassword())
                    );
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } catch (BadCredentialsException e) {
                    logger.info("Authentication failed for : {}", loginDto.getEmail());

                    throw new ResourceNotFoundException(e.getLocalizedMessage());
                }
                User foundUser = userRepository.findByEmail(loginDto.getEmail().toLowerCase()).orElseThrow(() -> new UsernameNotFoundException("user not found"));
                SecureUser user = new SecureUser(foundUser);
                String jwtToken = jwtService.generateToken(user);
            logger.info("Authentication was successful for : {}", loginDto.getEmail());

                return AuthenticationResponse.of(jwtToken, user.getUserId());
        }
        throw new ResourceNotFoundException("User not found!!!");
    }
}
