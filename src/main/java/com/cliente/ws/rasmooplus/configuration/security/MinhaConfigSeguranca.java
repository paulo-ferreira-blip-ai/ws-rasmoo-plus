package com.cliente.ws.rasmooplus.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class MinhaConfigSeguranca extends WebSecurityConfigurerAdapter {

    @Autowired
    private MeuFiltro meuFiltro;


    //@Bean: Esta anotação indica que o método configure está sendo usado para configurar um bean gerenciado pelo contêiner Spring.
    @Override
    public void configure(HttpSecurity http) throws Exception { // Este é um método que configura as regras de segurança do Spring Security.
        // Ele recebe um objeto HttpSecurity que permite configurar a segurança HTTP.
        http.authorizeHttpRequests()//Este método configura as regras de autorização para as requisições HTTP.
                .antMatchers(HttpMethod.GET, "/subscription-type").permitAll()//aqui seleciona quais requisições serão liberadas
                .antMatchers(HttpMethod.GET, "/subscription-type/*").permitAll()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .anyRequest().authenticated().and()//aqui as requisiçõe serão passeiveis de autenticação
                .csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(meuFiltro).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
   