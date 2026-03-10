package com.example.taskmanagement.service;
    // authentication service using spring security that validates username and password
    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.authentication.BadCredentialsException;
    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
    import org.springframework.security.core.Authentication;
    import org.springframework.security.core.context.SecurityContextHolder;
    import org.springframework.stereotype.Service;
    import org.springframework.beans.factory.annotation.Autowired;
    @Service
    public class AuthService {
        @Autowired
        private AuthenticationManager authenticationManager;

        public boolean authenticate(String username, String password) {
            try {
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(username, password)
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
                return true;
            } catch (BadCredentialsException e) {
                return false;
            }
        }
    }

