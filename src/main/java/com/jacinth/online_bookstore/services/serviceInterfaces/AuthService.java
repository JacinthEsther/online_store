package com.jacinth.online_bookstore.services.serviceInterfaces;


import com.jacinth.online_bookstore.dtos.AuthenticationResponse;
import com.jacinth.online_bookstore.dtos.LoginDto;


public interface AuthService {
    AuthenticationResponse login(LoginDto loginDto) ;
}
