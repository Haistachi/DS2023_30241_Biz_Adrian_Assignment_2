package measurements.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers(GET, "/treshhold/findByDevice/**").hasAnyAuthority( "ROLE_USER", "ROLE_ADMIN");
        http.authorizeRequests().antMatchers(GET, "/measurement/findByDevice/**").hasAnyAuthority( "ROLE_USER", "ROLE_ADMIN");
        http.authorizeRequests().antMatchers(GET, "/measurement/findByDeviceAndDate/**").hasAnyAuthority( "ROLE_USER", "ROLE_ADMIN");
        http.authorizeRequests().antMatchers( "/measurement/**").hasAnyAuthority( "ROLE_ADMIN");
        http.authorizeRequests().antMatchers( "/treshhold/**").hasAnyAuthority( "ROLE_ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilterBefore(new CustomAuthorizationFilter(), BasicAuthenticationFilter.class);
    }
}
