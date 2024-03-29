package doyun.lee.api.security.aop;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import doyun.lee.api.security.domain.SecurityProvider;
import doyun.lee.api.security.exception.SecurityRuntimeException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.filter.OncePerRequestFilter;

;

public class SecurityFilter extends OncePerRequestFilter {
    private SecurityProvider provider;

    public SecurityFilter(SecurityProvider provider) {
        this.provider = provider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = provider.resolveToken(httpServletRequest);
        try {
            if (token != null && provider.validateToken(token)) {
                Authentication auth = provider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (SecurityRuntimeException ex) {
            //this is very important, since it guarantees the user is not authenticated at all
            SecurityContextHolder.clearContext();
            httpServletResponse.sendError(ex.getHttpStatus().value(), ex.getMessage());
            return;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}