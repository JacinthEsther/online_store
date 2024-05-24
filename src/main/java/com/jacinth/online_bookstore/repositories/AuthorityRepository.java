package com.jacinth.online_bookstore.repositories;

import com.jacinth.online_bookstore.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
