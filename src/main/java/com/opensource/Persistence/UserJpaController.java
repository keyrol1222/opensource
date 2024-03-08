package com.opensource.Persistence;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaController 
        extends JpaRepository<User, Integer>{
    
    Optional<User> findByUsername(String username);
}
