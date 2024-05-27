package com.jacinth.online_bookstore.dtos;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Set;

@Data
public class AddAuthoritiesDTO {
    private Long userId;

    @Pattern(regexp = "^(?i)(user|admin|superUser)$", message = "Role should be 'user' or 'admin' or 'superUser")
    private Set<String> roles;
}
