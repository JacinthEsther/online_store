package com.jacinth.online_bookstore.services.serviceInterfaces;

import java.util.Set;

public interface AuthorityService {
    void addAuthority(Long userId, String role);

    void addAuthorities(Long userId, Set<String> roles);
}
