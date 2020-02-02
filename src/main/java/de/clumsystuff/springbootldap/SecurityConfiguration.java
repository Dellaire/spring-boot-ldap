package de.clumsystuff.springbootldap;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/protected/**").authenticated()
                .and().formLogin();

        //http.csrf().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .ldapAuthentication()
                .userDnPatterns("cn={0},dc=company")
                .userSearchBase("")
                .groupSearchBase("")
                //.groupSearchFilter("")
                //.userSearchFilter("")
                //.groupRoleAttribute("lol")
                .contextSource()
                .url("ldap://localhost");
                //.root("");
                //.managerDn("a")
                //.managerPassword("b")
                //.and()
                //.passwordCompare()
                //.passwordEncoder(new BCryptPasswordEncoder())
                //.passwordAttribute("userPassword");
    }
}
