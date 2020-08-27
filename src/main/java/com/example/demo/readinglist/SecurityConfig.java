//package com.example.demo.readinglist;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.domain.Example;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.Optional;
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private ReaderRepository readerRepository;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/").access("hasRole('READER')")
//                .antMatchers("/**").permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .failureUrl("/login?error=true");
//    }
//
//    @Override
//    protected void configure(
//            AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(new UserDetailsService() {
//                    @Override
//                    public UserDetails loadUserByUsername(String username)
//                            throws UsernameNotFoundException {
//                        Optional<Reader> userDetails = readerRepository.findByUsername(username);
//                        return userDetails.orElseThrow(() -> new UsernameNotFoundException("User '" + username + "' not found."));
//                    }
//                });
//    }
//
//}