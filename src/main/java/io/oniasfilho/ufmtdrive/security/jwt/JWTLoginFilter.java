package io.oniasfilho.ufmtdrive.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.oniasfilho.ufmtdrive.entity.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {


   public JWTLoginFilter(String url, AuthenticationManager authManager){
       super(new AntPathRequestMatcher(url));
       setAuthenticationManager(authManager);
   }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
       return getAuthenticationManager().authenticate(
               new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(),
                       Collections.emptyList()));
    }

    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain filterChain, Authentication auth) throws IOException, ServletException{
       TokenAuthenticationService.addAuthentication(response, auth.getName());
    }


}
