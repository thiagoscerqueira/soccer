package br.com.agility.soccerpayment.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class TokenAuthenticationService {

    val EXPIRATION_DATE: Long = 860_000_000;
    val SECRET: String = "MySecret";
    val TOKEN_PREFIX: String = "Bearer";
    val HEADER_STRING: String = "Authorization";

    fun addAuthentication(response: HttpServletResponse, username: String) {
        var jwt = Jwts.builder()
                .setSubject(username)
                .setExpiration(Date(System.currentTimeMillis() + EXPIRATION_DATE))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();

        response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + jwt);
    }

    fun getAuthentication(request: HttpServletRequest): Authentication? {
        var token = request.getHeader(HEADER_STRING);
        if (token == null) {
            return null;
        }

        var user = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .body
                .subject;

        if (user != null) {
            return UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
        }

        return null;
    }
}