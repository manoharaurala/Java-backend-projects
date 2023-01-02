package com.example.springsecuritydemo2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailsService;

  /*  @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("piddi").password("$2a$10$mgyWvSh.xHWGrV5F3uFsZu//Lg6QSFBfiP6hRGzfpfkWJiWZlWGKy").authorities("user");

        auth.inMemoryAuthentication().withUser("ruby").password("$2a$10$QLcetXw7f1mlK0ZbyTGUeOoryyLJFuK3PNz2rkV06cCMAgQWCAsLC").authorities("admin");

    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);

    }






    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
       System.out.println(bCryptPasswordEncoder.encode("123456"));
       //$2a$10$tIjvQzfKjg/l0DoRmZ3WZeoH2gcf.13wBvFv3B7eKmSTBgHHqQXLy
    }

/*    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //this.logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");
        http.authorizeRequests((requests) -> {
            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)requests.anyRequest()).authenticated();
        });
        http.formLogin();
        http.httpBasic();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //this.logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");
        http.authorizeRequests().antMatchers("/api/user/hello","/admin/changePassword").hasAnyAuthority("user","admin");
        http.authorizeRequests().antMatchers("/api/admin/hello").hasAuthority("admin");
        http.formLogin();
        http.httpBasic();
    }




}
