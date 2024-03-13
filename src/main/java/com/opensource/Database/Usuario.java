package com.opensource.Database;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Data
@Table(name="users")
public class User implements UserDetails{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long userId;
	@Column(unique=true)
    private String username;
    private String password;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
        name="user_role_junction",
        joinColumns = {@JoinColumn(name="user_id")},
        inverseJoinColumns = {@JoinColumn(name="role_id")}
    )
    
    private Set<Role> authorities;
    
    public User() {
        super();
        authorities = new HashSet<>();
    }
    
    public User(String username, String password, Set<Role> authorities) {
        super();
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }
	
    public User(Integer userId, String username, String password, Set<Role> authorities) {
            super();
            this.userId = userId;
            this.username = username;
            this.password = password;
            this.authorities = authorities;
    }
    
    @Override
    public boolean isAccountNonExpired() {
            
            return true;
	}

    @Override
    public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
    	return true;
    }

    @Override
    public boolean isEnabled() {
    	return true;
    }
        
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
}
