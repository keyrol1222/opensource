package com.opensource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.opensource.Persistence.Usuarios.RepositorioUsuarios;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    
    private final JwtAthFilter jwtAuthFilter;
    private final RepositorioUsuarios repositorioUsuarios;

@Bean
  public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
   http
       .authorizeRequests()
       .anyRequest()
       .authenticated()
       .and()
       .sessionManagement()
       .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
       .and()
       .authenticationProvider(authenticationProvider())
       .addFilterBefore(jwtAuthFilter,UsernamePasswordAuthenticationFilter.class);
   return http.build();
  }


  @Bean
  public AuthenticationProvider authenticationProvider() {
    final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService());
    authenticationProvider.setPasswordEncoder(passwordEncoder());
   return authenticationProvider;
 }


  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    return config.getAuthenticationManager();
  }

 

  @Bean
  public PasswordEncoder passwordEncoder(){
    // return new BCryptPasswordEncoder();  // Para encriptar las contraseñas
    return NoOpPasswordEncoder.getInstance(); 
 }

  public UserDetailsService userDetailsService() {
       return new UserDetailsService() {

        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
         return RepositorioUsuarios.findUserByEmail(email);
        }       
    };
  }
}
