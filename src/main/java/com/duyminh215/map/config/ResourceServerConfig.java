package com.duyminh215.map.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private AuthorizationServerConfig authorizationServerConfig;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.tokenStore(authorizationServerConfig.tokenStore()).resourceId(AuthorizationServerConfig.RESOURCE_ID);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
        .anonymous().disable()
        .authorizeRequests()
        .antMatchers("/users/**").access("hasRole('ADMIN')")
        .antMatchers("/api/**").access("hasRole('ADMIN')")
        .and().exceptionHandling()
                .accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }

}
