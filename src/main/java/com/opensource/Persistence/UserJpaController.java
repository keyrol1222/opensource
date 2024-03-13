package com.opensource.Persistence;

import com.opensource.Database.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaController 
        extends JpaRepository<Usuario, Integer>{
    
    Optional<Usuario> findByUsername(String username);
}
