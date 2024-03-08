package com.opensource.Persistence;

import com.opensource.Database.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleJpaController 
        extends JpaRepository<Role, Integer>{
        Optional<Role> findByAuthority(String authority);   
}
