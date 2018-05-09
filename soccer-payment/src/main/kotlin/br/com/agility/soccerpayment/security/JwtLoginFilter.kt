package br.com.agility.soccerpayment.security

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtLoginFilter : AbstractAuthenticationProcessingFilter {

    constructor(url: String, authManager: AuthenticationManager) : super(AntPathRequestMatcher(url)) {
        setAuthenticationManager(authManager);
    }

    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
        var credenciais: Credenciais = ObjectMapper().readValue(request?.inputStream, Credenciais::class.java);
        return authenticationManager.authenticate(UsernamePasswordAuthenticationToken(credenciais.username, credenciais.password, Collections.emptyList()));
    }

    override fun successfulAuthentication(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain, auth: Authentication) {
        TokenAuthenticationService().addAuthentication(response, auth.name);
    }

}