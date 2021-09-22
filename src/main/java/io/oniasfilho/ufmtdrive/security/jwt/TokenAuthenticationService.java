package io.oniasfilho.ufmtdrive.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.oniasfilho.ufmtdrive.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;

@Component
public class TokenAuthenticationService {
    private static long EXPIRATION_TIME;
    private static String SECRET;
    private static final String TOKEN_PREFIX = "Bearer";
    private static final String HEADER_STRING = "Authorization";

    @Value("${ufmt.drive.jwtSecret}")
    public void setSECRET(String secret) {
        SECRET = secret;
    }

    @Value("${ufmt.drive.jwtExpirationMs}")
    private void setEXPIRATION_TIME(long expiration) {
        EXPIRATION_TIME = expiration;
    }

    static void addAuthentication(HttpServletResponse response, String username) {
        String JWT = Jwts.builder().setSubject(username)
//                .setIssuer()
                .setIssuer(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();

        response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
        response.addHeader("Content-Type", "application/json");
        try {
            response.getWriter().write("{\"token\": \"" + JWT + "\"}");
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);

        if (token != null) {
            String user =
                    Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody().getSubject();
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
            }
        }
        return null;
    }
}
