package com.opensource.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAthFilter extends OncePerRequestFilter{
    
    @Override
    protected void doFilterInternal(
    
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException{
        
        final String authHeader = request.getHeader(AUTHORIZATION);
        final String UserEmail;
        final String jwtToken;
        
        if(authHeader == null || !authHeader.startsWith("Bearer"));
    }
    
}
