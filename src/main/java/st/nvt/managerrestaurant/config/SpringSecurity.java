package st.nvt.managerrestaurant.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import st.nvt.managerrestaurant.util.EncodePassword;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
    @Autowired
    private UserDetailsService userDetailsService;

    // Configure SecurityFilterChain
    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/creation-food/**").hasAuthority("ADMIN")
                .requestMatchers("/add-food/**").hasAuthority("ADMIN")
                .requestMatchers("/cart/**").authenticated()
                .requestMatchers("/addToCart/**").authenticated()
                .requestMatchers("/login/**").permitAll()
                .requestMatchers("/sign-up/**").permitAll()
                .requestMatchers("/home/**").permitAll()
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/js/**").permitAll()
                .requestMatchers("/images/**").permitAll()
                .requestMatchers("/img/**").permitAll()
                .requestMatchers("/food/**").permitAll()
                .requestMatchers("/error/**").permitAll()
                .requestMatchers("/?continue/**").permitAll()
                .requestMatchers("/about-us/**").permitAll()
                .and()
                .formLogin(
                    form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                )
                .logout(
                    logout -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                )
                .sessionManagement()
                .maximumSessions(1)
                .expiredUrl("/login?expired");
        return httpSecurity.build();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService)
                .passwordEncoder(EncodePassword.passwordEncoder());
    }

}
