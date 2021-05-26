package ma.emsi.TpJPA.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // to configure our security auth
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // we use inMemoryAuthentication to memorise the encoding password using BCrypt Method
        PasswordEncoder encoder = passwordEncoder();
        auth.inMemoryAuthentication().withUser("user1").password(encoder.encode("1234")).roles("USER");
        auth.inMemoryAuthentication().withUser("user2").password(encoder.encode("1234")).roles("USER");
        auth.inMemoryAuthentication().withUser("admin1").password(encoder.encode("1234")).roles("USER","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin(); // Form Default Login
        http.authorizeRequests().antMatchers("/deletePatient").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/pat").hasRole("USER");
        http.exceptionHandling().accessDeniedPage("/403");
        http.authorizeRequests().anyRequest().authenticated();
    }

    // Methods BCrypt to encoding something like password using Bean Annotations
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
