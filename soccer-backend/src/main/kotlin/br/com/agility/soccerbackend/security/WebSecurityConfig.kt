package br.com.agility.soccerbackend.security

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http?.csrf()?.disable()?.authorizeRequests()
                ?.antMatchers("/home")?.permitAll()
                ?.antMatchers(HttpMethod.POST, "/login")?.permitAll()
                ?.anyRequest()?.permitAll();

        /*.authenticated()
                ?.and()
                ?.addFilterBefore(JwtLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter::class.java)
                ?.addFilterBefore(JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter::class.java)*/
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.inMemoryAuthentication()?.withUser("admin")?.password("123")
                ?.roles("ADMIN");
    }
}