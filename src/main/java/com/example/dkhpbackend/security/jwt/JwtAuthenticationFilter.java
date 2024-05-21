package com.example.dkhpbackend.security.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.dkhpbackend.service.impl.CustomUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils tokenGenerate;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Get Token
        String token = getJwtFromRequest(request);

        // Check token validate
        if (StringUtils.hasText(token) && tokenGenerate.validateToken(token)) {

            // Get username from token
            String username = tokenGenerate.extractSubject(token);

            // Get user details
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

            // Username Password Authentication Token
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());

            // Set Authentication Details
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            // Security Context Holder
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        // Filter Dofilter
        filterChain.doFilter(request, response);
    }

    // Get JWT Token from Request
    private String getJwtFromRequest(HttpServletRequest request) {
        // Get token from header
        String bearerToken = request.getHeader("Authorization");

        // Check
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            // Return
            return bearerToken.substring(7);
        }

        // Return null
        return null;
    }
}
