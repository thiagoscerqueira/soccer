package br.com.agility.soccerbackend.security

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

class JWTAuthenticationFilter : GenericFilterBean() {

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, filterChain: FilterChain?) {
        var authentication = TokenAuthenticationService().getAuthentication(request as HttpServletRequest);
        SecurityContextHolder.getContext().authentication = authentication;
        filterChain?.doFilter(request, response);
    }
}