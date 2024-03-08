package com;

import java.io.IOException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.opensource.Persistence.Usuarios.RepositorioUsuarios;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAthFilter extends OncePerRequestFilter {
    
    private final RepositorioUsuarios repositorioUsuarios;
    private final JwtUtils jwtUtils;
    
    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain) throws ServletException, IOException {
      final String authHeader = request.getHeader("AUTORIZACIÓN");
      final String userEmail;
      final String jwtToken;

      if (authHeader == null || !authHeader.startsWith("Portador")) {
          filterChain.doFilter(request, response);
          return;
      }
      jwtToken = authHeader.substring(7);
      userEmail = jwtUtils.extractUsername(jwtToken);
      if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        UserDetails userDetails = repositorioUsuarios.findUserByEmail(userEmail);
        if (jwtUtils.isTokenValid(jwtToken, userDetails)) {
         UsernamePasswordAuthenticationToken authToken =
           new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
         authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
         SecurityContextHolder.getContext().setAuthentication(authToken);
        }
    }
    filterChain.doFilter(request, response);
  }
}
